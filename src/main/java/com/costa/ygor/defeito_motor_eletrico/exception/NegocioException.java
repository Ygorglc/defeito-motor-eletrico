package com.costa.ygor.defeito_motor_eletrico.exception;

public class NegocioException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }
}
