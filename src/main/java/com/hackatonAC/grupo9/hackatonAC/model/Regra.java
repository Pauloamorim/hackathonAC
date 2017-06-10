package com.hackatonAC.grupo9.hackatonAC.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hackatonAC.grupo9.hackatonAC.pojo.estatico.DiaSemana;

@Entity
@Table(name="regra")
public class Regra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idregra")
	private Long id;

	@ManyToOne
	@JoinColumn(name="localidade_idlocalidade")
	private Localidade localidade;

	@Column(name="descricao")
	private String descricao;

	@Column(name="porcentagem")
	private BigDecimal porcentagem;



	@Enumerated(EnumType.ORDINAL)
	@Column(name="dia_semana")
	private DiaSemana diaSemana;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}
	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}


}
