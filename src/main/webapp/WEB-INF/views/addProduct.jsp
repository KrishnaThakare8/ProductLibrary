<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the product details</h1>
				<form action="handleproduct" method="post">
					<div class="form-group">
						<label for="name">Product Name</label><input class="form-control"
							type="text" id="name" aria-drscribedby="emailHelp" name="name"
							placeholder="Enter the product name here">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" name="description" rows="5"
							placeholder="Enter the product description"></textarea>
					</div>
					<div class="form-control">
						<label for="price">Price</label><input type="text" name="price"
							placeholder="Enter product price" class="form-control" id="price">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>