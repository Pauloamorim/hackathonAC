package com.hackatonAC.grupo9.hackatonAC.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private Long idUsuario;

	@Column(name="nome")
	private String nome;

	@Column(name="login")
	private String login;

	@Column(name="senha")
	private String senha;

	@Column(name="salario")
	private BigDecimal salario;

	//TODO PERFIL

}
