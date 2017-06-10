package com.hackatonAC.grupo9.hackatonAC.pojo.estatico;

public enum DiaSemana {

	DOMINGO("Domingo"),
	SEGUNDA("Segunda-Feira"),
	TERCA("Terça-Feira"),
	QUARTA("Quarta-Feira"),
	QUINTA("Quinta-Feira"),
	SEXTA("Sexta-Feira"),
	SABADO("Sábado"),
	TODOS("Todos");


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	private DiaSemana(String descricao) {
		this.descricao = descricao;
	}






}