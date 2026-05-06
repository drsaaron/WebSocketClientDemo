/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class ClientSessionHandler extends StompSessionHandlerAdapter {

    @Autowired
    private StompFrameHandler privateMessageHandler;
    
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        
        session.subscribe("/topic/public", new PublicMessageHandler());

        session.subscribe("/user/queue/private", privateMessageHandler);

        log.info("✅ Connected and subscribed");
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

        log.error("❌ Transport error: " + exception.getMessage());
    }
}
