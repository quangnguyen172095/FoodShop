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
                                            <li><a href="Cart.jsp"><span class="flaticon-shopping-cart"></span></a></li>
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

        <div class="container px-3 my-5 clearfix">
            <!-- Shopping cart table -->
            <div class="card">
                <div class="card-header">
                    <h2>Giỏ hàng</h2>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered m-0">
                            <thead>
                                <tr>
                                    <!-- Set columns width -->
                                    <th class="text-center py-3 px-4" style="min-width: 400px; vertical-align: middle; white-space: nowrap;">Sản phẩm</th>
                                    <th class="text-right py-3 px-4" style="width: 100px; vertical-align: middle; white-space: nowrap;">Giá tiền</th>
                                    <th class="text-center py-3 px-4" style="width: 120px; vertical-align: middle;">Số lượng</th>
                                    <th class="text-right py-3 px-4" style="width: 100px; vertical-align: middle; white-space: nowrap;">Tổng</th>
                                    <th class="text-center align-middle py-3 px-0" style="width: 40px; vertical-align: middle;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                                </tr>
                            </thead>
                            <tbody id="cartList">
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
                                        <td class="text-right font-weight-semibold align-middle p-4">
                                            <fmt:formatNumber type="number" value="${Math.round((i.getPrice() - (i.getPrice() * i.getDiscount())) * 100) / 100}" pattern="###,###,###.##" var="formattedPrice"/>
                                            ${formattedPrice} VNĐ
                                        </td>
                                        <td class="align-middle p-4">
                                            <input type="number" name="quantity" class="form-control text-center" value="${i.getQuantity()}" min="0" onchange="updateQuantity(this, ${i.getProductID()})" onkeydown="return event.keyCode !== 69 && event.keyCode !== 189">
                                        </td>
                                        <td class="text-right font-weight-semibold align-middle p-4">
                                            <fmt:formatNumber type="number" value="${Math.round((i.getQuantity() * (i.getPrice() - (i.getPrice() * i.getDiscount())) * 100)) / 100}" pattern="###,###,###.##" var="formattedTotalPrice"/>
                                            ${formattedTotalPrice} VNĐ
                                        </td>
                                        <td class="text-center align-middle px-0"><a href="cart?productID=${i.getProductID()}&action=delete" class="shop-tooltip close float-none text-danger" title="" data-original-title="Remove">×</a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <!-- / Shopping cart table -->

                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="mt-4">
                            <label class="text-muted font-weight-normal"></label>
                        </div>
                        <div class="d-flex">
                            <!--                            <div class="text-right mt-4 mr-5">
                                                            <label class="text-muted font-weight-normal m-0">Discount</label>
                                                            <div class="text-large"><strong>$0</strong></div>
                                                        </div>-->
                            <div class="text-right mt-4">
                                <label class="text-muted font-weight-normal m-0">Tổng giá tiền</label>
                                <div class="text-large" id="totalPrice">
                                    <fmt:formatNumber type="number" value="${Math.round(sessionScope.order.getTotalPrice()*100)/100}" pattern="###,###,###.##" var="formattedTotalPrice"/>
                                    <strong>${formattedTotalPrice} VNĐ</strong>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="float-right">
                        <form action="checkout" method="GET">
                            <button type="submit" class="btn btn-lg btn-primary mt-2">Thanh toán</button>
                        </form>
                    </div>    
                    <div class="float-right">
                        <form action="menu" method="GET">
                            <button type="submit" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3">Tiếp tục mua hàng</button>
                        </form>
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
//                                                        setTimeout(() => {
//                                                            window.location.href = './Cart.jsp';
//                                                        }, 100);
                                                            var totalPrice = document.getElementById("totalPrice");
                                                            var cartList = document.getElementById("cartList");
                                                            var parsedResponse = JSON.parse(data);

                                                            totalPrice.innerHTML = parsedResponse.total;
                                                            cartList.innerHTML = parsedResponse.list;
                                                        },
                                                        error: function (xhr) {
                                                        }
                                                    });
                                                }
    </script>
</html>
