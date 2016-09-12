package com.intexsoft.simplemessanger.client.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.intexsoft.simplemessanger.webservice.ProtocolWebService;

@Component
public class JmsWebSocketHandler extends TextWebSocketHandler
{
	@Autowired
	private ProtocolWebService protocolWebService;

	private Map<String, WebSocketSession> sessions = new HashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception
	{
		super.afterConnectionEstablished(session);
		sessions.put(session.getId(), session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
	{
		if (message.getPayload().contains("hello"))
		{
			boolean r = protocolWebService.sayHello();
			session.sendMessage(new TextMessage(String.format("{\"status\": \"success\", \"data\": %s}", r)));
		} else {
			session.sendMessage(new TextMessage("{\"status\": \"success\", \"data\": true}"));
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception
	{
		super.afterConnectionClosed(session, status);
		sessions.remove(session.getId());
	}
}
