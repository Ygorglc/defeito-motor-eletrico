package com.costa.ygor.defeito_motor_eletrico.controller.response;

import com.costa.ygor.defeito_motor_eletrico.model.No;

import java.time.LocalDate;

public record TesteResponse(Long id,
                            String titulo,
                            String descricao,
                            LocalDate data,
                            No no) {
}
