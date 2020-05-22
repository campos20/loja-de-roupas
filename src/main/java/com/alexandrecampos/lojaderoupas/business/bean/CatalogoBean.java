package com.alexandrecampos.lojaderoupas.business.bean;

import java.util.ArrayList;
import java.util.List;

public class CatalogoBean {

	private List<RoupaBean> roupas;

	public CatalogoBean() {
		// Inicia a lista de roupas com algumas roupas
		roupas = new ArrayList<>();
		roupas.add(novaRoupa("Camisa", "Roupa Masculina", 49.9f, "camisa.jpg"));
		roupas.add(novaRoupa("Calça", "Roupa Masculina", 80f, "calca.jpg"));
		roupas.add(novaRoupa("Regata", "Roupa Feminina", 15f, "regata.jpg"));
		roupas.add(novaRoupa("Vestido", "Roupa Feminina", 120f, "vestido.jpg"));
		roupas.add(novaRoupa("Macacão", "Roupa Feminina", 70.99f, "macacao.jpg"));
		roupas.add(novaRoupa("Roupa de Grávida", "Roupa Feminina", 80f, "roupa-de-gravida.jpg"));
		roupas.add(novaRoupa("Roupa de Verão", "Roupa Feminina", 45.99f, "roupa-de-verao.jpg"));
	}

	// Funcao auxiliar para criar novas roupas
	private RoupaBean novaRoupa(String nome, String categoria, Float preco, String nomeImagem) {

		// Calcula o codigo de acordo com o tamanho da lista de roupas
		Integer codigo = roupas.size();

		RoupaBean roupaBean = new RoupaBean();
		roupaBean.setCodigo(codigo);
		roupaBean.setNome(nome);
		roupaBean.setCategoria(categoria);
		roupaBean.setPreco(preco);
		roupaBean.setNomeImagem(nomeImagem);

		return roupaBean;
	}

	public List<RoupaBean> getRoupas() {
		return roupas;
	}

	public void setRoupas(List<RoupaBean> roupas) {
		this.roupas = roupas;
	}
	
	// Retorna roupas filtradas de acordo com um codigo informado pelo navegador
	public List<RoupaBean> getRoupasFiltradas(String codigoCategoria){
		
		// Pessoa ainda nao escolheu o filtro
		if (codigoCategoria == null) {
			return roupas;
		}
		
		// Transforma, ex, String "0" em inteiro 0
		int codigo = Integer.parseInt(codigoCategoria);

		List<RoupaBean> roupasFiltradas = new ArrayList<>();
		
		// 0 Roupa masculina
		// 1 Roupa feminina
		// 2 Roupa infantil
		
		for (RoupaBean roupa : roupas) {
			if (codigo == 0) { // Pessoa escolheu roupa masculina
				if ("Roupa Masculina".equals(roupa.getCategoria())) {
					roupasFiltradas.add(roupa);
				}
			} else if (codigo == 1) {
				if ("Roupa Feminina".equals(roupa.getCategoria())) {
					roupasFiltradas.add(roupa);
				}
			} else if (codigo == 2) {
				if ("Roupa Infantil".equals(roupa.getCategoria())) {
					roupasFiltradas.add(roupa);
				}
			}
		}
		
		return roupasFiltradas;
		
	}

}
