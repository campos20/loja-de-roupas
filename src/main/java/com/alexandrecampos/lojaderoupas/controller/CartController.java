package com.alexandrecampos.lojaderoupas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alexandrecampos.lojaderoupas.business.bean.RoupaBean;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Map<String, Integer>> cart;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub

		cart = new ArrayList<>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {

			List<RoupaBean> cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}

		List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");
		request.setAttribute("cart", cart);

		float total = 0;
		for (RoupaBean roupa : cart) {
			total += roupa.getPreco();
		}
		request.setAttribute("total", total);

		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");
		
		Optional.ofNullable(request.getParameter("codigo")).ifPresent(codigo -> {
			int index = Integer.parseInt(codigo) - 1;
			cart.remove(index);
		});
		
		doGet(request, response);
	}

}
