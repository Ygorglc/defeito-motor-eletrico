package com.costa.ygor.defeito_motor_eletrico.controller.request;

public record UsuarioRequest(
        String email,
        String senha,
        String nome
) {
}
