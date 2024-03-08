

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="components/head.jsp"></jsp:include>
        </head>
        <body>
            <div class="container">
            <jsp:include page="components/header.jsp"></jsp:include>
            <div class="row mt-5 mb-5">
                
            </div>
            <div class="row mt-5 mb-5">
                
            </div>
                <main>
                    <section class="mt-5">
                        <div class="row">
                            <!-- Left column for avatar -->
                            <div class="col-md-3">
                                <!-- Placeholder for the avatar, you can customize this part -->
                                <img src="images/bg-01.jpg" alt="Avatar" class="img-fluid">
                            </div>

                            <!-- Right column for user information form -->
                            <div class="col-md-7">
                                <form action="DetailAccountController" method="post">
                                    <div class="form-group">
                                        <label for="username">Username:</label>
                                        <input type="hidden" class="form-control" id="user-id" name="user-id" value="${requestScope.USERDETAIL.userId}">
                                    <input type="text" class="form-control" id="username" name="username" value="${requestScope.USERDETAIL.username}" required readonly="">

                                </div>
                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input type="password" class="form-control" id="password" name="password" value="${requestScope.USERDETAIL.password}" required readonly="">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" id="email" name="email" value="${requestScope.USERDETAIL.email}" required>
                                </div>
                                <div class="form-group">
                                    <label for="fullname">Full Name:</label>
                                    <input type="text" class="form-control" id="fullname" name="fullname" value="${requestScope.USERDETAIL.fullname}" required>
                                </div>
                                <div class="form-group">
                                    <label for="role">Role:</label>
                                    <input type="text" class="form-control" id="role" name="role" value="${requestScope.USERDETAIL.role}" readonly="" required>
                                </div>
                                <div class="form-group">
                                    <label for="joinDate">Join Date:</label>
                                    <input type="date" class="form-control" id="joinDate" name="joinDate" value="${requestScope.USERDETAIL.joinDate}" readonly="" required>
                                </div>
                                <div class="form-group">
                                    <label for="phone">Phone:</label>
                                    <input type="tel" class="form-control" id="phone" value="${requestScope.USERDETAIL.phone}" name="phone">
                                </div>
                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <input type="text" class="form-control" id="address" value="${requestScope.USERDETAIL.address}" name="address">
                                </div>
                                <div class="form-group">
                                    <label for="department">Department:</label>
                                    <input type="text" class="form-control" id="department" value="${requestScope.USERDETAIL.department}" name="department">
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                            <div class="row">
                                <c:if test="${requestScope.MESSAGE != ''}">
                                    <p class="text-danger">${requestScope.MESSAGE}</p>
                                </c:if>
                            </div>
                        </div>
                    </div>  

                </section>
            </main>

        </div>

        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
