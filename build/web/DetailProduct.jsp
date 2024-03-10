<%-- 
    Document   : DetailProduct
    Created on : Jan 24, 2024, 3:47:41 PM
    Author     : PC
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                                                    <a href="editprofile">
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
                                        <fmt:formatNumber type="number" value="${product.getPrice()}" pattern="###,###,###" var="formattedOriginalPrice" />
                                        <span>${formattedOriginalPrice} VNĐ</span>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:formatNumber type="number" value="${product.getPrice()}" pattern="###,###,###" var="formattedOriginalPrice" />
                                        <span class="text-decoration-line-through">${formattedOriginalPrice} VNĐ</span>
                                        <c:set var="price" value="${product.getPrice() - (product.getPrice() * product.getDiscount())}" />
                                        <fmt:formatNumber type="number" value="${price}" pattern="###,###,###" var="formattedPrice" />

                                        <span>${formattedPrice} VNĐ</span>
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
                    <div class="col-lg-8 col-md-8 col-sm-12">
                        <div class="footer-content text-center"> <!-- Thêm class text-center -->
                            <h2>${ch4.getIntroduce()}</h2>
                            <p>${ch4.getDescriptionIntro()}</p>

                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12">
                        <div class="footer-content">
                            <ol>
                                <c:forEach var="link" items="${listHeader}">
                                    <li><a href="${link.getLink()}"><i class="flaticon-double-right-arrows-angles"></i>${link.getTitle()}</a></li>
                                        </c:forEach>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>

            <div class="copy-right">
                <div class="container">
                    <div class="copy-right-card">
                        <p>2020 @ All Rights Reserved Designed and developed by <a href="https://www.smarteyeapps.com">SmarteyeTechnologies</a></p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- ================================================================= -->
        <!-- ->->->->->->->->->->->->->->->->->->->->->->->->->->->->->-> -->
        <!-- =================Footer End================ -->

    </body>
    <!-- =================Body End==================== -->

    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/plugins/owl.carousel.min.js"></script>
    <script src="assets/js/script.js"></script>
    <style>
        .footer-content.text-center {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center; /* Canh giữa theo chiều ngang */
            height: 100%; /* Chiều cao 100% của cha */
            padding-bottom: 90px; /* Khoảng trống phía trên */
        }

        .footer-content.text-center > div {
            max-width: 80%; /* Độ rộng tối đa */
            margin: auto; /* Canh giữa theo chiều ngang */
            text-align: center; /* Canh giữa nội dung */
        }
    </style>
</html>
