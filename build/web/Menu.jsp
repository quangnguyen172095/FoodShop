<%-- 
    Document   : Menu
    Created on : Jan 12, 2024, 9:44:31 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Menu</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font/flaticon.css">
        <link rel="stylesheet" href="assets/css/plugins/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/style.css" />
    </head>
    <body>
        <header class="menu-header">
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
                                    <c:forEach var="menuItem" items="${listHeader}">
                                        <li><a href="<c:out value='${menuItem.link}'/>"><c:out value='${menuItem.title}'/></a></li>
                                        </c:forEach>
                                        <c:choose>
                                            <c:when test="${sessionScope.ACC != null || sessionScope.CUS != null}">
                                            <li><a href="cart"><span class="flaticon-shopping-cart"></span></a></li>
                                                </c:when>
                                                <c:otherwise>
                                            <li><a href="LoginController" class="disabled"><span class="flaticon-shopping-cart"></span></a></li>
                                                </c:otherwise>
                                            </c:choose>
                                    <li>
                                        <c:if test="${sessionScope.ACC != null || sessionScope.CUS != null}">
                                            <c:choose>
                                                <c:when test="${sessionScope.CUS != null}">
                                                    <a href="DetailAccountController">
                                                        <i class="fa"></i>Xin chào ${sessionScope.CUS.getFullName()}
                                                    </a>
                                                </c:when>
                                            </c:choose>
                                            <a class="bk-btn" href="LogoutController">Đăng xuất</a>
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

        <main class="menu-main">
            <section class="bg-04" id="our-menu">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="row">
                                <c:forEach items="${listbypage}" var="l">
                                    <div class="col-md-4 col-sm-6">
                                        <div class="wrapper">
                                            <div class="tab-content">
                                                <figure>
                                                    <img src="<c:url value='/assets/images/menu/${l.getImage()}'/>">
                                                </figure>
                                                <div class="sentence">
                                                    <h3>
                                                        <a href="<c:url value='/productdetail?id=${l.getProductID()}'/> ">${l.getProductName()}</a>
                                                        <span>${Math.round((l.getPrice() - (l.getPrice() * l.getDiscount())) * 100) / 100} VNÐ</span>
                                                    </h3>
                                                    <h6>${l.getCategories().getCategoryName()}</h6>
                                                </div>
                                                <div class="rate-box">
                                                    <ol>
                                                        <li><span class="flaticon-star"></span></li>
                                                        <li><span class="flaticon-star"></span></li>
                                                        <li><span class="flaticon-star"></span></li>
                                                        <li><span class="flaticon-star"></span></li>
                                                    </ol>
                                                    <div class="d-flex">
                                                        <form action="cart" method="GET">
                                                            <input type="hidden" name="productID" value="${l.getProductID()}">
                                                            <button type="submit">
                                                                <span>Mua ngay</span>
                                                            </button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="category-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-sm-6">
                            <div class="wrapper">
                                <ul class="list-group-category">
                                    <c:forEach items="${listCategories}" var="l">
                                        <li class="list-group-category-item"><a href="category?cid=${l.getCategoryID()}">
                                                <span>${l.getCategoryName()}</span>
                                            </a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                </div>

            </section>
        </main>
        <!--phantrang-->
        <div class="pagination-container">
            <div class="pagination">
                <c:forEach begin="1" end="${endpage}" var="i">
                    <a href="menu?index=${i}">${i}</a>
                </c:forEach>
            </div>
        </div>

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
