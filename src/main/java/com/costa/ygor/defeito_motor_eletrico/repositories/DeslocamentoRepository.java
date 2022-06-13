package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Deslocamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeslocamentoRepository extends JpaRepository<Deslocamento,Long> {
}
