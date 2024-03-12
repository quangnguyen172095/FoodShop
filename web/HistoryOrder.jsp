<%-- 
    Document   : HistoryOrder
    Created on : Mar 10, 2024, 9:54:38 PM
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
        <title>History Order</title>
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
                        <strong>Lịch sử mua hàng</strong>
                        <div class="btn-group pull-right">

                        </div>
                    </div>

                    <div class="panel-body">
                        <c:forEach var="order" items="${orders}">
                            <div class="row">
                                <div class="col-md-11">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="pull-right">
                                                <label class="label label-danger">
                                                    <c:choose>
                                                        <c:when test="${order.getOrderStatus() eq 'Đang xử lý'}">
                                                            <span style="color: red;"><c:out value="${order.getOrderStatus()}" /></span><br />
                                                        </c:when>
                                                        <c:when test="${order.getOrderStatus() eq 'Đang giao hàng'}">
                                                            <span style="color: orange;"><c:out value="${order.getOrderStatus()}" /></span><br />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span style="color: green;"><c:out value="${order.getOrderStatus()}" /></span><br />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </label>
                                            </div>
                                            <span id="orderLink" style="color: black; text-decoration: none;"><strong><a href="historyorderdetail?orderid=${order.getOrderID()}">Đơn hàng</a></strong></span>
                                            <span class="label label-info">${order.getPaymentMethod()}</span><br />
                                            Giá tiền: 
                                            <fmt:formatNumber value="${order.getFreight()}" type="number" pattern="###,###,###" var="formattedFreight" />
                                            <span>${formattedFreight} VNĐ</span><br />
                                            <c:choose>
                                                <c:when test="${order.getTransactionStatus() == 'Chưa thanh toán'}">
                                                    <span style="color: red;"><c:out value="${order.getTransactionStatus()}" /></span><br />
                                                </c:when>
                                                <c:otherwise>
                                                    <span style="color: green;"><c:out value="${order.getTransactionStatus()}" /></span><br />
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                        <div class="col-md-12">Ngày: <c:out value="${order.getOrderDate()}" /></div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
    </body>
    <style>
        body{
            background:#eee;
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
