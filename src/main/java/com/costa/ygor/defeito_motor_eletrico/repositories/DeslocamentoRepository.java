package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import com.costa.ygor.defeito_motor_eletrico.model.Deslocamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeslocamentoRepository extends JpaRepository<Deslocamento,Long> {
    List<Deslocamento> findAllByTeste_Id(Long testeId);
}
