package com.bit.boot07.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer{

	@Bean
	public WebSocketHandler getWebSocketHandler() {
		return new EchoHandler();
	}
		
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		WebSocketHandlerRegistration reg=null;
		reg=registry.addHandler(getWebSocketHandler(), "/echo");
		reg.addInterceptors(new HttpSessionHandshakeInterceptor());
	}
	

}













