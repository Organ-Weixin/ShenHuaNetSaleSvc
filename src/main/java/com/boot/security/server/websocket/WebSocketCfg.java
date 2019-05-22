package com.boot.security.server.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.SpringConfigurator;

public class WebSocketCfg extends SpringConfigurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec,HandshakeRequest request, HandshakeResponse response) {
		super.modifyHandshake(sec, request, response);
		HttpSession httpSession = (HttpSession)request.getHttpSession();
		sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
	}
	
	/*
	 * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket 
	 */
	@Bean  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();  
    }
}
