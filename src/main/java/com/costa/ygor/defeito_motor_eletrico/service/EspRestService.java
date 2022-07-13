package com.costa.ygor.defeito_motor_eletrico.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class EspRestService {
    private String URI_INICIA_VALORES = "192.168.1.25/init_values";

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public String iniciarDados(){
        log.info("Iniciando dados!!");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(URI_INICIA_VALORES, HttpMethod.GET, formEntity, String.class);
        return response.getBody();
    }
}
