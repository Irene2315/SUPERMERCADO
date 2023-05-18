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
	margin-top: 10px;
	color: black;
}

.form-container {
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
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
			<h1 class="fw-bold">Modificar Producto</h1>
			<c:if test="${error eq true}">
    						<div class="alert alert-danger" role="alert">
        					Has introducido la reserva incorrectamente!
    						</div>
	  		</c:if>
			<form method="POST" action="ModificarProducto">
				<p class="fw-bold">
					Id: ${producto.id } <input type="hidden" name="id"
						value="${producto.id }" /> <br>
				</p>
				<p class="fw-bold">
					Codigo:  <input type="text" name="codigo"value="${producto.codigo }" /> <br>
				</p>

				<p class="fw-bold">
					Nombre: <input type="text" name="nombre" value="${producto.nombre}"  />
					<br>
				</p>
				<br>
				<p class="fw-bold">
					Cantidad: <input type="text" name="cantidad"
						value="${producto.cantidad}"  /> <br>
				</p>
				<br>
				<p class="fw-bold">
					Caducidad: <input type="text" name="caducidad"
						value="${producto.caducidad}"  /> <br>
				</p>
				<p class="fw-bold">
					Precio: <input type="text" name="precio"
						value="${producto.precio }"  required/> <br>
				</p>
				<p class="fw-bold">
					id_Seccion: <input type="text" name="nombreSeccion"
						value="${producto.idSeccion.nombre}"  required/> <br>
				</p>
				<br> <input type="submit" class="btn btn-secondary"
					value="Enviar" /> <a href="VerProductos" class="btn btn-dark">Volver</a>
			</form>
		</div>
	</div>


</body>
</html>