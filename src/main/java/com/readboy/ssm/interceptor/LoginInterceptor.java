package com.readboy.ssm.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.utils.JavaWebToken;

/*
 * 登录拦截器
 * */
public class LoginInterceptor implements HandlerInterceptor{

	//在进入Handler之前进行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		
		//若url是公开地址,放行
		System.out.println("preHandle");
		if(url.indexOf("pcLogin.action") >=0 || url.indexOf("/mobile/login.action") >= 0){
			return true;
		}
		if(url.indexOf("/websocket/socketServer") >= 0){
			return true;
		}
		if(url.indexOf("/mobile/QueryApkInfo") >= 0){
			return true;
		}
		if(url.indexOf("/DownloadApk") >= 0){
			return true;
		}	
		if(url.indexOf("/swagger-ui.html") >= 0 || url.indexOf(".png")>=0 ) {
			return true;
		}
		
		if(url.indexOf("/configuration/ui") >= 0) {
			return true;
		}
		
		if(url.indexOf("/demo/") >= 0) {
			return true;
		}
		
//		if(url.indexOf("/UploadApkView") >= 0){
//			return true;
//		}
		if(url.indexOf("/mobile/") >= 0){//请求来自手机端
			String token = request.getParameter("token");
			Map<String,Object> claims = JavaWebToken.parserJavaWebToken(token);
			if(claims != null){
				return true;
			}else{
				return false;
			}
		}else{//请求来自PC端
			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("SESSION_USERID");
			if(userid != null){
				//已经登录,放行
				return true;
			}
			//没有登录或者session过期不往下执行了，跳转到登录页面
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>window.parent.frames.location.href='login.jsp';</script>");
			return false;
		}
	}
	//进入Handler之后，返回ModelAndView之前执行
	//应用从ModelAndView出发，返回公共的数据（如菜单导航）
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
	}

	//Handler执行完后执行，应用场景：统一日志、异常处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}
}
