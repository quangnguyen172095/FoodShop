<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet"href="css/style.css">
    </head>
    <body>
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-12 col-xl-11">
                        <div class="card text-black" style="border-radius: 5px;">
                            <div class="card-body p-md-5">
                                <div class="row justify-content-center">
                                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Quên mật khẩu</p>
                                        <form class="mx-1 mx-md-4" action="forgetPasswordController" method="post">
                                            
                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <label class="form-label" for="form3Example1c">Nhập tên đăng nhập hoặc email</label>
                                                    <input type="text" id="form3Example1c" class="form-control" required name="user"/>
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="d-block mx-4 mb-3 mb-lg-4  text-danger"><b>${mess}</b></div>
                                            <div class="d-block mx-4 mb-3 mb-lg-4 text-center">
                                                <button class="btn btn-primary btn-block px-5 w-100" type="submit">Gửi</button>
                                            </div>
                                            
                                            <div class="text-center pt-2">
                                                <a href="login.jsp">Quay lại đăng nhập</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
