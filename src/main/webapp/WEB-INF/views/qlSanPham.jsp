<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test 2</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<main class="container  ">
		<div class="row justify-content-md-center">
			<%-- 	<%@include file="/WEB-INF/views/include/menudemo.jsp"%> --%>
		</div>


		<div class="bg-light p-5 rounded">
			${message}
			<form:form class="row g-3" modelAttribute="product"
				action="qlSanPham.htm">
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Tên
						sản phầm</label>
					<form:input path="name" type="text" class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui lòng nhập mã sản phẩm" />
				</div>
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Số lượng</label>
					<form:input path="qttInStock" type="text" class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui lòng nhập số lượng  sản phẩm" />
				</div>
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Giá</label>
					<form:input path="price" type="text" class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui lòng nhập giá của sản phẩm" />
				</div>
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Mô tả</label>
					<form:textarea path="desc" name="desc" class="form-control" id="desc"
						rows="5" cols="1"/>
				</div>

				<div class="col-md-6">
					<label for="exampleFormControlInput1" class="form-label">Loại sản phẩm</label>
					<form:select path="ProductType.proTypeId" items="${productTypSelect }"
						itemValue="proTypeId" itemLabel="proTypeName"
						class="form-select form-select-lg mb-6"
						aria-label=".form-select-lg example">
					</form:select>
				</div>

				<div class="col-12">
					<button name="${btnStatus}" class="btn btn-primary">Save</button>
				</div>

			</form:form>

		</div>




		<div class="bg-light p-5 rounded">
			
			<div class="d-flex flex-row justify-content-between">
				<div>
					<span id="result1"></span>

					<form class="d-inline-flex">
						<input name="searchInput" id="searchInput"
							class="form-control me-2" type="search" placeholder="Search"
							aria-label="Search">
						<!-- 			<input name="searchInput" id="searchInput" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" onkeyup="searchValue()"> -->

						<button name="btnsearch" id="searchProduct"
							class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>


			<table class="table">
				<thead>
					<tr>
						<th scope="col">Mã sản phẩm</th>
						<th scope="col">Tên sản phẩm</th>
						<th scope="col">Loại sản phẩm</th>
						<th scope="col">Mô tả</th>
						<th scope="col">Số lượng</th>
						<th scope="col">Giá</th>
						<th scope="col">Chỉnh sửa</th>
						<th scope="col">Xóa</th>
					</tr>
				</thead>
				<tbody id="table_products">
					<c:forEach var="pd" items="${products}">

						<tr>
							<td>${pd.id}</td>
							<td>${pd.name}</td>
							<td>${pd.proType.proTypeName}</td>
							<td>${pd.qttInStock}</td>
							<td>${pd.price}</td>
							<%-- <td> <a href="products.htm?id=${pd.product_id}"><button type="button"  name="btnEdit" class="btn btn-warning">Chỉnh sửa</button> </a></td> --%>
							<td><a href="qlSanPham/${pd.id}.htm?linkEdit"><img
									width="50" height="40"
									src="<c:url value="/resources/images/edit.png"/>"></a></td>
							<td><a name="btnDelete"
								href="Lesson6/index/${pd.product_id}.htm?linkDelete"
								role="button"><img width="30" height="30"
									src="<c:url value="/resources/images/delete.png"/>"></a> <%-- 	<a href="products/${pd.product_id}.htm"> <button type="button" name="btnDelete"  class="btn btn-danger">Xóa</button> </a> --%>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>



	</main>
</body>
</html>