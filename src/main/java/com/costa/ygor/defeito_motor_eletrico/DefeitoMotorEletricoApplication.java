package com.costa.ygor.defeito_motor_eletrico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DefeitoMotorEletricoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DefeitoMotorEletricoApplication.class, args);
    }

}
