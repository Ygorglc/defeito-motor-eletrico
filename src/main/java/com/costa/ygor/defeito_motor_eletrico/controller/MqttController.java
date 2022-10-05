package com.costa.ygor.defeito_motor_eletrico.controller;


import com.costa.ygor.defeito_motor_eletrico.config.MqttGateway;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {
	@Autowired
	MqttGateway mqtGateway;
	@PostMapping("/sendMessage")
	@Operation(summary = "Manda mensagem para um topico mqtt",
			description = "Manda mensagem para um topico mqtt",
			tags = {"mqtt"})
	public ResponseEntity<?> publish(@RequestBody String mqttMessage){
		
		try {
		JsonObject convertObject = new Gson().fromJson(mqttMessage, JsonObject.class);
		mqtGateway.senToMqtt(convertObject.get("message").toString(), convertObject.get("topic").toString());
		return ResponseEntity.ok("Success");
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.ok("fail");
		}
	}

}
