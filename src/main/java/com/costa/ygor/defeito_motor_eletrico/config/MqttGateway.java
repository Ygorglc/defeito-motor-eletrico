package com.costa.ygor.defeito_motor_eletrico.config;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {

	void senToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
