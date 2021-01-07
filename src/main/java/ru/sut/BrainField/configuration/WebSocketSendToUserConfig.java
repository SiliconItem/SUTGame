package ru.sut.BrainField.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketSendToUserConfig implements WebSocketMessageBrokerConfigurer {

    private static Logger log = LoggerFactory.getLogger(WebSocketSendToUserConfig.class);

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        log.info("=====>>>> BROKER (SendToUser): configureMessageBroker");
        config.enableSimpleBroker("/topic/", "/queue/");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        log.info("=====>>>> STOPM (SendToUser): Endpoint enable");
        registry.addEndpoint("/greeting").setHandshakeHandler(new DefaultHandshakeHandler() {

            //Get sessionId from request and set it in Map attributes
            public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                           WebSocketHandler wsHandler, Map attributes) throws Exception {
                if (request instanceof ServletServerHttpRequest) {
                    ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
                    HttpSession session = servletRequest.getServletRequest().getSession();
                    attributes.put("sessionId", session.getId());
                }
                return true;
            }}).withSockJS();
    }
}
