package com.costa.ygor.defeito_motor_eletrico.controller.response;

import java.time.LocalDate;

public record TesteResponse(Long id,
                            String descricao,
                            LocalDate data) {
}
