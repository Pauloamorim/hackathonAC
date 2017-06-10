package com.hackatonAC.grupo9.hackatonAC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfil_regra")
public class PerfilRegra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="perfil_idperfil")
	private Perfil perfil;



	@Column(name="nome")
	private String nome;




}
