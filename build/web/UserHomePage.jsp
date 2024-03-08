<%-- 
    Document   : UserHomePage
    Created on : Jan 3, 2024, 4:05:06 PM
    Author     : PC
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Restaurant</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font/flaticon.css">
        <link rel="stylesheet" href="assets/css/plugins/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/style.css" />
    </head>
    <!-- =================Body Started==================== -->
    <body>

        <!-- =================Header Started================ -->
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
        <!-- =================Header End================ -->
        <!-- ->->->->->->->->->->->->->->->->->->->->->->->->->->->->->-> -->

        <!-- ================================================================= -->
        <!-- ->->->->->->->->->->->->->->->->->->->->->->->->->->->->->-> -->
        <!-- =================Main Started================ -->
        <main>
            <section class="slider">
                <div class="shape"></div>
                <div class="shape-01"></div>
                <div class="banner">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="5000">
                        <ol class="carousel-indicators">
                            <c:forEach var="item" items="${listContent}" varStatus="status">
                                <li data-target="#carouselExampleIndicators" data-slide-to="${status.index}" class="${status.index == 0 ? 'active' : ''}"></li>
                                </c:forEach>
                        </ol>
                        <div class="carousel-inner">
                            <c:forEach var="item" items="${listContent}" varStatus="status">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-md-6 col-sm-12">
                                                <div class="wrapper">
                                                    <div class="content">
                                                        <h1>${item.getIntroduce()}</h1>
                                                        <h5>${item.getDescriptionIntro()}</h5>
                                                        <ol>
                                                            <li><a href="menu">${item.getButtonText()}<span class="flaticon-right-arrow"></span></a></li>
                                                        </ol>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-6 col-sm-12">
                                                <div class="wrapper">
                                                    <img src="<c:url value='/assets/images/slider/${item.getImage()}'/>">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                    </div>
                </div>
            </section>
            <!-- --------------------------------------------------------------------------- -->

            <!-- --------------------------------------------------------------------------- -->
            <section class="bg-02" id="about-us">
                <div class="shape-02"></div>
                <div class="shape-03"></div>
                <div class="shape-04"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-sm-12">
                            <div class="wrapper">
                                <div class="image">
                                    <img src="assets/images/${ch1.getImage()}">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12">
                            <div class="content">
                                <h2>${ch1.getIntroduce()}</h2>
                                <p>${ch1.getDescriptionIntro()}</p>
                                <ol>
                                    <li><a href="#">${ch1.getButtonText()}</a></li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- --------------------------------------------------------------------------- -->

            <!-- --------------------------------------------------------------------------- -->
            <section class="bg-04" id="our-menu">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="heading">
                                <h2>${ch2.getIntroduce()}</h2>
                                <p>${ch2.getDescriptionIntro()}</p>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="row">
                                <c:forEach items="${listProductHome}" var="l">
                                    <div class="col-md-4 col-sm-6">
                                        <div class="wrapper">
                                            <div class="tab-content">
                                                <figure>
                                                    <img src="<c:url value='/assets/images/menu/${l.getImage()}'/>">
                                                </figure>
                                                <div class="sentence">
                                                    <h3>
                                                        <a href="<c:url value='/productdetail?id=${l.getProductID()}'/> ">${l.getProductName()}</a>
                                                        <c:set var="price" value="${l.getPrice() - (l.getPrice() * l.getDiscount())}" />
                                                        <fmt:formatNumber type="number" value="${price}" pattern="###,###,###" var="formattedPrice" />

                                                        <span>${formattedPrice} VNĐ</span>
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
            <!--                                <div class="col-md-4 col-sm-6">
                                                <div class="wrapper">
                                                    <div class="tab-content">
                                                        <figure>
                                                            <img src="assets/images/menu/1.jpg">
                                                        </figure>
                                                        <div class="sentence">
                                                            <h3>hello<span>$10</span></h3>
                                                            <h6>Crab / Veggie / Soup</h6>
                                                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                                                            Repellendus unde fuga saepe accusantium hic iusto qui </p>
                                                        </div>
                                                        <div class="rate-box">
                                                            <ol>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                            </ol>
                                                            <div class="plus">
                                                                <a><span class="flaticon-plus"></span></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-6">
                                                <div class="wrapper">
                                                    <div class="tab-content">
                                                        <figure>
                                                            <img src="assets/images/menu/2.jpg">
                                                        </figure>
                                                        <div class="sentence">
                                                            <h3>Italian Source Mushroom<span>$12</span></h3>
                                                            <h6>Crab / Veggie / Soup</h6>
                                                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                                                            Repellendus unde fuga saepe accusantium hic iusto qui </p>
                                                        </div>
                                                        <div class="rate-box">
                                                            <ol>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                            </ol>
                                                            <div class="plus">
                                                                <a><span class="flaticon-plus"></span></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-6">
                                                <div class="wrapper">
                                                    <div class="tab-content">
                                                        <figure>
                                                            <img src="assets/images/menu/3.jpg">
                                                        </figure>
                                                        <div class="sentence">
                                                            <h3>Fried Potatoes With Garlic<span>$15</span></h3>
                                                            <h6>Crab / Veggie / Soup</h6>
                                                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                                                            Repellendus unde fuga saepe accusantium hic iusto qui </p>
                                                        </div>
                                                        <div class="rate-box">
                                                            <ol>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                            </ol>
                                                            <div class="plus">
                                                                <a><span class="flaticon-plus"></span></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-6">
                                                <div class="wrapper">
                                                    <div class="tab-content">
                                                        <figure>
                                                            <img src="assets/images/menu/4.jpg">
                                                        </figure>
                                                        <div class="sentence">
                                                            <h3>Fried Chicken Salad<span>$15</span></h3>
                                                            <h6>Crab / Veggie / Soup</h6>
                                                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                                                            Repellendus unde fuga saepe accusantium hic iusto qui </p>
                                                        </div>
                                                        <div class="rate-box">
                                                            <ol>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                            </ol>
                                                            <div class="plus">
                                                                <a><span class="flaticon-plus"></span></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-6">
                                                <div class="wrapper">
                                                    <div class="tab-content">
                                                        <figure>
                                                            <img src="assets/images/menu/5.jpg">
                                                        </figure>
                                                        <div class="sentence">
                                                            <h3>Fresh Crab With Lemon<span>$15</span></h3>
                                                            <h6>Crab / Veggie / Soup</h6>
                                                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                                                            Repellendus unde fuga saepe accusantium hic iusto qui </p>
                                                        </div>
                                                        <div class="rate-box">
                                                            <ol>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                            </ol>
                                                            <div class="plus">
                                                                <a><span class="flaticon-plus"></span></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-6">
                                                <div class="wrapper">
                                                    <div class="tab-content">
                                                        <figure>
                                                            <img src="assets/images/menu/6.jpg">
                                                        </figure>
                                                        <div class="sentence">
                                                            <h3>Grilled Salmon Sushi<span>$15</span></h3>
                                                            <h6>Crab / Veggie / Soup</h6>
                                                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                                                            Repellendus unde fuga saepe accusantium hic iusto qui </p>
                                                        </div>
                                                        <div class="rate-box">
                                                            <ol>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                                <li><span class="flaticon-star"></span></li>
                                                            </ol>
                                                            <div class="plus">
                                                                <a><span class="flaticon-plus"></span></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>-->
        </div>
    </div>
