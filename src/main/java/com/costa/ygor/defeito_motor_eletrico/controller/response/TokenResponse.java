package com.costa.ygor.defeito_motor_eletrico.controller.response;

public record TokenResponse(
        String login,
        String nome,
        String token
) {
}
