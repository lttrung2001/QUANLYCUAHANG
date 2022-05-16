<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My cart</title>
    <script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/my_css/CSS-Cart.css">
</head>
<body>
    <div class="shoppingCart">
        <div class="productCart">
            <h2>LIST YOUR PRODUCT:</h2>
            <div class="items">
                <div class="item">
                    <img src="/resources/my_image/short.png" >
                    <div class="nameItem">
                        <div class="typeItem">Shirt</div>
                        <div class="detailItem">T-Shirt Cotton</div>
                        <div class="sizeItem">Size[L]</div>
                    </div>
                    <div class="numberItem">
                        <button><i class="fa-solid fa-minus"></i></button>
                        <small>1</small>
                        <button><i class="fa-solid fa-plus"></i> </button>               
                    </div>
                    <div class="price">80$</div>
                    <button><i class="fa-solid fa-xmark"></i></button>
                </div>
                <div class="item">
                    <img src="/resources/my_image/T-Shirt.png" >
                    <div class="nameItem">
                        <div class="typeItem">Shirt</div>
                        <div class="detailItem">T-Shirt Cotton</div>
                        <div class="sizeItem">Size[L]</div>
                    </div>
                    <div class="numberItem">
                        <button><i class="fa-solid fa-minus"></i></button>
                        <small>1</small>
                        <button><i class="fa-solid fa-plus"></i> </button>               
                    </div>
                    <div class="price">100$</div>
                    <button><i class="fa-solid fa-xmark"></i></button>
                </div>
                <div class="item">
                    <img src="/resources/my_image/Polo.png" >
                    <div class="nameItem">
                        <div class="typeItem">Shirt</div>
                        <div class="detailItem">T-Shirt Cotton</div>
                        <div class="sizeItem">Size[L]</div>
                    </div>
                    <div class="numberItem">
                        <button><i class="fa-solid fa-minus"></i></button>
                        <small>1</small>
                        <button><i class="fa-solid fa-plus"></i> </button>               
                    </div>
                    <div class="price">110$</div>
                    <button><i class="fa-solid fa-xmark"></i></button>
                </div>
                <div class="item">
                    <img src="/resources/my_image/Hoodie.png" >
                    <div class="nameItem">
                        <div class="typeItem">Shirt</div>
                        <div class="detailItem">T-Shirt Cotton</div>
                        <div class="sizeItem">Size[L]</div>
                    </div>
                    <div class="numberItem">
                        <button><i class="fa-solid fa-minus"></i></button>
                        <small>1</small>
                        <button><i class="fa-solid fa-plus"></i> </button>               
                    </div>
                    <div class="price">220$</div>
                    <button><i class="fa-solid fa-xmark"></i></button>
                </div>
                
            </div>
            <div class="backShop">
                <a  href="#"><ion-icon name="return-up-back-outline"></ion-icon> Back to shop</a>
            </div>
        </div>
        <div class="checkout">
            <div class="detailCheckout">
                <div class="cartIcon">
                    <img src="/resources/my_png/Logo-byOanh.png" alt="">
                </div>
                <div class="totalItem">
                    <h4>ITEMS</h4>
                    <span>4</span>
                    <span>400$</span>
                </div>
            </div>
            <div class="shipping">
                <h4>SHIPPING</h4>
                <select name="Normal" id="">
                    <option value="">Normal-20$</option>
                    <option value="">Fast-35$</option>
                </select>
            </div>
            <div class="sale">
                <h4>SALE: </h4>
                <span>0</span>
            </div>
            <div class="totalPrice">
                <h4>TOTAL PRICE</h4>
                <span>420$</span>
            </div>
            <button>CHECKOUT</button>
            
        </div>
    </div>
</body>
</html>