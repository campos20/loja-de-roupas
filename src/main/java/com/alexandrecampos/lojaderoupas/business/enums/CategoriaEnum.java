package com.alexandrecampos.lojaderoupas.business.enums;

public enum CategoriaEnum {
	ROUPA_MASCULINA(1, "Roupa Masculina"), ROUPA_FEMININA(2, "Roupa Feminina"), ROUPA_INFANTIL(3, "Roupa Infantil");

	private Integer codigo;
	private String nome;

	private CategoriaEnum(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
}
