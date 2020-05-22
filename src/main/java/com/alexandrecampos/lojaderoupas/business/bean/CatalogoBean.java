package com.alexandrecampos.lojaderoupas.business.bean;

import java.util.ArrayList;
import java.util.List;

import com.alexandrecampos.lojaderoupas.business.enums.CategoriaEnum;

public class CatalogoBean {

	private List<RoupaBean> roupas;

	public CatalogoBean() {
		// Inicia a lista de roupas com algumas roupas
		roupas = new ArrayList<>();
		roupas.add(novaRoupa("Camisa", CategoriaEnum.ROUPA_MASCULINA, 49.9f, "camisa.jpg"));
		roupas.add(novaRoupa("Calça", CategoriaEnum.ROUPA_MASCULINA, 80f, "calca.jpg"));
		roupas.add(novaRoupa("Regata", CategoriaEnum.ROUPA_FEMININA, 15f, "regata.jpg"));
		roupas.add(novaRoupa("Vestido", CategoriaEnum.ROUPA_FEMININA, 120f, "vestido.jpg"));
		roupas.add(novaRoupa("Macacão", CategoriaEnum.ROUPA_FEMININA, 70.99f, "macacao.jpg"));
		roupas.add(novaRoupa("Roupa de Grávida", CategoriaEnum.ROUPA_FEMININA, 80f, "roupa-de-gravida.jpg"));
		roupas.add(novaRoupa("Roupa de Verão", CategoriaEnum.ROUPA_FEMININA, 45.99f, "roupa-de-verao.jpg"));
	}

	// Funcao auxiliar para criar novas roupas
	private RoupaBean novaRoupa(String nome, CategoriaEnum categoriaEnum, Float preco, String nomeImagem) {

		// Calcula o codigo de acordo com o tamanho da lista de roupas
		Integer codigo = roupas.size();

		RoupaBean roupaBean = new RoupaBean();
		roupaBean.setCodigo(codigo);
		roupaBean.setNome(nome);
		roupaBean.setCodigoCategoria(categoriaEnum.getCodigo());
		roupaBean.setCategoria(categoriaEnum.getNome());
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
	public List<RoupaBean> getRoupasFiltradas(String[] codigosCategoria) {

		// Pessoa ainda nao escolheu o filtro
		if (codigosCategoria == null) {
			return roupas;
		}

		List<RoupaBean> roupasFiltradas = new ArrayList<>();

		// Cria uma lista vazia de inteirs
		List<Integer> codigos = new ArrayList<>();

		// Percorre os codigos informados pelo usuario, converte para inteiro e adiciona
		// na lista de codigos
		for (String codigoCategoria : codigosCategoria) {
			codigos.add(Integer.parseInt(codigoCategoria));
		}

		// Compara o codigo da roupa com o codigo que veio na requisicao
		for (RoupaBean roupa : roupas) {
			if (codigos.contains(roupa.getCodigoCategoria())) {
				roupasFiltradas.add(roupa);
			}
		}

		return roupasFiltradas;

	}

}
