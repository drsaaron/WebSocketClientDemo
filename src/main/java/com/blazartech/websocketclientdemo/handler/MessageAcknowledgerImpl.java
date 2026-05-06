/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 *
 * @author scott
 */
@Component
@Slf4j
public class MessageAcknowledgerImpl implements MessageAcknowledger {

    @Autowired
    private RestClient restClient;
    
    @Override
    public void acknowledgeMessage(Long messageId) {
        log.info("sending acknowledgement for message {}", messageId);
        restClient.post()
                .uri("/" + messageId + "/delivered")
                .retrieve()
                .toBodilessEntity();
                
    }
    
}
