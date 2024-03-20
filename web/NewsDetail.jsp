<%-- 
    Document   : Menu
    Created on : Jan 12, 2024, 9:44:31 PM
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
        <title>Tin tức</title>
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


        <main class="">
            <div class="news-group d-flex justify-content-center">
                <section id="news-group-section">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <ul>
                                    <c:forEach items="${newsgroup}" var="newsGroup">
                                        <li><a href="newsgroup?id=${newsGroup.getNewsGroupId()}">${newsGroup.getNewsGroupName()}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </section>   
            </div>

            <div class="news-container">
                <h2 class="news-title">${news.getTitle()}</h2>
                <p class="news-date">${news.getModifiedOn()}</p>
                <p class="news-date">${news.getNewsGroup().getNewsGroupName()}</p>
                <p class="news-intro">${news.getContent()}</p>
                <p class="news-body">${news.getBody1()}</p>
                <div class="image-container">
                    <img src="<c:url value='/assets/images/blog/${news.getImage()}'/>" alt="Image 1" class="news-image">
                </div>
                <p class="news-body">${news.getBody2()}</p>
                <p class="news-body">${news.getBody3()}</p>
            </div>




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
        .news-date{
            font-size: 13px;
        }
        .image-container {
            display: flex;
            justify-content: center; /* Căn giữa hình ảnh */
            margin-top: 5px; /* Khoảng cách giữa hình ảnh và các đoạn văn bản */
        }

        .news-image {
            max-width: 100%; /* Đảm bảo hình ảnh không bị tràn ra ngoài */
            height: auto; /* Đảm bảo tỷ lệ khung hình ảnh được bảo toàn */
            align-self: center; /* Căn giữa theo chiều dọc */
            width: 600px;
        }
        /* Định nghĩa CSS cho phần tin tức */
        .news-container {
            margin-top: 20px;
            margin-left: 100px;
        }
        .news-title {
            font-size: 20px;
            font-weight: bold;
            color: #333;
        }
        .news-intro {
            font-size: 16px;
            color: #666;
            font-weight: bold; /* In đậm cho phần giới thiệu */
        }
        .news-body {
            font-size: 16px;
            color: #333;
            margin-top: 10px;
        }
        .news-image {
            max-width: 100%;
            height: auto;
            margin-top: 10px;
        }
        .news-group {
            margin-top: 170px;
            border: 1px solid #ccc; /* Tạo border với màu xám nhạt */
            border-radius: 5px; /* Làm mềm các góc */
            padding: 0px; /* Khoảng cách giữa border và nội dung bên trong */
            width: 100%; /* Chiều rộng là 100% của phần tử cha */
            box-sizing: border-box; /* Đảm bảo chiều rộng bao gồm cả border và padding */
        }

        .news-group ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .news-group ul li {
            display: inline-block;
            margin-right: 20px;
        }

        .news-group ul li a {
            color: #000;
            text-decoration: none;
            font-size: 16px;
        }

        .news-group ul li a:hover {
            color: #ff0000;
        }
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
