package com.bit.boot08.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	private static Map<String,WebSocketSession> list=new HashMap<>();
	
	public static Map<String, WebSocketSession> getList() {
		return list;
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("접속closed...");
		list.remove(session.getAttributes().get("sid"));
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("websocket sessionID:"+session.getId());
//		for(Entry<String, Object> entry:session.getAttributes().entrySet()) {
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
		list.put((String)(session.getAttributes().get("sid")),session);
		
	}
	
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println("메시지 수신..."+message);
		for(WebSocketSession sock:list.values())sock.sendMessage(message);
	}

}














