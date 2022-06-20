package com.costa.ygor.defeito_motor_eletrico.controller.request;

import java.time.LocalDate;

public record TesteRequest(Long id,
                           String descricao,
                           LocalDate data) {
}