</div>
</div>
</section>
<!-- --------------------------------------------------------------------------- -->
<section class="bg-05">
    <div class="shape-03"></div>
    <div class="shape-04"></div>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="heading">
                    <h2>${ch3.getIntroduce()}</h2>
                    <p>${ch3.getDescriptionIntro()}</p>
                </div>
            </div>

            <div class="main-team-card d-flex">
                <c:forEach items="${admins}" var="member">
                    <div class="team-setup">
                        <div class="team-items">
                            <div class="team-user">
                                <img src="assets/images/team/${member.getImage()}">
                            </div>
                            <div class="team-name">
                                <h2>${member.getFullName()}</h2>
                                <b>${member.getRole()}</b>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>


        </div>
    </div>
</section>
<!-- -------------------------------------------------------------------- -->
<!--<section class="bg-06" id="blog">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="heading">
                    <span>Blog</span>
                    <h2>Explore Our News</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                        Asperiores officiis explicabo blanditiis consequuntur fugit 
                        fugiat, incidunt totam consectetur veritatis minus corporis
                        doloribus, qui maxime velit nesciunt, officia praesentium odit 
                        facilis.</p>
                </div>
            </div>

            <div class="blog-main-card d-flex">
                <article class="blog-sub">
                    <div class="blog-content">
                        <img src="assets/images/blog/1.jpg">
                    </div>
                    <div class="blog-content-section">
                        <div class="blo-content-title">
                            <h4>Possession so comparison inquietude he conviction </h4>
                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Neque at numquam, asperiores aut
                                praesentium
                                facilis ratione! Voluptatibus neque dignissimos ipsa atque veniam sint omnis in blanditiis, nemo fugit
                                animi assumenda.</p>
                        </div>
                        <div class="blog-admin">
                            <ol>
                                <li><i class="fal fa-user-tie"></i> By Admin</li>
                                <li><i class="fal fa-calendar-alt"></i> july 28, 2020</li>
                            </ol>
                        </div>
                    </div>
                </article>

                <article class="blog-sub">
                    <div class="blog-content">
                        <img src="assets/images/blog/2.jpg">
                    </div>
                    <div class="blog-content-section">
                        <div class="blo-content-title">
                            <h4>Possession so comparison inquietude he conviction </h4>
                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Neque at numquam, asperiores aut
                                praesentium
                                facilis ratione! Voluptatibus neque dignissimos ipsa atque veniam sint omnis in blanditiis, nemo fugit
                                animi assumenda.</p>
                        </div>
                        <div class="blog-admin">
                            <ol>
                                <li><i class="fal fa-user-tie"></i> By Admin</li>
                                <li><i class="fal fa-calendar-alt"></i> july 28, 2020</li>
                            </ol>
                        </div>
                    </div>
                </article>

                <article class="blog-sub">
                    <div class="blog-content">
                        <img src="assets/images/blog/3.jpg">
                    </div>
                    <div class="blog-content-section">
                        <div class="blo-content-title">
                            <h4>Possession so comparison inquietude he conviction </h4>
                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Neque at numquam, asperiores aut
                                praesentium
                                facilis ratione! Voluptatibus neque dignissimos ipsa atque veniam sint omnis in blanditiis, nemo fugit
                                animi assumenda.</p>
                        </div>
                        <div class="blog-admin">
                            <ol>
                                <li><i class="fal fa-user-tie"></i> By Admin</li>
                                <li><i class="fal fa-calendar-alt"></i> july 28, 2020</li>
                            </ol>
                        </div>
                    </div>
                </article>
            </div>
        </div>
    </div>
</section>-->
<!-- ------------------------------------------------------------------ -->

</section>
</main>



<!-- ================================================================= -->
<!-- ->->->->->->->->->->->->->->->->->->->->->->->->->->->->->-> -->
<!-- =================Main End================ -->

<!-- =====================>>>>>Footer Started>>>>>======================== -->

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
