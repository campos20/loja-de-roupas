package com.alexandrecampos.lojaderoupas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alexandrecampos.lojaderoupas.business.bean.CatalogoBean;
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

		String[] categorias = request.getParameterValues("categorias");
		if (categorias != null) {
			for (String categoria : categorias) {
				System.out.println(categoria);
			}
		}

		// Envia as roupas do catalogo para o front
		request.setAttribute("roupas", catalogoBean.getRoupasFiltradas(categorias));
		request.setAttribute("categorias", CategoriaEnum.values());

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
