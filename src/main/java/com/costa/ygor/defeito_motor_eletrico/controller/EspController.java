package com.costa.ygor.defeito_motor_eletrico.controller;

import com.costa.ygor.defeito_motor_eletrico.service.EspService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/controle-esp")
public class EspController {

    private final EspService espService;

    public EspController(EspService espService) {
        this.espService = espService;
    }

    @GetMapping("/dados")
    @ResponseStatus(HttpStatus.OK)
    public String coletandoDadosEsp(){
        return espService.coletarDadosEsp();
    }

}
