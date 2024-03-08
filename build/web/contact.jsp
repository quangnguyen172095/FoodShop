<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-color: #f0f0f0; /* Màu nền cho trang */
                font-family: Arial, sans-serif; /* Font chữ */
            }
            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .form-container {
                background-color: #ffa500; /* Màu cam */
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng đổ */
            }
            input[type="text"], input[type="submit"] {
                width: 100%;
                padding: 10px;
                padding-right: 0px;
                margin-bottom: 10px;
                border: none;
                border-radius: 5px;
            }
            input[type="submit"] {
                background-color: #4caf50; /* Màu nút Gửi */
                color: white;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #45a049; /* Màu hover của nút Gửi */
            }
            a {
                display: block;
                text-align: center;
                margin-top: 10px;
                text-decoration: none;
                color: #333;
            }
            a:hover {
                color: #555;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <h1 style="text-align: center;">CONTACT</h1>
                <form action="contact" method="post">
                    <h3 style="color: aqua">${requestScope.message}</h3>
                    <input type="text" name="fullName" placeholder="Enter fullname...">
                    <input type="text" name="phone" placeholder="Enter your phone...">
                    <input type="text" name="email" placeholder="Enter your email...">
                    <input type="text" name="message" placeholder="Enter message...">
                    <input type="submit" value="Gửi">
                    <a href="home">Quay lại</a>
                </form>
            </div>
        </div>
    </body>
</html>
