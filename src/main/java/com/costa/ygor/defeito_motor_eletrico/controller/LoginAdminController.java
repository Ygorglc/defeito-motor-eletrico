package com.costa.ygor.defeito_motor_eletrico.controller;


import com.costa.ygor.defeito_motor_eletrico.controller.request.CredenciaisRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TokenResponse;
import com.costa.ygor.defeito_motor_eletrico.exception.SenhaInvalidaException;
import com.costa.ygor.defeito_motor_eletrico.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/v1/login-admin/auth")
public class LoginAdminController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private LoginService loginService;

    public LoginAdminController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    @Operation(summary = "Autenticação do administrador",
                description = "Faz o login do usuario admin retornando o token de acesso.",
                tags = {"admin"})
    public TokenResponse autenticar(@RequestBody CredenciaisRequest credenciaisRequest, HttpServletResponse response) throws Exception {
        log.info("O Usuario de cpf {} está se logando.",credenciaisRequest.login());
        try {
            return  loginService.servicoDeAutenticacao(credenciaisRequest, response);
        }catch (UsernameNotFoundException | SenhaInvalidaException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
