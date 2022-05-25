<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>>
<div class="mainStatistical">
    <!-- cards -->
    <div class="cardBox">
        <div class="card">
            <div>
                <div class="numbers">${sumAmount }</div>
                <div class="cardName">Tổng sản phẩm đã bán</div>
            </div>
            <div class="iconBox">
                <ion-icon name="funnel-outline"></ion-icon>
            </div>
        </div>
        <div class="card">
            <div>
                <div class="numbers nameProMax">${max }</div>
                <div class="cardName">Sản phẩm bán chạy nhất</div>
            </div>
            <div class="iconBox">
              <ion-icon name="shirt-outline"></ion-icon>
            </div>
        </div>
        <div class="card">
            <div>
                <div class="numbers">${count }</div>
                <div class="cardName">Tổng tài khoản khách hàng</div>
            </div>
            <div class="iconBox">
                <ion-icon name="person-add-outline"></ion-icon>
            </div>
        </div>
        <div class="card">
            <div>
                <div class="numbers">${sum} VND</div>
                <div class="cardName">Total Revenue</div>
            </div>
            <div class="iconBox">
                <ion-icon name="cash-outline"></ion-icon>
            </div>
        </div>
    </div>

    <!-- order details list -->
    <div class="details">
        <div class="recentOrders">
            <div class="cardHeader">
                <h2>Recent Orders</h2>
                <!-- <a href="#" class="btn">View All</a> -->
            </div>
            <table>
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Price</td>
                        <td>Number</td>
                        <td>SumMoney</td>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="item" items="${list }">
                	<tr>
                        <td>${item.product.name }</td>
                        <td>${item.product.price }</td>
                        <td>${item.amount }</td>
                        <td>${item.amount*item.product.price} VND</td>
                    </tr>
                	</c:forEach>
                </tbody>
            </table>
        </div>
        <!-- end of order details -->

        <!-- Recent Customer -->
        <div class="recentCustomers">
            <div class="cardHeader">
                <h2>Loyal Customers</h2>
            </div>
            <table>
            <c:forEach var="top" items="${listTop6 }">
                <tr>
                    <td ><div class="imgBox"><img src="<c:url value='resources/my_image/Customer Images/e64ed0d383104b4e1201.jpg'/>"></div></td>
                    <td>
                    <h4>${top.lastName } ${top.firstName }<br><span>Point: ${top.clientAccount.point }</span></h4></td>
                </tr>
            </c:forEach>
                
            </table>
        </div>
        <!-- End of Recent Customer -->
    </div>  
</div>