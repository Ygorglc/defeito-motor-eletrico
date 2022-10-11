package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AceleracaoRepository extends JpaRepository<Aceleracao,Long> {
    List<Aceleracao> findAllByTeste_Id(Long testeId);
}
