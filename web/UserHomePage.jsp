<%-- 
    Document   : UserHomePage
    Created on : Jan 3, 2024, 4:05:06 PM
    Author     : PC
--%>

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
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="wrapper">
                                                <div class="content">
                                                    <h1>your favourite food delivered & fresh</h1>
                                                    <h5>Lorem ipsum dolor sit, amet consectetur 
                                                        adipisicing elit. Consequuntur, natus magnam 
                                                        incidunt iste, architecto voluptate amet veniam 
                                                        odio, reiciendis modi</h5>
                                                    <ol>
                                                        <li><a href="menu">Đặt Hàng Ngay<span class="flaticon-right-arrow"></span></a></li>
                                                    </ol>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6 col-sm-12">
                                            <div class="wrapper">
                                                <img src="assets/images/slider/slide-01.png">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="wrapper">
                                                <div class="content">
                                                    <h1>your favourite food delivered & fresh</h1>
                                                    <h5>Lorem ipsum dolor sit, amet consectetur 
                                                        adipisicing elit. Consequuntur, natus magnam 
                                                        incidunt iste, architecto voluptate amet veniam 
                                                        odio, reiciendis modi</h5>
                                                    <ol>
                                                        <li><a href="#">Đặt Hàng Ngay<span class="flaticon-right-arrow"></span></a></li>
                                                    </ol>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6 col-sm-12">
                                            <div class="wrapper">
                                                <img src="assets/images/slider/slide-02.png">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="wrapper">
                                                <div class="content">
                                                    <h1>your favourite food delivered & fresh</h1>
                                                    <h5>Lorem ipsum dolor sit, amet consectetur 
                                                        adipisicing elit. Consequuntur, natus magnam 
                                                        incidunt iste, architecto voluptate amet veniam 
                                                        odio, reiciendis modi</h5>
                                                    <ol>
                                                        <li><a href="#">Đặt Hàng Ngay<span class="flaticon-right-arrow"></span></a></li>
                                                    </ol>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6 col-sm-12">
                                            <div class="wrapper">
                                                <img src="assets/images/slider/slide-03.png">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
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
                                    <img src="assets/images/about.png">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12">
                            <div class="content">
                                <span>About</span>
                                <h2>Food Is Important part of a balanced diet</h2>
                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. 
                                    Provident expedita et laudantium excepturi. Quia obcaecati 
                                    alias a sunt, magnam sint voluptate sequi</p>

                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. 
                                    Provident expedita et laudantium excepturi. Quia obcaecati 
                                    alias a sunt, magnam sint voluptate sequi</p>
                                <ol>
                                    <li><a href="#">Learn More</a></li>
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
                                <span>Menu</span>
                                <h2>Explore Our Best Menu</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                                    Asperiores officiis explicabo blanditiis consequuntur fugit 
                                    fugiat, incidunt totam consectetur veritatis minus corporis
                                    doloribus, qui maxime velit nesciunt, officia praesentium odit 
                                    facilis.</p>
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
                    <span>Team</span>
                    <h2>Explore Our Team</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                        Asperiores officiis explicabo blanditiis consequuntur fugit 
                        fugiat, incidunt totam consectetur veritatis minus corporis
                        doloribus, qui maxime velit nesciunt, officia praesentium odit 
                        facilis.</p>
                </div>
            </div>

            <div class="main-team-card d-flex">
                <div class="team-setup">
                    <div class="team-items">
                        <div class="team-user">
                            <img src="assets/images/team/1.jpg">
                        </div>
                        <div class="team-user-social">
                            <ol>
                                <li><i class="flaticon-facebook"></i></li>
                                <li><i class="flaticon-twitter"></i></li>
                                <li><i class="flaticon-behance"></i></li>
                                <li><i class="flaticon-youtube"></i></li>
                            </ol>
                        </div>
                        <div class="team-name">
                            <h2>Mark Anthony</h2>
                            <b>Founder & CEO</b>
                        </div>
                    </div>
                </div>

                <div class="team-setup">
                    <div class="team-items">
                        <div class="team-user">
                            <img src="assets/images/team/2.jpg">
                        </div>
                        <div class="team-user-social">
                            <ol>
                                <li><i class="flaticon-facebook"></i></li>
                                <li><i class="flaticon-twitter"></i></li>
                                <li><i class="flaticon-behance"></i></li>
                                <li><i class="flaticon-youtube"></i></li>
                            </ol>
                        </div>
                        <div class="team-name">
                            <h2>Jessica Lee</h2>
                            <b>Chinese Kitchen Lead</b>
                        </div>
                    </div>
                </div>

                <div class="team-setup">
                    <div class="team-items">
                        <div class="team-user">
                            <img src="assets/images/team/3.jpg">
                        </div>
                        <div class="team-user-social">
                            <ol>
                                <li><i class="flaticon-facebook"></i></li>
                                <li><i class="flaticon-twitter"></i></li>
                                <li><i class="flaticon-behance"></i></li>
                                <li><i class="flaticon-youtube"></i></li>
                            </ol>
                        </div>
                        <div class="team-name">
                            <h2>John Bennett</h2>
                            <b>French Kitchen Lead</b>
                        </div>
                    </div>
                </div>

                <div class="team-setup">
                    <div class="team-items">
                        <div class="team-user">
                            <img src="assets/images/team/4.jpg">
                        </div>
                        <div class="team-user-social">
                            <ol>
                                <li><i class="flaticon-facebook"></i></li>
                                <li><i class="flaticon-twitter"></i></li>
                                <li><i class="flaticon-behance"></i></li>
                                <li><i class="flaticon-youtube"></i></li>
                            </ol>
                        </div>
                        <div class="team-name">
                            <h2>ANDERSON JHON</h2>
                            <b>Sous Chef</b>
                        </div>
                    </div>
                </div>
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

</html>
