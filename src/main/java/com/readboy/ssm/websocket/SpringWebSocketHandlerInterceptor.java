package com.readboy.ssm.websocket;

import java.util.Map;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.readboy.ssm.utils.JavaWebToken;


public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {
	
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Before Handshake");
       
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
           if (session != null) {
                //使用userid区分WebSocketHandler，以便定向发送消息
                String userid = (String) session.getAttribute("SESSION_USERID");
                attributes.put("WEBSOCKET_USERID",userid);
                System.out.println("电脑端WebSocket保存了"+userid);
           }else{
        	   HttpServletRequest req = servletRequest.getServletRequest();
        	   String addr = req.getRemoteAddr();
        	   System.out.println("地址："+addr);
        	   String token = req.getParameter("token");
        	   Map<String, Object> claims = JavaWebToken.parserJavaWebToken(token);
        	   //已经获得token，说明已经登录有了权限
        	   if(claims != null){
        		   String userid =  (String) claims.get("userid");
        		   //WERSOCKETSESSION用userid+IP地址做标识
        		   attributes.put("WEBSOCKET_USERID",userid+addr);
        		   System.out.println("手机端端WebSocket保存了"+userid);
        	   }
           }
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
    
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
