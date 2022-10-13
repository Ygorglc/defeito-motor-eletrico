package com.costa.ygor.defeito_motor_eletrico.service;


import com.costa.ygor.defeito_motor_eletrico.controller.request.CredenciaisRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TokenResponse;
import com.costa.ygor.defeito_motor_eletrico.exception.EntidadeNaoEncontradaException;
import com.costa.ygor.defeito_motor_eletrico.exception.SenhaInvalidaException;
import com.costa.ygor.defeito_motor_eletrico.model.Perfil;
import com.costa.ygor.defeito_motor_eletrico.model.Usuario;
import com.costa.ygor.defeito_motor_eletrico.model.UsuarioPerfil;
import com.costa.ygor.defeito_motor_eletrico.repositories.PerfilRepository;
import com.costa.ygor.defeito_motor_eletrico.repositories.UsuarioPerfilRepository;
import com.costa.ygor.defeito_motor_eletrico.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    private UsuarioRepository usuarioRepository;


    private UsuarioPerfilRepository usuarioPerfilRepository;

    private JwtService jwtService;

    private final Logger log = LoggerFactory.getLogger(LoginService.class);

    public LoginService(PasswordEncoder encoder,
                        UsuarioRepository usuarioRepository,
                        UsuarioPerfilRepository usuarioPerfilRepository,

                        JwtService jwtService) {
        this.encoder = encoder;
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
        this.jwtService = jwtService;
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(()->
                new EntidadeNaoEncontradaException("Usuário com esse email não foi encontrado!"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = buscarPorEmail(username);
        log.info("O usuario de cpf {}, idUsuario {}",usuario.getEmail(), usuario.getId());

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(regras(usuario))
                .build();
    }

    public String regras(Usuario usuarioSeap) throws UsernameNotFoundException{

        List<UsuarioPerfil> usuarioPerfilList = usuarioPerfilRepository.findAllByUsuario_Id(usuarioSeap.getId());//servicoExternoService.repuperarUsuarioPerfis(usuarioSeap.getId());
        AtomicReference<String> regra = new AtomicReference<>("SEM_AUTORIZACAO");

        usuarioPerfilList.forEach(usuarioPerfil ->
                regra.set(validarRegra(usuarioPerfil.getPerfil())));

        return regra.get();
    }

    public String validarRegra(Perfil perfil){
        String regra = "SEM_AUTORIZACAO";
        if(perfil.getNome().equals("ADMINISTRADOR")|perfil.getNome().equals("VISUALIZADOR")){
            regra = perfil.getNome();
            System.out.println(regra);
        }
        return regra;
    }
    public TokenResponse servicoDeAutenticacao(CredenciaisRequest credenciaisRequest, HttpServletResponse response) throws Exception {
        Usuario usuario = new Usuario(credenciaisRequest.login(), credenciaisRequest.senha());
        UserDetails usuarioAutenticado = autenticar(usuario);
        String token = jwtService.geraToken(usuario,usuarioAutenticado);
        Usuario usuarioNome = buscarPorEmail(usuario.getEmail());

        return new TokenResponse(usuario.getEmail(),
                usuarioNome.getNome(),
                token);
    }
    public UserDetails autenticar(Usuario usuario) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        UserDetails user = loadUserByUsername(usuario.getEmail());
        if( md5Verificacao(usuario.getSenha(), user.getPassword()) )
            return  user;

        throw new SenhaInvalidaException();
    }
    public boolean md5Verificacao(String senha, String senhaEncry) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String senhaMd5 = new String(hexCodes(md.digest(senha.getBytes())));

        return senhaMd5.equals(senhaEncry);
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }
}
