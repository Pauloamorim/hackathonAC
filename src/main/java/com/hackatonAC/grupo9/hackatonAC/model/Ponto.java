package com.hackatonAC.grupo9.hackatonAC.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ponto")
public class Ponto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idponto")
	private Long idPonto;

	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	private Localidade localidade;

	@JsonFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date data;

	@Transient
	public String getDataFormatada(){
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(getData());
	}
	@Transient
	public String getHora(){
		final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(getData());
	}


	public Long getIdPonto() {
		return idPonto;
	}

	public void setIdPonto(Long idPonto) {
		this.idPonto = idPonto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}







}
