<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<!-- Load More -->
<!-- <div href="#" id="loadMore"> -->
<!--     <a href="#">Load More</a> -->
<!-- </div> -->
<!-- End of Load More -->
<tag:paginate max="${10 }" offset="${offset}" count="${count}" uri="${pageContext.servletContext.contextPath }/home.htm" next="&raquo;" previous="&laquo;"/>
<!---------------------------------------------Contact-->
<footer id="contact">
    <div class="footer-left">
        <ul>
            <li>Return Policy</li>
            <li>About CAB</li>
        </ul>
    </div>
    <div class="footer-center">
        <span>©2022 CAB, LLC. All Rights Reserved.</span>
    </div>
    <div class="footer-right">
        <ul>
            <li>Contact Us</li>
            <li>Facebook</li>
            <li>Instagram</li>
        </ul>
    </div>
</footer>