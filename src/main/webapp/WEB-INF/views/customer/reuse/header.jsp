<div id="header">
    <nav class="container">
        <a  id="logo" href="#home">
            <img src="my_png/Logo-byOanh.png" alt="CAB Shop">				
        </a>
        
        <ul id="main-menu">
            <li><a class="style-menu " href="#home" >HOME</a></li>
            <li class="Option"><a class="style-menu" href="#top">TOP</a>
                <ul class="top-menu sub-menu ">
                    <li><a href="#" onclick="notification_option()">T-Shirts</a></li>
                    <li><a href="#" onclick="notification_option()">Jackets</a></li>
                    <li><a href="#" onclick="notification_option()">Hoodies</a></li>
                    <li><a href="#" onclick="notification_option()">Polos</a></li>
                    <li><a href="#" onclick="notification_option()">Long-Shirts</a></li>

                </ul>
            </li>
            
            <li class="Option"><a class="style-menu" href="#bot" >BOT</a>
                <ul class="bot-menu sub-menu">
                    <li><a href="#" onclick="notification_option()">Skirts</a></li>
                    <li><a href="#" onclick="notification_option()">Pants</a></li>
                    <li><a href="#" onclick="notification_option()">Shorts</a></li>
                    <li><a href="#" onclick="notification_option()">Jeans</a></li>
                </ul>
            </li>
            <li class="Option"><a class="style-menu" href="#sale">SALE</a>
                <ul class="sale-menu sub-menu">
                    <li><a href="#" onclick="notification_option()">90%</a></li>
                    <li><a href="#" onclick="notification_option()">70%</a></li>
                    <li><a href="#" onclick="notification_option()">50%</a></li>
                </ul>

            </li>
            <!-- <li><a href="#contact" class="style-menu">CONTACT</a></li> -->
        </ul>
        <div id="header-icon">
            <!-- <span id="icon-account"> <ion-icon name="person-circle"></ion-icon></span> -->
            <div class="icon-button-header">
                <button id="icon-person-btn" ><ion-icon name="person-outline"></ion-icon></button>
                <ul id="login_signup" class="hideAccount">
                    <li><button type="button" id="Login">Log in</button></li>
                    <li><button type="button"  id="Signup">Sign up</button></li>
                </ul>
            </div>
            <div class="iconLogged">
                <button><ion-icon name="person"></ion-icon></button>
                <ul class="menuLogged hide">
                    <li class="changeInfor"><a href="#">Thay đổi thông tin</a></li>
                    <li class="history"><a href="#">Lịch sử</a></li>
                    <li class="logOut"><a href="#">Đăng xuất</a></li>
                </ul>
            </div>
            <div class="icon-button-header">
                <button id="icon-search-btn"  ><ion-icon name="search-outline" ></ion-icon></button>
                <div class="search-input hide" >
                    <form class="search-form" action="">
                        <input  type="text" placeholder="Search.." name="search">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
            <div class="icon-button-header iconCart">
                <button id="icon-bag-btn"><a href="Cart.html"><ion-icon name="cart-outline"></ion-icon></a></button>
                <small id="icon-cart">
                    0
                </small>
            </div>
        </div>
    </nav>
</div>
<!-- Dynamic background -->
    <div class="dynamic_background">
        <div class="b-left"></div>
        <div class="b-right"></div>
    </div>
    
<!-- End of Dynamic background -->