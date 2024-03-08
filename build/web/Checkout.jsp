<%-- 
    Document   : Cart.jsp
    Created on : Jan 17, 2024, 5:54:04 PM
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
        <title>Cart</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font/flaticon.css">
        <link rel="stylesheet" href="assets/css/plugins/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/style.css" />
        <link rel="stylesheet" href="assets/css/style.cart.css" />
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

        <div class="container px-3 my-5 clearfix">
            <!-- Shopping cart table -->
            <div class="card">
                <div class="card-header">
                    <h2>Thanh toán</h2>
                    <c:if test="${message != null}">
                        <div style="color: green;">
                            ${message}
                        </div>
                    </c:if>
                    <c:if test="${errorMessage != null}">
                        <div style="color: red;">
                            ${errorMessage}
                        </div>
                    </c:if>
                </div>
                <div class="card-body">
                    <div class="cart-table-area section-padding-100">
                        <div class="container-fluid">
                            <form action="checkout" method="post">
                                <div class="row">
                                    <div class="col-12 col-lg-8">
                                        <div class="checkout_details_area mt-50 clearfix">
                                            <div class="row">
                                                <div class="col-12 mb-3">
                                                    <input type="text" class="form-control" id="address" placeholder="Nhập địa chỉ" value="" required name="address">
                                                </div>


                                                <div class="col-12 mb-3">
                                                    <textarea name="comment" class="form-control w-100" id="comment" cols="30" rows="5" placeholder="Ghi chú"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-lg-4">
                                        <div class="cart-summary">
                                            <h5>Chi tiết hóa đơn</h5>
                                            <ul class="summary-table mt-3">
                                                <li><span>Sản phẩm:</span> <span></span></li>

                                                <c:forEach items="${sessionScope.order.getOrderDetails()}" var="i">
                                                    <li><div>

                                                            <span style="padding-left: 30px">${i.getProductName()} x ${i.getQuantity()}: </span>

                                                            <div style="float: right">
                                                                <c:set var="price" value="${i.getPrice() - (i.getPrice() * i.getDiscount())}" />
                                                                <fmt:formatNumber type="number" value="${price}" pattern="###,###,###" var="formattedPrice" />

                                                                <span><c:out value="${formattedPrice}" /> VNĐ</span>
                                                            </div></div>
                                                    </li>
                                                </c:forEach>

                                                <li>
                                                    <span>Tổng tiền:</span>
                                                    <div style="float: right">
                                                        <fmt:formatNumber type="number" value="${Math.round(sessionScope.order.getTotalPrice()*100)/100}" pattern="###,###,###.##" var="formattedTotalPrice"/>
                                                        <strong>${formattedTotalPrice} VNĐ</strong>
                                                    </div>
                                                </li>
                                            </ul>

                                            <div class="payment-method mt-3">
                                                <!-- Cash on delivery -->
                                                <div class="custom-control custom-checkbox mr-sm-2">
                                                    <input type="radio" class="custom-control-input" id="cod" name="paymentMethod" value="1" checked>
                                                    <label class="custom-control-label" for="cod">Thanh toán khi giao hàng</label>
                                                </div>
                                                <!-- Paypal -->
                                                <div class="custom-control custom-checkbox mr-sm-2">
                                                    <input type="radio" class="custom-control-input" id="paypal" value="2" name="paymentMethod">
                                                    <label class="custom-control-label" for="paypal">VNPay</label>
                                                </div>
                                            </div>

                                            <div class="cart-btn mt-100">
                                                <input class="btn btn-lg btn-primary w-100 mt-3" type="submit" value="Thanh toán">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
