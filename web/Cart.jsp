<%-- 
    Document   : Cart.jsp
    Created on : Jan 17, 2024, 5:54:04 PM
    Author     : PC
--%>
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

        <div class="container px-3 my-5 clearfix">
            <!-- Shopping cart table -->
            <div class="card">
                <div class="card-header">
                    <h2>Shopping Cart</h2>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered m-0">
                            <thead>
                                <tr>
                                    <!-- Set columns width -->
                                    <th class="text-center py-3 px-4" style="min-width: 400px;">Product Name &amp; Details</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Price</th>
                                    <th class="text-center py-3 px-4" style="width: 120px;">Quantity</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Total</th>
                                    <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.order.getOrderDetails()}" var="i">
                                    <tr>
                                        <td class="p-4">
                                            <div class="media align-items-center">
                                                <img src="./assets/images/menu/${i.image}" class="d-block ui-w-40 ui-bordered mr-4" alt="">
                                                <div class="media-body">
                                                    <a href="<c:url value='/productdetail?id=${i.getProductID()}'/> " class="d-block text-dark">${i.getProductName()}</a>

                                                </div>
                                            </div>
                                        </td>
                                        <td class="text-right font-weight-semibold align-middle p-4">${i.getPrice()} VNÐ</td>
                                        <td class="align-middle p-4"><input type="number" name="quantity" class="form-control text-center" value="${i.getQuantity()}" min="0" onchange="updateQuantity(this, ${i.getProductID()})"></td>
                                        <td class="text-right font-weight-semibold align-middle p-4">${String.format("%.2f", i.getQuantity() * i.getPrice())} VNÐ</td>
                                        <td class="text-center align-middle px-0"><a href="cart?productID=${i.getProductID()}&action=delete" class="shop-tooltip close float-none text-danger" title="" data-original-title="Remove">×</a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <!-- / Shopping cart table -->

                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="mt-4">
                            <label class="text-muted font-weight-normal">Promocode</label>
                            <input type="text" placeholder="ABC" class="form-control">
                        </div>
                        <div class="d-flex">
<!--                            <div class="text-right mt-4 mr-5">
                                <label class="text-muted font-weight-normal m-0">Discount</label>
                                <div class="text-large"><strong>$0</strong></div>
                            </div>-->
                            <div class="text-right mt-4">
                                <label class="text-muted font-weight-normal m-0">Total price</label>
                                <div class="text-large"><strong>${sessionScope.order.getTotalPrice()} VNÐ</strong></div>
                            </div>
                        </div>
                    </div>

                    <div class="float-right">
                        <button type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3">Back to shopping</button>
                        <button type="button" class="btn btn-lg btn-primary mt-2">Checkout</button>
                    </div>

                </div>
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
    <script>
                                            function updateQuantity(param, productID) {
                                                var quantity = param.value;
                                                console.log(quantity, productID);
                                                //Hiển thị giá trị số lượng và ID của sản phẩm trong console để kiểm tra.
                                                $.ajax({
                                                    url: "/swpfoodshop/cart",
                                                    type: "get", //send it throung get method
                                                    data: {
                                                        action: "update",
                                                        quantity: quantity,
                                                        productID: productID
                                                    },
                                                    success: function (data) {
                                                        setTimeout(() => {
                                                            window.location.href = './Cart.jsp';
                                                        }, 100);
                                                    },
                                                    error: function (xhr) {
                                                    }
                                                });
                                            }
    </script>
</html>
