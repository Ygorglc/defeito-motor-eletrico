package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado,Long> {
}
