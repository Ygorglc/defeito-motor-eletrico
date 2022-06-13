package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column( name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;

}
