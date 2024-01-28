<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="cssAdmin/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    </head>
    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>

            <script  type="text/javascript">
                function doDelete(adminId) {
                    if (confirm("Do you want to delete this admin?")) {
                        window.location = "DeleteAdminServlet?adminId=" + adminId;
                    }
                }
            </script>
            <style>
                #indexPage.active {
                    color: orange;
                    font-weight: bold;
                }
            </style>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>ADMIN</b></p>
                    <p class="app-sidebar__user-designation">Welcome Back!</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item haha" href="phan-mem-ban-hang.html"><i class='app-menu__icon bx bx-cart-alt'></i>
                        <span class="app-menu__label">POS</span></a></li>
                <li><a class="app-menu__item " href="index.html"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Dashboard</span></a></li>
                <li><a class="app-menu__item " href="ListAdminServlet"><i class='app-menu__icon bx bx-id-card'></i>
                        <span class="app-menu__label active">Employees Management</span></a></li>
                <li><a class="app-menu__item " href="ListCustomerServlet"><i class='app-menu__icon bx bx-user-voice'></i><span
                            class="app-menu__label">Customer Management</span></a></li>
                <li><a class="app-menu__item" href="ListProductServlet"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Product Management</span></a>
                </li>
                <li><a class="app-menu__item" href="ListCategoryServlet"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Category Management</span></a>
                </li>
                <li><a class="app-menu__item" href="table-data-oder.html"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Order Management</span></a></li>
                <li><a class="app-menu__item" href="quan-ly-bao-cao.html"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Statement of Income</span></a>
                </li>
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">System Setting</span></a></li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>List of Products</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">
                                <div class="col-sm-2">

                                    <a class="btn btn-add btn-sm" href="AddProductServlet" title="Thêm"><i class="fas fa-plus"></i>
                                        Add Product</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm nhap-tu-file" type="button" title="Nhập" onclick="myFunction(this)"><i
                                            class="fas fa-file-upload"></i>Download from File</a>
                                </div>

                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                                            class="fas fa-print"></i>Print Data</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm print-file js-textareacopybtn" type="button" title="Sao chép"><i
                                            class="fas fa-copy"></i>Copy</a>
                                </div>

                                <div class="col-sm-2">
                                    <a class="btn btn-excel btn-sm" href="" title="In"><i class="fas fa-file-excel"></i>Export Excel</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)"><i
                                            class="fas fa-file-pdf"></i>Export PDF</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm" type="button" title="Xóa" onclick="myFunction(this)"><i
                                            class="fas fa-trash-alt"></i>Delete All</a>
                                </div>
                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th width="10"><input type="checkbox" id="all"></th>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Image</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Status</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.products}" var="product">
                                        <tr>
                                            <td width="10"><input type="checkbox" name="check1" value="1"></td>
                                            <td>${product.productID}</td>
                                            <td>${product.productName}</td>
                                            <td width="100px">
                                                <img src="<c:url value='/assetsAdmin/img/${product.image}'/>" alt="" width="100px;">
                                            </td>
                                            <td>${product.price}</td>
                                            <td>${product.quantity}</td>
                                            <td><span class="badge bg-success">${product.status}</span></td>
                                            <td class="table-td-center"><button class="btn btn-primary btn-sm trash" type="button" title="Delete"
                                                                                onclick="doDelete('${product.productID}')"><i class="fas fa-trash-alt"></i>
                                                </button>
                                                <a class="btn btn-primary btn-sm edit" href="UpdateProductServlet?productId=${product.productID}" title="Update">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <c:forEach begin="1" end="${endP}" var="i">
                                <a class="${tag == i?"active":""}" id="indexPage" href="ListProductServlet?index=${i}">${i}</a>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Essential javascripts for application to work-->
        <script src="jsAdmin/jquery-3.2.1.min.js"></script>
        <script src="jsAdmin/popper.min.js"></script>
        <script src="jsAdmin/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="jsAdmin/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="jsAdmin/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="jsAdmin/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="jsAdmin/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">
                                                                                    $('#sampleTable').DataTable();
                                                                                    function time() {
                                                                                        var today = new Date();
                                                                                        var weekday = new Array(7);
                                                                                        weekday[0] = "Sunday";
                                                                                        weekday[1] = "Mondayi";
                                                                                        weekday[2] = "Tuesday";
                                                                                        weekday[3] = "Wednesday";
                                                                                        weekday[4] = "Thursday";
                                                                                        weekday[5] = "Friday";
                                                                                        weekday[6] = "Sartuday";
                                                                                        var day = weekday[today.getDay()];
                                                                                        var dd = today.getDate();
                                                                                        var mm = today.getMonth() + 1;
                                                                                        var yyyy = today.getFullYear();
                                                                                        var h = today.getHours();
                                                                                        var m = today.getMinutes();
                                                                                        var s = today.getSeconds();
                                                                                        m = checkTime(m);
                                                                                        s = checkTime(s);
                                                                                        nowTime = h + ":" + m + ":" + s;
                                                                                        if (dd < 10) {
                                                                                            dd = '0' + dd
                                                                                        }
                                                                                        if (mm < 10) {
                                                                                            mm = '0' + mm
                                                                                        }
                                                                                        today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                                                                                        tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                                                                                                '</span>';
                                                                                        document.getElementById("clock").innerHTML = tmp;
                                                                                        clocktime = setTimeout("time()", "1000", "Javascript");

                                                                                        function checkTime(i) {
                                                                                            if (i < 10) {
                                                                                                i = "0" + i;
                                                                                            }
                                                                                            return i;
                                                                                        }
                                                                                    }
        </script>
        <script>
            function deleteRow(r) {
                var i = r.parentNode.parentNode.rowIndex;
                document.getElementById("myTable").deleteRow(i);
            }
            oTable = $('#sampleTable').dataTable();
            $('#all').click(function (e) {
                $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
                e.stopImmediatePropagation();
            });
        </script>
    </body>
</html>
