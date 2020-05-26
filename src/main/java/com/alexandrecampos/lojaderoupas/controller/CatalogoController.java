package com.alexandrecampos.lojaderoupas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alexandrecampos.lojaderoupas.business.bean.CatalogoBean;
import com.alexandrecampos.lojaderoupas.business.bean.RoupaBean;
import com.alexandrecampos.lojaderoupas.business.enums.CategoriaEnum;

/**
 * Servlet implementation class CatalogoController
 */
@WebServlet("/catalogo")
public class CatalogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CatalogoBean catalogoBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogoController() {
		super();

		// Inicia o catalogo com as roupas padrao
		catalogoBean = new CatalogoBean();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupera os valores do select do front
		String[] codigosCategoria = request.getParameterValues("categoria");

		// Envia as roupas do catalogo para o front
		request.setAttribute("roupas", catalogoBean.getRoupasFiltradas(codigosCategoria));
		request.setAttribute("categorias", CategoriaEnum.values());
		
		// Usuario clicou em adicionar
		if (request.getParameter("adicionar") != null) {
			
			HttpSession session = request.getSession();
	
			// Verifica se ja existe um cart e cria um, caso contratio
			if (session.getAttribute("cart") == null) {
				// Caso nao exista a lista de compras, cria uma
				
				List<RoupaBean> cart = new ArrayList<>();
				session.setAttribute("cart", cart);
			}
			
			//Recupera a lista de compras
			List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");
			
			// Identifica o codigo da roupa que o usuario clicout
			String codigoString = request.getParameter("adicionar");
			Integer codigo = Integer.parseInt(codigoString);
			
			// Percorre todas as roupas e procure aquela com codigo igual.
			// Adiciona ao carrinho
			List<RoupaBean> todasAsRoupas = catalogoBean.getRoupas();
			for (RoupaBean roupa : todasAsRoupas) {
				if (roupa.getCodigo().equals(codigo)) {
					cart.add(roupa);
				}
			}
			
		}

		// Envia a pagina jsp na requisicao
		request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
