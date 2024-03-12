<%-- 
    Document   : HistoryOrderDetail
    Created on : Mar 11, 2024, 3:02:34 PM
    Author     : PC
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>History Order Detail</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font/flaticon.css">
        <link rel="stylesheet" href="assets/css/plugins/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/style.css" />
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
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
        <div class="row flex-lg-nowrap">
            <div class="col-12 col-lg-auto mb-3 mn" style="width: 200px;">
                <div class="card p-3">
                    <div class="e-navlist e-navlist--active-bg">
                        <ul class="nav">
                            <li class="nav-item"><a class="nav-link px-2 active" href="editprofile"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>Thông tin</span></a></li>
                            <li class="nav-item"><a class="nav-link px-2" href="editpassword"><i class="fa fa-fw fa-cog mr-1"></i><span>Mật khẩu</span></a></li>
                            <li class="nav-item"><a class="nav-link px-2" href="historyorder"><i class="fa fa-fw fa-th mr-1"></i><span>Đơn hàng</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="container bootdey">
                <div class="panel panel-default panel-order">
                    <div class="panel-heading">
                        <strong>Chi tiết đơn hàng</strong>
                        <div class="btn-group pull-right">

                        </div>
                    </div>

                    <div class="panel-body large-text">
                        <c:forEach var="o" items="${foundOD}">
                            <div class="row">
                                <div class="col-md-11">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="pull-right">
                                                <label class="label label-danger">
                                                    <span>
                                                        <fmt:formatNumber value="${(o.getProducts().getPrice() - 
                                                                                   o.getProducts().getPrice() * o.getProducts().getDiscount())* o.getQuantity()}" type="number" pattern="###,###,###" var="formattedPrice" />
                                                                          ${formattedPrice} VNĐ
                                                        </span><br />
                                                    </label>
                                                </div>
                                                <figure>
                                                    <img src="<c:url value='/assets/images/menu/${o.getProducts().getImage()}'/>" class="product-image">
                                                </figure>         
                                                <span><strong><a href="<c:url value='/productdetail?id=${o.getProducts().getProductID()}'/> ">${o.getProducts().getProductName()}</a></strong></span> x
                                                <span class="label label-info">${o.getQuantity()}</span><br />
                                                Giá tiền: 
                                                <fmt:formatNumber value="${o.getProducts().getPrice() - o.getProducts().getPrice() * o.getProducts().getDiscount()}" type="number" pattern="###,###,###" var="formattedFreight" />
                                                <span>${formattedFreight} VNĐ</span><br />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <c:set var="totalPrice" value="${totalPrice + (o.getProducts().getPrice() - o.getProducts().getPrice() * o.getProducts().getDiscount()) * o.getQuantity()}" />
                            </c:forEach>
                            <div class="text-right">
                                Tổng tiền: 
                                <fmt:formatNumber value="${totalPrice}" type="number" pattern="###,###,###" var="formattedTotalPrice" />
                                ${formattedTotalPrice} VNĐ
                            </div>
                        </div>
                    </div>
                </div>
        </body>
        <style>
            body{
                background:#eee;
            }
            .product-image-container {
                width: 10%; /* Điều chỉnh kích thước của phần tử chứa ảnh */
                height: auto; /* Đảm bảo tỷ lệ chiều cao và chiều rộng tự động */
            }

            .product-image {
                max-width: 10%; /* Ảnh sẽ không vượt quá kích thước của phần tử chứa */
                height: auto; /* Đảm bảo tỷ lệ chiều cao và chiều rộng tự động */
            }
            .panel-order .row .col-md-12 a {
                font-size: 16px; /* Tăng kích thước chữ */
            }
            .panel-body.large-text {
                font-size: 16px; /* Thay đổi kích thước chữ */
                padding: 20px; /* Thay đổi padding */
            }

            .panel-order .row .col-md-12 {
                font-size: 14px; /* Thay đổi kích thước chữ */
            }

            .panel-order .row .col-md-1 img {
                width: 70px; /* Tăng kích thước ảnh */
                max-height: 70px; /* Tăng kích thước ảnh */
            }

            .panel-order .label.label-danger {
                font-size: 18px; /* Thay đổi kích thước chữ */
            }

            .panel-order .label.label-info {
                font-size: 16px; /* Thay đổi kích thước chữ */
            }
            .mn{
                margin-top: 190px
            }
            .panel-order{
                margin-top: 190px;
            }
            .panel-order .row {
                border-bottom: 1px solid #ccc;
            }
            .panel-order .row:last-child {
                border: 0px;
            }
            .panel-order .row .col-md-1  {
                text-align: center;
                padding-top: 15px;
            }
            .panel-order .row .col-md-1 img {
                width: 50px;
                max-height: 50px;
            }
            .panel-order .row .row {
                border-bottom: 0;
            }
            .panel-order .row .col-md-11 {
                border-left: 1px solid #ccc;
            }
            .panel-order .row .row .col-md-12 {
                padding-top: 7px;
                padding-bottom: 7px;
            }
            .panel-order .row .row .col-md-12:last-child {
                font-size: 11px;
                color: #555;
                background: #efefef;
            }
            .panel-order .btn-group {
                margin: 0px;
                padding: 0px;
            }
            .panel-order .panel-body {
                padding-top: 0px;
                padding-bottom: 0px;
            }
            .panel-order .panel-deading {
                margin-bottom: 0;
            }
        </style>
    </html>
