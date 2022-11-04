package com.costa.ygor.defeito_motor_eletrico.controller.request;

public record DadosGy87Request(Double ax,
                               Double ay,
                               Double az,
                               Double gx,
                               Double gy,
                               Double gz,
                               Double t,
                               Long p,
                               Long idt,
                               Double mx,
                               Double my,
                               Double mz,
                               Double b) {
}
