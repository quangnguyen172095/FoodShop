<%-- 
    Document   : SignupVerify
    Created on : Mar 4, 2024, 1:23:41 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xác minh đăng ký</title>
        <style>
            body {
                background: #63738a;
                font-family: 'Roboto', sans-serif;
            }
            .form-control {
                height: 40px;
                box-shadow: none;
                color: #969fa4;
            }
            .form-control:focus {
                border-color: #5cb85c;
            }
            .form-control, .btn {
                border-radius: 3px;
            }
            .signup-form {
                width: 450px;
                margin: 0 auto;
                padding: 30px 0;
                font-size: 15px;
                background: #f2f3f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            }
            .signup-form h2 {
                color: #636363;
                margin: 0 0 15px;
                position: relative;
                text-align: center;
            }
            .signup-form h2:before, .signup-form h2:after {
                content: "";
                height: 2px;
                width: 30%;
                background: #d4d4d4;
                position: absolute;
                top: 50%;
                z-index: 2;
            }
            .signup-form h2:before {
                left: 0;
            }
            .signup-form h2:after {
                right: 0;
            }
            .signup-form .hint-text {
                color: #999;
                margin-bottom: 30px;
                text-align: center;
            }
            .signup-form form {
                color: #999;
                border-radius: 3px;
                margin-bottom: 15px;
                padding: 30px;
            }
            .signup-form .form-group {
                margin-bottom: 20px;
            }
            .signup-form input[type="submit"] {
                font-size: 16px;
                font-weight: bold;
                min-width: 140px;
                outline: none !important;
            }
            .signup-form a {
                color: #fff;
                text-decoration: underline;
            }
            .signup-form a:hover {
                text-decoration: none;
            }
            .signup-form form a {
                color: #5cb85c;
                text-decoration: none;
            }
            .signup-form form a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="signup-form">
            <h2>Xác minh đăng ký</h2>
            <span style="color: black;">Chúng tôi đã gửi một mã bảo mật đến Email của bạn.</span>
            <span style="color: black;">Kiểm tra Email để lấy mã</span>
            <form action="signupverify" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="scode" placeholder="Nhập mã xác minh" required>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success btn-lg btn-block" value="Xác minh">
                </div>
            </form>
            <h5 style="color: red; margin-bottom: 30px">${requestScope.mess}</h5>   
        </div>
    </body>
</html>
