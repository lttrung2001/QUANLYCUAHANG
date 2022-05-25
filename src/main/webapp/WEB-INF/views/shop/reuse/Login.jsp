<!-- Login Management -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="mainLogin">
    <div class="formLogin">
        <form:form action="admin/login/index.htm" method="post" modelAttribute="admin">
            <div class="loginBox">
                <div class="user">
                    <span class="iconUser"><i class="fa-solid fa-user"></i></span>
                    <form:input path="username" type="text" placeholder="Enter Username" id="user" value=""/>      
                    <form:errors class="errorAdminLogin" path="username"></form:errors>
                </div>
                <div class="pass">
                    <span class="iconPass"><i class="fa-solid fa-lock"></i></span>
                    <form:input path="password" type="password" placeholder="Enter Password" id="pass" value=""/>               
                    <form:errors class="errorAdminLogin" path="password"></form:errors>
                    <i id="iconEye" class="fa-solid fa-eye" onclick="showPass()"></i>
                </div>
            </div>
            <div class="btnLogin"><form:button>Login</form:button></div>
<!--             <div class="remember"> -->
<!--                 <input type="checkbox" >Remember -->
<!--             </div> -->
        </form:form>
    </div>
</div>
<!-- End of Login Management -->