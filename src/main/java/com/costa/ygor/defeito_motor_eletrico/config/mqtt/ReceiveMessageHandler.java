package com.costa.ygor.defeito_motor_eletrico.config.mqtt;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class ReceiveMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
        if ("hello".equalsIgnoreCase(topic)) {
            System.out.println("hello, " + message.getPayload().toString());
        } else {
            System.out.println("hi, " + message.getPayload().toString());
        }
    }

}
