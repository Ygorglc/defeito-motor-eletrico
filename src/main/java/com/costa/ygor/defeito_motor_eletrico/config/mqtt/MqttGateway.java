package com.costa.ygor.defeito_motor_eletrico.config.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutputChannel")
public interface MqttGateway {
    void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
