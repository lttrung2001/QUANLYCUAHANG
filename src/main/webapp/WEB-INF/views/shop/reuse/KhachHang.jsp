 
<div class="mainCM">
    <div class="cardInforCM">
        <div class="imgCardCM">
            <img src="my_image/PicCats/Meo1.jpg" alt="">
        </div>
        <h3>Lionel Messi</h3>
        <div class="addressCard">
            <i class="fa-solid fa-location-pin"></i> Tân Thành, Đồng Xoài
        </div>
        <div class="phoneCard">
            <i class="fa-solid fa-mobile-screen-button"></i> 0982777935
        </div>
        <div class="mailCard">
            <i class="fa-solid fa-envelope"></i> dangbac872001@gmail.com
        </div>
    </div>
    <div class="diagramCustomer">
        <h4>SỐ LƯỢNG KHÁCH HÀNG ĐĂNG KÝ</h4>
        <div style="height: 85%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Jan</div>
        </div>
        <div style="height: 76%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Feb</div>
        </div>
        <div style="height: 70%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Mar</div>
        </div>
        <div style="height: 50%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Apr</div>
        </div>
        <div style="height: 40%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">May</div>
        </div>
        <div style="height: 45%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">June</div>
        </div>
        <div style="height: 65%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">July</div>
        </div>
        <div style="height: 70%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Aug</div>
        </div>
        <div style="height: 75%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Sep</div>
        </div>
        <div style="height: 60%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Oct</div>
        </div>
        <div style="height: 40%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Nov</div>
        </div>
        <div style="height: 32%" class="column">
            <div class="heightColumn"><span>20</span></div>
            <div class="timeline">Dec</div>
        </div>
    </div>
    <!-- <h1>DANH SÁCH KHÁCH HÀNG</h1> -->
    <div class="topTableCustomer">
        <h2>DANH SÁCH KHÁCH HÀNG</h2>
        <div class="searchCustomer">
            <label for="">
                <input type="text" name="search" id="searchBox" placeholder="Search here">
                <box-icon name='search'></box-icon>
            </label>
        </div>
    </div>
    
    <div class="listCardCustomer">
       <c:forEach var="client" items="${ clients }">
        <div class="cardCustomer">
            <div class="mainNameCus">
                <img src="my_image/Customer Images/Meo5.jpg" >
                <span class="nameCus">
                    <h2>${client.lastName } ${client.firstName }</h2>
                    <div>${client.id }</div>
                </span>
            </div>
            <div class="extendInfo">
                <div class="address">
                    <i class="fa-solid fa-location-pin"></i>
                    <span>${client.address }</span>
                </div>
                <div class="mail">
                    <i class="fa-solid fa-envelope"></i>
                    <span>${client.email } <small class="detailMail"></small><span>
                </div>
                <div class="call">
                    <i class="fa-solid fa-mobile-button"></i>
                    <span>{client.phoneNumber }</span>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>