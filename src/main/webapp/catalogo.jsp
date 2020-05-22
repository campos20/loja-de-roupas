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

					<div class="row">
						<div class="col-6">
							<c:forEach items="${ roupas }" var="roupa">
								<div class="card">
									<div class="card-header">
										<h5>${ roupa.nome }</h5>
									</div>

									<div class="card-body">

										<img class="card-img"
											src="assets/img/catalogo/${ roupa.nomeImagem }">

										<div class="card-title text-center mt-4">
											<div class="badge badge-dark badge-pill">
												<h5>
													<fmt:formatNumber value="${ roupa.preco }" type="currency"
														currencySymbol="R$" />
												</h5>
											</div>
										</div>

									</div>

									<div class="card-footer text-center">
										<div class="btn-group">
											<button class="btn btn-primary">Adicionar</button>
											<a class="btn btn-info" href="#">Detalhes</a>
										</div>
									</div>



								</div>
							</c:forEach>
						</div>
					
					
						<div class="col-6 text-right">
							<h5>Filtros</h5>
							
							<form method="post">
								<div>
									<select name="categoria">
										<option value="0">Roupa Masculina</option>
										<option value="1">Roupa Feminina</option>
										<option value="2">Roupa Infantil</option>
									</select>
								</div>
								<div>
									<button>Filtrar</button>
								</div>
							</form>
						
						</div>
					
					</div>

				</div>
			</div>

		</div>

	</div>

	<c:import url="/common/footer.jsp" />

</body>
</html>
