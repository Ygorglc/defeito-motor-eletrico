package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import com.costa.ygor.defeito_motor_eletrico.model.Tempo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TempoRepository extends JpaRepository<Tempo,Long> {
    List<Tempo> findAllByTeste_Id(Long testeId);
}
