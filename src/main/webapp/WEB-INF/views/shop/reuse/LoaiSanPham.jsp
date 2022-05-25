<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="mainTypeProduct">
	<div class="searchTypePro">
		<form:form action="admin/product/productType.htm">
			<span> 
				<input name="searchInput" type="text"
					placeholder="Search" aria-label="Search" class="">
			</span> 
			<span>
				<button name="btnsearch" type="submit" class="btnSearchTypePro">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</span>
		</form:form>
	</div>
	<form:form modelAttribute="productType" method="POST" action = "admin/product/productType.htm">

		<div class="editTypePro">
			<div class="addTypePro">THÊM MỚI</div>
			<div class="boxAddTypePro">
				<div class="nameTypePro">
				<form:input path="proTypeId" type="hidden" />
					<span>Tên loại SP</span>
					<form:input path="proTypeName" type="text"
						placeholder="Vui lòng nhập tên loại sản phẩm" />
					<small>ví dụ: Tee-Shirt,...</small>
				</div>
				<div class="groupTypePro">
					<span>Nhóm</span>
					<form:select path="part.id" items="${namePart}" itemLabel="name"
						itemValue="id"></form:select>
					 </div> 
				<button name="${btnStatus}" type="submit">Lưu</button>
			</div> 
				</div>
	</form:form>
	<%-- <div class="groupTypePro"></div>
	<button name="${btnStatus}" type="submit">Lưu</button>
</div>
</div> --%>
<div class="tableTypePro">
	${message}
	<table>
		<thead>
			<tr>
				<td>Mã loại</td>
				<td>Tên loại</td>
				<td>Nhóm</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pType" items="${ProductType}">
				<tr>
					<td>${pType.proTypeId}</td>
					<td>${pType.proTypeName }</td>
					<td>${pType.part.name}</td>
					<!-- <td>
							<button>
								<i class="fa-solid fa-wrench"></i>
							</button>
							<button>
								<i class="fa-solid fa-trash"></i>
							</button>-->
					<td><a
						href="admin/product/productType/${pType.proTypeId}.htm?linkEdit"><i
							class="fa-solid fa-wrench"></i></a> <a
						href="admin/product/productType/${pType.proTypeId}.htm?linkDelete"
						role="button"><i class="fa-solid fa-trash"></i></a></td>
					<!-- </td> -->

				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>
</div>