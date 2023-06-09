
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>


.container {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top:10px;
	
	color: black;
}

.form-container {
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
	background-color: white;
}
</style>
</head>
<body>
	<div class="container">
		<div class="form-container">
		
			<h1 class="fw-bold">Registrar Producto</h1>
			
			<form method="POST" action="RegistrarProducto">
			<div class="row 2">
					<div class="col-5">
				<c:if test="${error eq true}">
    						<div class="alert alert-danger" role="alert">
        					Has introducido el producto incorrectamente!
    						</div>
				</c:if>
				<p>
					<b>codigo:</b> <input type="text" name="codigo"  /> <br>
				</p>
				<br>
				<p>
					<b>nombre:</b> <input type="text" name="nombre" /> <br>
				</p>
				<br>
				<p>
					<b>cantidad</b> <input type="text" name="cantidad" /> <br>
				</p>
				<br>
				<p>
					<b>precio</b> <input type="text" name="precio" /> <br>
				</p>
				<br>
				<p>
					<b>caducidad:</b> <input type="date" name="caducidad" /> <br>
				</p>
				<br>
				<p>
					
					
					 Secciones:
					 <select name="seccion">
						<option value="0"></option>
						<c:forEach items="${secciones}" var="seccion">
							<option value="${seccion.id}">${seccion.nombre}</option>
						</c:forEach>
					</select>
				
				<br> <br>
				</p>
				
				<br> <input type="submit" class="btn btn-secondary"
					value="Guardar" /> <a href="VerProductos" class="btn btn-dark">Volver</a>
				</div>
				
				<div class="col-7">
				<h1 class="fw-bold">SUPERMERCADOS</h1>
					<table class="table">

							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">id</th>
									<th scope="col">nombre</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${supermercados}" var="supermercado">
									<tr>
										<th scope="row"></th>
										<td>${supermercado.id}</td>
										<td>${supermercado.nombre}</td>

										<td><input class="form-check-input" type="checkbox"
											id="flexCheckDefault" value="${supermercado.id}"
											name="supermercados"></td>


									</tr>

								</c:forEach>




							</tbody>
						</table>
				</div>
				</div>
			</form>


		</div>
	</div>
</body>
</html>