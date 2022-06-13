package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Velocidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VelocidadeRepository extends JpaRepository<Velocidade,Long> {
}
