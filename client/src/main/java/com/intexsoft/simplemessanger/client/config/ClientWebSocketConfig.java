package com.intexsoft.simplemessanger.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.intexsoft.simplemessanger.client.websocket.JmsWebSocketHandler;

@Configuration
@EnableWebSocket
@Controller
@ComponentScan("com.intexsoft.simplemessanger.client.websocket")
public class ClientWebSocketConfig implements WebSocketConfigurer
{
	@Autowired
	private JmsWebSocketHandler jmsWebSocketHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
	{
		registry.addHandler(jmsWebSocketHandler, "/jms")
				.setAllowedOrigins("*");
	}
}
