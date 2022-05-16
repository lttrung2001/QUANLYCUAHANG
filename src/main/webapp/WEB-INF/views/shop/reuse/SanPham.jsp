<div class="mainProduct">

    <div class="topMainProduct">
        <h3>Thêm sản phẩm</h3>
        <div class="searchProduct">
            <span><input type="text"></span>
            <span><i class="fa-solid fa-magnifying-glass"></i></span>
        </div>
        
    </div>
    <form:form  modelAttribute="product" action="shop/QL_SanPham.htm">
    <div class="boxEditProduct">    
        <div class="choooseTypeProduct">
            <strong>Loáº¡i sáº£n pháº©m</strong>
            <span class="textChoose">
                <span>Long-Shirt</span>    
                <i class="fa-solid fa-caret-down"></i>                            
            </span>                         
            <div class="combobox hideListTypeProduct">
                <form:select path="proType.proTypeId" items="${productTypeSelect }" itemValue="proTypeId" itemLable="proTypeName" ></form:select>
            </div>
        </div>          
        <div class="topBoxEditProduct">
            <div class="nameProduct">
                <span>TÃªn sáº£n pháº©m</span>
                <form:input path="name" type="text"
						id="exampleFormControlInput1"
						placeholder="Vui lòng nhập tên sản phẩm" />
            </div>
            <div class="idProduct">
                <span>MÃ´ táº£ sáº£n pháº©m</span>
                <i type="text">${ product.desc}</i>
            </div>
        </div>
        <div class="botBoxEditProduct">
            <div class="numProduct">
                <span>Sá» lÆ°á»£ng</span>
                <form:input path="qttInStock" type="text" 
						id="exampleFormControlInput1"
						placeholder="Vui lòng nhập số lượng  sản phẩm" />
            </div>
            <div class="priceProduct">
                <span>GiÃ¡ tiá»n</span>
                <form:input path="price" type="text" 
						id="exampleFormControlInput1"
						placeholder="Vui lòng nhập giá của sản phẩm" />
            </div>
            
        </div>
        <div class="endBoxEditProduct">
            <div class="imgProduct">
                <span>HÃ¬nh áº£nh</span>
                <input type="file">
            </div>
            <Button>LÆ°u</Button>
        </div>
    </div>
</form:form> 
    <div class="tableProduct">
        <div class="menuTypeProduct">
            <div class="typeProduct">Hoodie
                <input type="text" value="">
            </div>
            <button><i class="fa-solid fa-caret-down"></i></button>
            <div class="listTypeProduct hideListTypeProduct">
                <p>Long-Shirt</p>
                <p>Jacket</p>
                <p>T-Shirt</p>
                <p>Polo</p>
            </div>
        </div>
        <table>
            <thead>
                <tr>
                    <td>MÃ£ sáº£n pháº©m</td>
                    <td>TÃªn sáº£n pháº©m</td>
                    <td>Sá» lÆ°á»£ng</td>
                    <td>GiÃ¡ tiá»n</td>
                    <td>HÃ¬nh áº£nh</td>
                    <td></td>
                    
                </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="products">
                <tr>
                    <td>${product.id }</td>
                    <td>${product.name }</td>
                    <td>${product.proType.proTypeName}</td>
                    <td>${pd.qttInStock}</td>
					<td>${pd.price}</td>
                    <td><img width="50px" height="50px" src="${product.image }" ></td>
                    <td>
                        <i class="fa-solid fa-wrench"></i>
                        <i class="fa-solid fa-trash"></i>
                    </td>
                    
                </tr>
            </c:forEach>
                
            </tbody>
        </table>
    </div>
</div>