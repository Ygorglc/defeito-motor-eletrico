package com.costa.ygor.defeito_motor_eletrico.controller;


import com.costa.ygor.defeito_motor_eletrico.controller.request.CredenciaisRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.request.UsuarioRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TokenResponse;
import com.costa.ygor.defeito_motor_eletrico.controller.response.UsuarioResponse;
import com.costa.ygor.defeito_motor_eletrico.exception.SenhaInvalidaException;
import com.costa.ygor.defeito_motor_eletrico.service.LoginService;
import com.costa.ygor.defeito_motor_eletrico.service.UsuarioService;
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
@RequestMapping("/v1/acesso/")
public class LoginAdminController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private LoginService loginService;
    private UsuarioService usuarioService;

    public LoginAdminController(LoginService loginService,
                                UsuarioService usuarioService) {
        this.loginService = loginService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
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

    @PostMapping("/novo-usuario")
    @Operation(summary = "Cria o login de um novo usuario",
            description = "Cria o login do novo usuario para acesso do aplicativo.",
            tags = {"admin"})
    public UsuarioResponse criaNovoUsuario(@RequestBody UsuarioRequest usuarioRequest) throws Exception {

            return  usuarioService.criandoUsuario(usuarioRequest);

    }
}
