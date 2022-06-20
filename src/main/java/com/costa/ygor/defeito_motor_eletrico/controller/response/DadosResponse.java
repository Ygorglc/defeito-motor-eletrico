package com.costa.ygor.defeito_motor_eletrico.controller.response;

public record DadosResponse(
        AceleracaoResponse aceleracaoResponse,
        TempoResponse tempoResponse,
        Long idTeste
) {
}
