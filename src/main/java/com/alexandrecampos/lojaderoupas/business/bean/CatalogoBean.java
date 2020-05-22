package com.alexandrecampos.lojaderoupas.business.bean;

import java.util.ArrayList;
import java.util.List;

public class CatalogoBean {
	
	private final String ROUPA_MASCULINA = "Roupa Masculina";
	private final String ROUPA_FEMININA = "Roupa Feminina";
	private final String ROUPA_INFANTIL = "Roupa Infantil";

	private List<RoupaBean> roupas;

	public CatalogoBean() {
		// Inicia a lista de roupas com algumas roupas
		roupas = new ArrayList<>();
		roupas.add(novaRoupa("Camisa", ROUPA_MASCULINA, 49.9f, "camisa.jpg"));
		roupas.add(novaRoupa("Calça", ROUPA_MASCULINA, 80f, "calca.jpg"));
		roupas.add(novaRoupa("Regata", ROUPA_FEMININA, 15f, "regata.jpg"));
		roupas.add(novaRoupa("Vestido", ROUPA_FEMININA, 120f, "vestido.jpg"));
		roupas.add(novaRoupa("Macacão", ROUPA_FEMININA, 70.99f, "macacao.jpg"));
		roupas.add(novaRoupa("Roupa de Grávida", ROUPA_FEMININA, 80f, "roupa-de-gravida.jpg"));
		roupas.add(novaRoupa("Roupa de Verão", ROUPA_FEMININA, 45.99f, "roupa-de-verao.jpg"));
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
				if (ROUPA_MASCULINA.equals(roupa.getCategoria())) {
					roupasFiltradas.add(roupa);
				}
			} else if (codigo == 1) {
				if (ROUPA_FEMININA.equals(roupa.getCategoria())) {
					roupasFiltradas.add(roupa);
				}
			} else if (codigo == 2) {
				if (ROUPA_INFANTIL.equals(roupa.getCategoria())) {
					roupasFiltradas.add(roupa);
				}
			}
		}
		
		return roupasFiltradas;
		
	}

}
