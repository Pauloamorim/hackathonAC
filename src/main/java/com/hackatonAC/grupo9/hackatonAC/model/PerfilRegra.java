package com.hackatonAC.grupo9.hackatonAC.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="perfil_regra")
public class PerfilRegra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil_regra")
	private Long id;

	@ManyToOne
	@JoinColumn(name="perfil_idperfil")
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name="regra_idregra")
	private Regra regra;

	@Transient
	private List<Regra> listaRegras;


	public List<Regra> getListaRegras() {
		return listaRegras;
	}

	public void setListaRegras(List<Regra> listaRegras) {
		this.listaRegras = listaRegras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}


}
