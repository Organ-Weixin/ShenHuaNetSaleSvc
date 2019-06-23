package com.boot.security.server.websocket;



import org.springframework.context.annotation.Configuration;

/*
 * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket 
 */
@Configuration
public class WebSocketConfig{  

	/*@Bean  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();  
    }*/
}
