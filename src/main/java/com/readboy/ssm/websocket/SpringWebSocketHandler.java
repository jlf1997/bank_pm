package com.readboy.ssm.websocket;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class SpringWebSocketHandler extends TextWebSocketHandler {
	//后面改成Map存
	private static final Map<String,WebSocketSession> users;
    private static Logger logger = Logger.getLogger(SpringWebSocketHandler.class);
    static {
        users = new HashMap<String,WebSocketSession>();
    }
    
    public SpringWebSocketHandler() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("connect to the websocket success......当前数量:"+users.size());
        String userid = (String) session.getAttributes().get("WEBSOCKET_USERID");
        users.put(userid, session);
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
//        TextMessage returnMessage = new TextMessage("你将收到的离线");
//        session.sendMessage(returnMessage);
    }
    
    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.debug("websocket connection closed......");
        String userid= (String) session.getAttributes().get("WEBSOCKET_USERID");
        System.out.println("用户"+userid+"已退出！");
        users.remove(userid);
        System.out.println("剩余在线用户"+users.size());
    }

    /**
     * js调用websocket.send时候，会调用该方法
     */
    @Override    
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        String jsonStr = message.getPayload().toString();
        int index = jsonStr.indexOf("|||");
        String title = jsonStr.substring(0,index);
        String content = jsonStr.substring(index+3);
        //将页面传来的Json字符串转为Json对象
		JSONObject obj = new JSONObject();
		obj.put("title", title);
        obj.put("content",content);
        obj.put("operation", "broadcast");
        logger.debug("message:"+message.getPayload().toString());
        TextMessage returnMessage = new TextMessage(obj.toString());
        sendMessageToUsers(returnMessage);
    }
    
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){session.close();}
        logger.debug("websocket connection closed......");
        users.remove(session);
    }

    public boolean supportsPartialMessages() {
        return false;
    }
    
    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(Map<String,String> map, TextMessage message) {
    	Iterator iter = users.entrySet().iterator();
    	while (iter.hasNext()) {
    		Map.Entry entry = (Map.Entry) iter.next();
    		WebSocketSession user = (WebSocketSession) entry.getValue();
    		String websocket_userid = (String) user.getAttributes().get("WEBSOCKET_USERID");
    		if(user.isOpen() &&  websocket_userid != null){
    			//已有该账号登录但不是最近登录的那个，给先前登录的人发消息
    			if(websocket_userid.startsWith(map.get("userid"))&& !websocket_userid.contains(map.get("ip"))){
    				try {
    					user.sendMessage(message);
    					System.out.println("消息发送："+websocket_userid);
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}
    	}
    } 
    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
    	Iterator iter = users.entrySet().iterator();
    	while (iter.hasNext()) {
    		Map.Entry entry = (Map.Entry) iter.next();
    		WebSocketSession user = (WebSocketSession) entry.getValue();
    		String websocket_userid = (String) user.getAttributes().get("WEBSOCKET_USERID");
    		if(user.isOpen() &&  websocket_userid != null){
    			try {
    				user.sendMessage(message);
    				System.out.println("发送给了:"+websocket_userid);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	}
    }	
}
