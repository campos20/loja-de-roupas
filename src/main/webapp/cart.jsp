<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<c:import url="/common/header.jsp" />

<body>
	<div class="container-fluid">

		<c:import url="/common/titulo.jsp" />

		<div class="row">
			<c:import url="/common/side-bar.jsp" />
			<!-- Side bar e col-3 -->

			<div class="col-9">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<h3>Carrinho de Compras</h3>
						</div>
					</div>
				</div>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Item</th>
							<th>Preço</th>
							<th>Imagem</th>
							<th>Remover</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${ cart }" var="item">
							<tr>
								<td class="align-middle">${ item.nome }</td>
								<td class="align-middle"><fmt:formatNumber
										value="${ item.preco }" type="currency" currencySymbol="R$" /></td>
								<td class="text-center"><img class="img-thumbnail"
									style="width: 10vw; height: auto;"
									src="assets/img/catalogo/${ item.nomeImagem }"></td>
								<td class="align-middle"><button class="btn btn-danger">Remover</button></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td />
							<td><fmt:formatNumber value="${ total }" type="currency"
									currencySymbol="R$" /></td>
						</tr>
					</tfoot>

				</table>
			</div>
		</div>


	</div>

	<c:import url="/common/footer.jsp" />

</body>
</html>
