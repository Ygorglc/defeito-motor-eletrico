package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.controller.request.UsuarioRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.UsuarioResponse;
import com.costa.ygor.defeito_motor_eletrico.exception.EntidadeNaoEncontradaException;
import com.costa.ygor.defeito_motor_eletrico.model.Perfil;
import com.costa.ygor.defeito_motor_eletrico.model.Usuario;
import com.costa.ygor.defeito_motor_eletrico.model.UsuarioPerfil;
import com.costa.ygor.defeito_motor_eletrico.repositories.PerfilRepository;
import com.costa.ygor.defeito_motor_eletrico.repositories.UsuarioPerfilRepository;
import com.costa.ygor.defeito_motor_eletrico.repositories.UsuarioRepository;
import com.costa.ygor.defeito_motor_eletrico.util.Criptografia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;
    PerfilRepository perfilRepository;
    UsuarioPerfilRepository usuarioPerfilRepository;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PerfilRepository perfilRepository,
                          UsuarioPerfilRepository usuarioPerfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
    }

    public UsuarioResponse criandoUsuario(UsuarioRequest usuarioRequest) throws Exception {
        Usuario novoUsuario = new Usuario(usuarioRequest.email(),
                Criptografia.md5(usuarioRequest.senha()),
                false,
                usuarioRequest.nome(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                false);
        if(!usuarioRepository.existsByEmail(usuarioRequest.email())){
            Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);
            Perfil perfil = perfilRepository.findById(2L).orElseThrow(()-> new EntidadeNaoEncontradaException("Perfil não encontrado"));
            UsuarioPerfil usuarioPerfil = usuarioPerfilRepository.save(new UsuarioPerfil(usuarioSalvo, perfil, LocalDate.now(), null));

            return new UsuarioResponse(usuarioSalvo.getEmail(), usuarioSalvo.getNome(), usuarioPerfil.getPerfil().getNome());
        }
        throw new Exception("Já existe usuario com esse e-mail cadastrado");
    }
}
