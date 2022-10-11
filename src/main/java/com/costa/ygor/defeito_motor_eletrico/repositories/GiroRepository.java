package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import com.costa.ygor.defeito_motor_eletrico.model.Giro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiroRepository extends JpaRepository<Giro, Long> {
    List<Giro> findAllByTeste_Id(Long testeId);
}
