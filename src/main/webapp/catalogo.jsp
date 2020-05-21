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

			<div class="col-9">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<h3>Catálogo</h3>
						</div>
					</div>

					<c:forEach items="${ roupas }" var="roupa">
						<div>
							<div class="card-header">
								<h5>${ roupa.nome }</h5>
							</div>

							<div class="card-body">
								<div class="card-title">

									<fmt:formatNumber value="${roupa.preco}" type="currency"
										currencySymbol="R$" />
								</div>
								<button class="btn btn-primary">Adicionar</button>

							</div>

						</div>
					</c:forEach>
				</div>
			</div>

		</div>

	</div>

	<c:import url="/common/footer.jsp" />

</body>
</html>
