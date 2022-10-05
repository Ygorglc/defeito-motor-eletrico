package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Giro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiroRepository extends JpaRepository<Giro, Long> {
}
