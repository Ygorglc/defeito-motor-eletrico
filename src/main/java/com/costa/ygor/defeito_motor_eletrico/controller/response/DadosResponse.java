package com.costa.ygor.defeito_motor_eletrico.controller.response;

public record DadosResponse(
        Double aceleracao_eixo_x,
        Double aceleracao_eixo_y,
        Double aceleracao_eixo_z,
        Double giro_eixo_x,
        Double giro_eixo_y,
        Double giro_eixo_z,
        Double tempo,
        Long posicao,
        Long idTeste
) {
}
