package com.readboy.ssm.websocket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class ValidInterceptor extends HandlerInterceptorAdapter {
	private static Logger log = LoggerFactory.getLogger(ValidInterceptor.class); 
	  @Override
	    public boolean preHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler) throws Exception {
		  String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  log.info("username:"+username+" password:"+password);
		  
		  return true;	  
	  }
	  
	    @Override
	    public void postHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	    	log.info("ValidInterceptor-----------postHandle");
	    }
	    
	    @Override
	    public void afterCompletion(HttpServletRequest request,
	            HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	    	log.info("ValidInterceptor-----------afterCompletion");
	    }	  
}

