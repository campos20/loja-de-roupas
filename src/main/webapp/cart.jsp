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
					<thead class="thead-dark">
						<tr>
							<th class="text-center">Item</th>
							<th class="text-center">Preço</th>
							<th class="text-center">Imagem</th>
							<th class="text-center" />
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${ cart }" var="item" varStatus="index">
							<tr>
								<td class="align-middle text-center">${ item.nome }</td>
								<td class="align-middle text-center"><fmt:formatNumber
										value="${ item.preco }" type="currency" currencySymbol="R$" /></td>
								<td class="text-center"><img class="img-thumbnail"
									style="width: 10vw; height: auto;"
									src="assets/img/catalogo/${ item.nomeImagem }"></td>
								<td class="align-middle text-center"><form method="post">
										<button class="btn btn-danger" value="${ index.count }"
											name="codigo">Remover</button>
									</form></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot class="bg-secondary text-white">
						<tr>
							<th>Total</th>
							<th class="text-center"><fmt:formatNumber value="${ total }"
									type="currency" currencySymbol="R$" /></th>
							<th />
							<th />
						</tr>
					</tfoot>

				</table>
			</div>
		</div>


	</div>

	<c:import url="/common/footer.jsp" />

</body>
</html>
