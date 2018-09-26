package com.readboy.ssm.websocket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSONObject;

@Controller
public class WebsocketController {
    @Bean//这个注解会从Spring容器拿出Bean
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }

    @RequestMapping(value="/websocket/login")
    @ResponseBody
  public ModelAndView login(HttpServletRequest request,@RequestBody String data, HttpServletResponse response) throws Exception {
//    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String username = request.getParameter("username");
        if (username==null){
        	if (data!=null){
        		JSONObject jsonObject =  JSONObject.parseObject(data);
        		username = jsonObject.getString("username");
        	}
        }
        System.out.println(username+"登录");
        HttpSession session = request.getSession(true);
        session.setAttribute("SESSION_USERNAME", username);
        //response.sendRedirect("/quicksand/jsp/websocket.jsp");
        return new ModelAndView("websocket");
    }

    @RequestMapping("/websocket/send")
    @ResponseBody
    public String send(HttpServletRequest request) {
        String username = request.getParameter("username");
      //  infoHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        return null;
    }
    
    @RequestMapping("/websocket/sendmsg")
    @ResponseBody
    public String sendMsg(HttpServletRequest request) {
        String username = request.getParameter("username");
        String msg = request.getParameter("msg");
       // infoHandler().sendMessageToUser(username, new TextMessage(msg));
        return null;
    }    
}
