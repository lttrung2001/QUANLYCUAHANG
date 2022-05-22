<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="mainProduct">
	<div class="topMainProduct">
		<h3>Thêm sản phẩm</h3>
		<form action="">
			<div class="searchProduct">
				<span> <input name="searchInput" type="text"
					placeholder="Search" aria-label="Search" class="">
				</span> <span>
					<button name="btnsearch" id="searchProduct" type="submit" class="">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</span>

			</div>
		</form>

	</div>
	<form:form modelAttribute="product" action="admin/product/index1.htm" method="POST" enctype="multipart/form-data">
		<form:input path="id" type="hidden" />
		<%-- <form:input path="insertDate" type="hidden" /> --%>
		<div class="boxEditProduct">
			<div class="topBoxEditProduct">
				<div class="nameProduct">
					<span>Tên sản phẩm</span>
					<form:input path="name" type="text" 
						placeholder="Vui lòng nhập tên sản phẩm" />
				</div>
				<div class="choooseTypeProduct">
					<span>Loại sản phẩm</span> 
					<span> 
					<select name="proType.proTypeId">
							<c:forEach items="${productTypeSelect}" var="pro">
								<option value="${pro.proTypeId}">${pro.proTypeName}</option>
							</c:forEach>
					</select>
					</span>
				</div>

			</div>
			<div class="botBoxEditProduct">
				<div class="numProduct">
					<span>Số lượng</span>
					<form:input path="qttInStock" type="text"
						placeholder="Vui lòng nhập số lượng sản phẩm" />
				</div>
				<div class="priceProduct">
					<span>Giá tiền</span>
					<form:input path="price" type="text"
						placeholder="Vui lòng nhập giá của sản phẩm" />
				</div>

			</div>
			<div class="endBoxEditProduct">
				<div class="imgProduct">
					<span>Hình ảnh</span>
					<input name="file" type="file" placeholder="Vui long chon anh" />
					<form:input path="image" type="hidden" />
				</div>
				<div class="descProduct">
					<span>Mô tả sản phẩm</span>
					<form:textarea path="desc" row="3" />
				</div>
			</div>
			<button class="saveEditProduct" type="submit" name="${btnStatus}">SAVE</button>
		</div>
	</form:form>
	
	<div class="tableProduct">
		<div class="NotificationBox">
			<%-- <c:if test="${not empty status}"> --%>
			<c:choose>
				<c:when test="${status == 0 }">
				<c:choose>
					<c:when test="${message == 1 }">
						<span><i class="fa-solid fa-check"></i>Thêm sản phẩm thành công</span>
					</c:when>
					<c:when test="${message == 0 }">
						<span><i class="fa-solid fa-exclamation"></i>Thêm sản phẩm thất bại</span>
					</c:when>
				</c:choose>
				</c:when>
				<c:when test="${status == 1 }">
				<c:choose>
					<c:when test="${message == 1 }">
						<span><i class="fa-solid fa-check"></i>Cập nhật sản phẩm thành công</span>
					</c:when>
					<c:when test="${message == 0 }">
						<span><i class="fa-solid fa-exclamation"></i>Cập nhật sản phâm thất bại</span>
					</c:when>
					</c:choose>
				</c:when>
				<c:when test="${status == 2 }">
				<c:choose>
					<c:when test="${message == 1 }">
						<span><i class="fa-solid fa-check"></i>Xóa sản phẩm thành công</span>
					</c:when>
					<c:when test="${message == 0 }">
						<span><i class="fa-solid fa-exclamation"></i>Xóa sản phẩm thất bại</span>
					</c:when>
					</c:choose>
				</c:when>
			</c:choose>
			<%-- </c:if> --%>
			<%-- <span><i class="fa-solid fa-exclamation"></i>${message }</span>
			<span><i class="fa-solid fa-check"></i>${message }</span> --%>
		</div>
		<table>
			<thead>
				<tr>
					<td>Mã sản phẩm</td>
					<td>Tên sản phẩm</td>
					<td>Loại sản phẩm</td>
					<td>Số lượng</td>
					<td>Giá tiền</td>
					<td>Hình ảnh</td>
					<td></td>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products }">
					<tr>
						<td>${product.id }</td>
						<td>${product.name }</td>
						<td>${product.proType.proTypeName}</td>
						<td>${product.qttInStock}</td>
						<td>${product.price}</td>
						<td><img width="50px" height="50px"
							src="<c:url value='${product.image }'/>"></td>
						<td><a href="admin/product/index/${product.id }.htm?linkEdit"><i
								class="fa-solid fa-wrench"></i></a> <a
							href="admin/product/index/${product.id }.htm?linkDelete"
							role="button"><i class="fa-solid fa-trash"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>