package com.costa.ygor.defeito_motor_eletrico.controller;

import com.costa.ygor.defeito_motor_eletrico.config.mqtt.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttGateway mqttGateway;

    @PostMapping("/sendMsg/{data}/{topic}")
    public String sendMsg(@PathVariable String data,@PathVariable String topic) {
        mqttGateway.sendToMqtt(data, topic);
        return "success";
    }
}
