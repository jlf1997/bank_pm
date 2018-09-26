package com.readboy.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSONObject;
import com.readboy.ssm.exception.CustomException;
import com.readboy.ssm.po.StaffAndPost;
import com.readboy.ssm.po.StaffInfo;
import com.readboy.ssm.po.User;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.service.StaffAndPostService;
import com.readboy.ssm.service.StaffInfoService;
import com.readboy.ssm.service.UserService;
import com.readboy.ssm.utils.EncryptHelper;
import com.readboy.ssm.utils.JavaWebToken;
import com.readboy.ssm.utils.LoginStatusMessage;
import com.readboy.ssm.websocket.SpringWebSocketHandler;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private StaffInfoService staffInfoService;
	@Autowired 
	private StaffAndPostService staffAndPostService;
	
	private static final String offLineStr = "off-line";
	//------------------------手机端登录Controller-----------------------------
	@ResponseBody
	@RequestMapping(value="/mobile/login.action",method={RequestMethod.POST,RequestMethod.GET})
	public LoginStatusMessage checkUserAndPassword(
	@RequestParam(value="username",required=true) String username,
	@RequestParam(value="password",required=true) String password,User user,HttpServletRequest request) throws Exception{
		System.out.println("进登录里面");
		User u = new User();
		//登录成功
		if((u = userService.checkUsernameAndPassword(user)) != null){
			Map<String,Object> m = new HashMap<String,Object>();
			long userid = u.getUserid();
			String addr = request.getRemoteAddr();
			Map map = new HashMap<String,String>();
			map.put("userid", userid+"");
			map.put("ip", addr);
			//发消息给之前已在登录状态的客户端
			JSONObject jsonObject = new JSONObject(); 
			jsonObject.put("operation",offLineStr);
			jsonObject.put("title","title");
			jsonObject.put("content","content");
		    String json = jsonObject.toJSONString();
			new SpringWebSocketHandler().sendMessageToUser(map, new TextMessage(json));
			m.put("userid", userid+"");
			String token = JavaWebToken.createJavaWebToken(m);
			System.out.println(token);
			LoginStatusMessage lsm = new LoginStatusMessage();
			lsm.setUser(u);
			lsm.setToken(token);
			
//			Date d = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String lastlogintime = sdf.format(d);
//			userService.updateLastLoginTimeByUserid(u.getUserid(), lastlogintime);
			// 查找StaffInfo
			StaffInfo staffInfo = null;
			StaffAndPost staffAndPost = staffAndPostService.findStaffAndPostByYggh(""+u.getTellId());
			if(staffAndPost != null){
				 staffInfo  = staffInfoService.findStaffInfoByConditions(staffAndPost.getZzbz(), staffAndPost.getGwbz(), ""+u.getTellId());
			}
			lsm.setStaffInfo(staffInfo);
	        return lsm;
		};
		//登录失败，返回Null
		return null;
	}
	
	//退出登录s
	@ResponseBody
	@RequestMapping(value="/mobile/logout.action",method={RequestMethod.POST,RequestMethod.GET})
	public void mobileLogout(
	@RequestParam(value="userid",required=true)long userid, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(false);
		session.removeAttribute("SESSION_USERID");
		//更新登录状态为0
		userService.updateLoginStatusByUserid(userid, 0);
	}
	
	//--------------PC端登录Controller------------
	@RequestMapping(value="/pcLogin.action",method={RequestMethod.POST,RequestMethod.GET})
	public String pcLogin(
	@RequestParam(value="username",required=true) String username,
	@RequestParam(value="password",required=true) String password,
	HttpServletRequest req,HttpServletResponse resp,Model model) throws Exception{	
		//登录成功
		User user = new User();
		user.setUsername(username);
		user.setPassword(EncryptHelper.md5(password));
		User u = new User();
		if((u = userService.checkUsernameAndPassword(user)) != null){
			HttpSession session = req.getSession(true);
	        session.setAttribute("SESSION_USERID", u.getUserid()+"");
	        session.setAttribute("admin",u);
	        model.addAttribute("user",u);
	        return "index";
		};
		model.addAttribute("info","用户名或密码错误！");
		//登录失败，回到失败页面
		return "../../login";
	}
	
	//编辑用户信息
	@RequestMapping(value="/updatePasswordByUserid.action",method={RequestMethod.POST,RequestMethod.GET})
	public void updateUserInfo(@RequestParam("userid") long userid,
			@RequestParam("pwd2") String password,HttpServletResponse resp,
			HttpServletRequest req) throws Exception{
		//加密密码
		password = EncryptHelper.md5(password);
		long flag = userService.updatePasswordByUserid(userid, password);
		if(flag > 0){
			HttpSession session = req.getSession(false);
			session.removeAttribute("SESSION_USERID");
			session.removeAttribute("admin");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}else{
			req.getRequestDispatcher("fail.jsp").forward(req, resp);
			return;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/logout.action",method={RequestMethod.POST,RequestMethod.GET})
	public String logout(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		HttpSession session = req.getSession(false);
		session.removeAttribute("SESSION_USERID");
		session.removeAttribute("admin");
		return "<script type='text/javascript'>window.location.href='login.jsp'</script>";
	}
}
