package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.Testando_Esp_Rest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestandoEspRestRepository extends JpaRepository<Testando_Esp_Rest,Long> {
}
