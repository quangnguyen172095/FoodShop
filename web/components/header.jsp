<!-- Header Section Begin -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<header class="header-section header-normal">
    <div class="top-nav">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <ul class="tn-left">
<c:if test="${sessionScope.ACCUSER == null}">
    <li><i class="fa fa-phone"></i></li>
    <li><i class="fa fa-envelope"></i></li>
</c:if>


<c:if test="${sessionScope.ACCUSER != null}">
    <li><i class="fa fa-phone mt-4"></i>${sessionScope.ACCUSER.Phone}</li>
    <li><i class="fa fa-envelope mt-4"></i>${sessionScope.ACCUSER.email}</li>
</c:if>
</ul>
</div>
<div class="col-lg-6">
<div class="tn-right">
<div class="top-social">
<c:if test="${sessionScope.ACC != null}">
    <a href="DetailAccountController?user-id=${sessionScope.ACC.userId}"><i class="fa""></i>Hello ${sessionScope.ACC.fullname}</a>
    <a class="bk-btn" href="LogoutController" >Logout</a>
</c:if>
<c:if test="${sessionScope.ACC == null}">
    <a href="LoginController" class="bk-btn">Login</a>
</c:if>
</div>


<div class="language-option">
<img src="img/flag.jpg" alt="">
<span>EN <i class="fa fa-angle-down"></i></span>
<div class="flag-dropdown">
    <ul>
        <li><a href="#">Zi</a></li>
        <li><a href="#">Fr</a></li>
    </ul>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="menu-item">
<div class="container">
<div class="row">
<div class="col-lg-2">
<div class="logo">
<a href="./index.html">
<img src="img/logo.png" alt="">
</a>
</div>
</div>
<div class="col-lg-10">
<div class="nav-menu">
<nav class="mainmenu">
<ul>
    <li><a href="HomeController">Home</a></li>
    <li><a href="#">About Us</a></li>
    <li><a href="contact-us.html">Contact</a></li>
</ul>
</nav>
<div class="nav-right search-switch">
<i class="icon_search"></i>
</div>
</div>
</div>
</div>
</div>
</div>
</header>-->
<header>
    <div class="main-nav mb-5">
        <div class="container">
            <div class="row">
                <div class="menu-toggle"></div>
                <div class="logo">
                    <img src="assets/images/logo/logo.jpg">
                </div>

                <div class="my-nav">
                    <div class="menu">
                        <ul>
                            <li><a href="home">Home</a></li>
                            <li><a href="#about-us">About us</a></li>
                            <li><a href="#our-menu">Our Menu</a></li>
                            <li><a href="#blog">Blog</a></li>
                            <li><a href="#contact">Contact Us</a></li>
                            <li><a href="#"><span class="flaticon-shopping-cart"></span></a></li>
                            <li><a href="#">Booking Now</a></li>
                            <li>
                                <c:if test="${sessionScope.ACC != null}">
                                    <a href="DetailAccountController?user-id=${sessionScope.ACC.userId}"><i class="fa""></i>Hello ${sessionScope.ACC.fullname}</a>
                                    <a class="bk-btn" href="LogoutController" >Logout</a>
                                </c:if>
                                <c:if test="${sessionScope.ACC == null}">
                                    <a href="LoginController" class="bk-btn">Login</a>
                                </c:if>
                            </li>  
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Header End -->