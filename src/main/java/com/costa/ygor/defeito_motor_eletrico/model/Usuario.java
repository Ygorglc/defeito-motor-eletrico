package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO")
@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column( name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "PERFIL_USUARIO")
    private String perfilUsuario;

    @Column(name = "ALTERAR_SENHA")
    private Boolean alterarSenha;

    @Column(name ="NOME")
    private String nome;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    @Column(name = "ULTIMO_ACESSO")
    private LocalDateTime ultimoAcesso;

    @Column(name = "BLOQUEADO")
    private Boolean bloqueado;

    public Usuario(String email,
                   String senha,
                   String perfilUsuario,
                   Boolean alterarSenha,
                   String nome,
                   LocalDateTime dataCadastro,
                   LocalDateTime ultimoAcesso,
                   Boolean bloqueado) {
        this.email = email;
        this.senha = senha;
        this.perfilUsuario = perfilUsuario;
        this.alterarSenha = alterarSenha;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.ultimoAcesso = ultimoAcesso;
        this.bloqueado = bloqueado;
    }

    public Usuario() {

    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public Boolean getAlterarSenha() {
        return alterarSenha;
    }

    public void setAlterarSenha(Boolean alterarSenha) {
        this.alterarSenha = alterarSenha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
