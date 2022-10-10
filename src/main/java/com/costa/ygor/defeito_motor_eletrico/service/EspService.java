package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.config.mqtt.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspService {

    @Autowired
    private MqttGateway mqttGateway;

    public String coletarDadosEsp(){
        mqttGateway.sendToMqtt("testeDados", "topicoDados");
        return "success";
    }
}
