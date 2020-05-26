package com.alexandrecampos.lojaderoupas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		// Envia a pagina jsp na requisicao
		String[] categorias = request.getParameterValues("categorias");

		List<RoupaBean> roupas = catalogoBean.getRoupasFiltradas(categorias);

		// Envia as roupas do catalogo para o front
		request.setAttribute("roupas", roupas);
		request.setAttribute("categorias", CategoriaEnum.values());

		if (request.getParameter("adicionar") != null) {
			adicionar(request, roupas);
		}

		request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
	}

	private void adicionar(HttpServletRequest request, List<RoupaBean> roupas) {
		HttpSession session = request.getSession();

		if (session.getAttribute("cart") == null) {

			List<RoupaBean> cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}

		List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");

		Optional.ofNullable(request.getParameter("adicionar")).ifPresent(codigoString -> {
			Integer codigo = Integer.parseInt(codigoString);
			roupas.stream().filter(roupa -> codigo.equals(roupa.getCodigo())).findFirst()
					.ifPresent(roupa -> cart.add(roupa));
		});
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
