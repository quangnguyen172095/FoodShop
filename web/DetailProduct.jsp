<%-- 
    Document   : DetailProduct
    Created on : Jan 24, 2024, 3:47:41 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Detail Product</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font/flaticon.css">
        <link rel="stylesheet" href="assets/css/plugins/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/style.css" />
        <link rel="stylesheet" href="assets/css/stylesdetail.css" />
    </head>
    <body>
        <header>
            <div class="main-nav">
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
                                    <li><a href="menu">Our Menu</a></li>
                                    <li><a href="#blog">Blog</a></li>
                                    <li><a href="#contact">Contact Us</a></li>
                                        <c:choose>
                                            <c:when test="${sessionScope.ACC != null || sessionScope.CUS != null}">
                                            <li><a href="Cart.jsp"><span class="flaticon-shopping-cart"></span></a></li>
                                                </c:when>
                                                <c:otherwise>
                                            <li><a href="LoginController" class="disabled"><span class="flaticon-shopping-cart"></span></a></li>
                                                </c:otherwise>
                                            </c:choose>
                                    <li><a href="menu">Booking Now</a></li>
                                    <li>
                                        <c:if test="${sessionScope.ACC != null || sessionScope.CUS != null}">
                                            <c:choose>
                                                <c:when test="${sessionScope.CUS != null}">
                                                    <a href="DetailAccountController">
                                                        <i class="fa"></i>Hello ${sessionScope.CUS.getFullName()}
                                                    </a>
                                                </c:when>
                                            </c:choose>
                                            <a class="bk-btn" href="LogoutController">Logout</a>
                                        </c:if>
                                        <c:if test="${sessionScope.ACC == null && sessionScope.CUS == null}">
                                            <a href="LoginController" class="bk-btn">Đăng nhập</a>
                                        </c:if>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <main>
            <section class="py-5">
                <div class="container px-4 px-lg-5 my-5">
                    <div class="row gx-4 gx-lg-5 align-items-center">
                        <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="<c:url value='/assets/images/menu/${product.getImage()}'/>" alt="..." /></div>
                        <div class="col-md-6">
                            <h1 class="display-5 fw-bolder">${product.getProductName()}</h1>
                            <div class="fs-5 mb-5">
                                <c:choose>
                                    <c:when test="${product.getDiscount() == 0}">
                                        <span>${product.getPrice()} VNÐ</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="text-decoration-line-through">${product.getPrice()} VNÐ</span>
                                        <span>${Math.round((product.getPrice() - (product.getPrice() * product.getDiscount())) * 100) / 100} VNÐ</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <p class="lead">${product.getDescription()}</p>
                            <div class="d-flex">
                                <form action="cart" method="GET">
                                    <input type="hidden" name="productID" value="${product.getProductID()}">
                                    <button type="submit">
                                        <span>Mua ngay</span>
                                    </button>
                                </form>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>


        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                        <div class="footer-content">
                            <h2>SMART CHARITABLES</h2>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maxime adipisci veniam
                                voluptatum voluptatem sed ex error beatae, asperiores dignissimos?</p>
                            <ul>
                                <li><i class="flaticon-facebook"></i></li>
                                <li><i class="flaticon-twitter"></i></li>
                                <li><i class="flaticon-behance"></i></li>
                                <li><i class="flaticon-instagram"></i></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                        <div class="footer-content">
                            <h2>Quick Links</h2>
                            <ol>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Home</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>About Us</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Services</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Blog</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Contact Us</a></li>
                            </ol>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                        <div class="footer-content">
                            <h2>Services</h2>
                            <ol>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Home</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>About Us</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Services</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Blog</a></li>
                                <li><a href="#"><i class="flaticon-double-right-arrows-angles"></i>Contact Us</a></li>
                            </ol>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                        <div class="footer-content">
                            <h2>News Letters</h2>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.</p>
                            <div class="form-group">
                                <input class="form-control" role="" name="email" type="email" placeholder="Enter Your Email">
                                <i class="flaticon-send"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copy-right">
                <div class="container">
                    <div class="copy-right-card">
                        <p>2020 @ All Rights Reserved Designed and developed by<a
                                href="https://www.smarteyeapps.com">SmarteyeTechnologies</a></p>
                    </div>
                </div>
            </div>
        </footer>
    </body>
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/plugins/owl.carousel.min.js"></script>
    <script src="assets/js/script.js"></script>
</html>
