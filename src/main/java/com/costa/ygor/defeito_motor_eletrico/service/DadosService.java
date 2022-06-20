package com.costa.ygor.defeito_motor_eletrico.service;

import org.modelmapper.ModelMapper;

public class DadosService {

    private final ModelMapper modelMapper;

    public DadosService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
