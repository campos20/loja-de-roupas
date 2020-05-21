package com.alexandrecampos.lojaderoupas.business.bean;

import java.util.ArrayList;
import java.util.List;

public class CatalogoBean {
	
	private List<RoupaBean> roupas;
	
	public CatalogoBean() {
		// Inicia a lista de roupas com algumas roupas
		roupas = new ArrayList<>();
		roupas.add(novaRoupa("Camisa", "Roupa Masculina", 49.9f));
		roupas.add(novaRoupa("Calça", "Roupa Masculina", 80f));
		roupas.add(novaRoupa("Regata", "Roupa Feminina", 15f));
		roupas.add(novaRoupa("Vestido", "Roupa Feminina", 120f));
	}
	
	// Funcao auxiliar para criar novas roupas
	private RoupaBean novaRoupa(String nome, String categoria, Float preco) {
		
		// Calcula o codigo de acordo com o tamanho da lista de roupas
		Integer codigo = roupas.size();
		
		RoupaBean roupaBean = new RoupaBean();
		roupaBean.setCodigo(codigo);
		roupaBean.setNome(nome);
		roupaBean.setCategoria(categoria);
		roupaBean.setPreco(preco);
		
		return roupaBean;
	}

	public List<RoupaBean> getRoupas() {
		return roupas;
	}

	public void setRoupas(List<RoupaBean> roupas) {
		this.roupas = roupas;
	}

}
