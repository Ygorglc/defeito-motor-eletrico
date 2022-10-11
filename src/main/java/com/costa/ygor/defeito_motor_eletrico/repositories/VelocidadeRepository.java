package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import com.costa.ygor.defeito_motor_eletrico.model.Velocidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VelocidadeRepository extends JpaRepository<Velocidade,Long> {
    List<Velocidade> findAllByTeste_Id(Long testeId);
}
