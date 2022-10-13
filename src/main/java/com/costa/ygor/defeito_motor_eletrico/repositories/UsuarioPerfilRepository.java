package com.costa.ygor.defeito_motor_eletrico.repositories;

import com.costa.ygor.defeito_motor_eletrico.model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long> {

    List<UsuarioPerfil> findAllByUsuario_Id(Long id);
}
