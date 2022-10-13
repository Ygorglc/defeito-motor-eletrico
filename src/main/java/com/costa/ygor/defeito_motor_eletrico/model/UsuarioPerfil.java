package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "perfil_usuario")
@SequenceGenerator(name = "PERFIL_USUARIO_COD_PERFIL_USUARIO_SEQ",
        sequenceName = "PERFIL_USUARIO_COD_PERFIL_USUARIO_SEQ",
        allocationSize = 1)
public class UsuarioPerfil implements Serializable {

    @Id
    @GeneratedValue(generator = "PERFIL_USUARIO_COD_PERFIL_USUARIO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "cod_perfil_usuario")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FK_USUARIO")
    private Usuario usuario;

    @OneToOne()
    @JoinColumn(name = "FK_PERFIL")
    private Perfil perfil;

    @Column(name = "data_habilitacao")
    private LocalDate dataHab;

    @Column(name = "data_desabilitacao")
    private LocalDate dataDesab;


    public UsuarioPerfil(Usuario usuario, Perfil perfil, LocalDate dataHab, LocalDate dataDesab) {
        this.usuario = usuario;
        this.perfil = perfil;
        this.dataHab = dataHab;
        this.dataDesab = dataDesab;
    }

    public UsuarioPerfil() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public LocalDate getDataHab() {
        return dataHab;
    }

    public void setDataHab(LocalDate dataHab) {
        this.dataHab = dataHab;
    }

    public LocalDate getDataDesab() {
        return dataDesab;
    }

    public void setDataDesab(LocalDate dataDesab) {
        this.dataDesab = dataDesab;
    }
}
