package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AceleracaoRepository extends JpaRepository<Aceleracao,Long> {
    List<Aceleracao> findAllByTeste_Id(Long testeId);
}
