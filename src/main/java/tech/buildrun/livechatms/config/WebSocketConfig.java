package tech.buildrun.livechatms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	    //configuração do stomp broker
	    @Override
	    public void configureMessageBroker(MessageBrokerRegistry registry) {
	        registry.enableSimpleBroker("/topics");	  
	        //prefixo da aplicação
	        registry.setApplicationDestinationPrefixes("/app");
	    }

	    //endpoint do websocket
	    @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry) {
	        registry.addEndpoint("/buildrun-livechat-websocket");
	    }
}
