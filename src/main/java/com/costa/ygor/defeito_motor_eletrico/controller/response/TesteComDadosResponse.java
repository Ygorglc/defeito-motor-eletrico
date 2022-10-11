package com.costa.ygor.defeito_motor_eletrico.controller.response;

import java.util.List;

public record TesteComDadosResponse(TesteResponse testeResponse,
                                    List<Double> deslocamento_x,
                                    List<Double> deslocamento_y,
                                    List<Double> deslocamento_z,
                                    List<Double> velocidade_x,
                                    List<Double> velocidade_y,
                                    List<Double> velocidade_z,
                                    List<Double> aceleracao_x,
                                    List<Double> aceleracao_y,
                                    List<Double> aceleracao_z,
                                    List<Double> tempo,
                                    List<Double> giro_x,
                                    List<Double> giro_y,
                                    List<Double> giro_z
                            ) {
}
