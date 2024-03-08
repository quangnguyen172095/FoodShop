<%-- 
    Document   : orderManagement
    Created on : 18-Jan-2024, 08:40:33
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Orders</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="cssheet/main.css">
        <!-- Font-icon css-->
        <link href="asset/fonts/themify-icons-font/themify-icons/themify-icons.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.4/xlsx.full.min.js"></script>

        <script type="text/javascript">
            function submitForm() {
                document.getElementById("submitForm").submit();
            }
            function exportToExcel() {
                var jsonData = [];
                // Lặp qua các đơn hàng và thêm vào mảng JSON
            <c:forEach var="l" items="${listAllOrders}">
                var orderData = {};
                orderData['OrderID'] = "${l.getOrderID()}";
                orderData['Customer'] = "${l.getCustomers().getFullName()}";
                orderData['Order Date'] = "${l.getOrderDate()}";
                orderData['Staff'] = "${l.getCreatedByAdmin().getFullName()}";
                orderData['Payment Method'] = "${l.paymentMethod}";
                orderData['Order Status'] = "${l.getOrderStatus()}";
                jsonData.push(orderData);
            </c:forEach>

                // Tạo một đối tượng workbook mới
                var wb = XLSX.utils.book_new();
                // Tạo một sheet từ dữ liệu JSON
                var ws = XLSX.utils.json_to_sheet(jsonData);
                XLSX.utils.book_append_sheet(wb, ws, "Đơn Đặt Hàng");
                // Tải xuống file Excel
                XLSX.writeFile(wb, "DonDatHang.xlsx");
            }
        </script>
        <style>
            #test {
                overflow-x: auto;
                overflow-y: hidden;
            }
            #test table th,
            #test table td{
                text-align: center;
                padding: 20px;
            }
            #test a{
                text-decoration: none;
                color: blue;
            }
            #test a:hover{
                color: orange;
            }
            .end-page{
                text-align: right;
            }
            .end-page button{
                display: inline-block;
                padding: 8px 12px;
                text-decoration: none;
                color: black;
                border: 1px solid black;
                border-radius: 4px;
                margin: 10px 10px;
            }
            .end-page button:hover{
                background-color: rgba(0,0,0,0.5);
                color: wheat;
            }
            .end-page .onactive{
                background-color: blueviolet;
            }

            #test table td a .tooltip {
                transition: opacity 0.3s, visibility 0.3s;
            }

            #test table td a:hover .tooltip {
                opacity: 1;
            }
            @media screen and (max-width:950px){
                #test table td a .tooltip{
                    display: none;
                }
            }
        </style>
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">
                <!-- User Menu-->
                <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a>
                </li>
            </ul>
        </header>

        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <img class="app-sidebar__user-avatar" src="asset/img/info.png" width="50px"
                     alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>Administrator</b></p>
                    <p class="app-sidebar__user-designation">WELCOME BACK!</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item " href="index.html"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Dashboard</span></a></li>
                <li><a class="app-menu__item " href="table-data-table.html"><i class='app-menu__icon bx bx-id-card'></i> <span
                            class="app-menu__label">Employees Management</span></a></li>
                <li><a class="app-menu__item" href="ListProductServlet"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Product Management</span></a>
                </li>
                <li><a class="app-menu__item" href="ordermanagement"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Order Management</span></a></li>
            </ul>
        </aside>

        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item"><a href="ordermanagement">Order Management</a></li>
                    <li class="breadcrumb-item"><a href="">List Orders</a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row element-button">
                <div class="col-sm-2">
                    <a class="btn btn-add btn-sm" href="create"><i class="fas fa-plus"></i>
                        Tạo mới đơn hàng</a>
                </div>
                <div class="col-sm-2">
                    <a class="btn btn-excel btn-sm" onclick="exportToExcel()"><i class="fas fa-file-excel"></i> Xuất Excel</a>
                </div>
                <div class="col-sm-2">
                    <a class="btn btn-delete btn-sm" type="button" href="ordermanagement?orderID=0&action=Delete"><i
                            class="fas fa-trash-alt"></i> Xóa tất cả </a>
                </div>
            </div>
            <div>
                <c:if test="${message != null}">
                    <h4>${message}</h4>
                </c:if>
            </div>
            <div class="row ">
                <div class="col-sm-12 col-md-4">
                    <div class="dataTables_length" id="sampleTable_length">
                        <label style="display: flex; align-items: center;">
                            <div>Hiện&nbsp;&nbsp;</div>
                            <div>
                                <form method="POST" action="ordermanagement" id="submitForm">
                                    <select name="length" class="form-control form-control-sm" onchange="submitForm()">
                                        <option value="" disabled selected>${sessionScope.length}</option>
                                        <option value="5" >5</option>
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                </form>
                            </div>
                            <div>&nbsp;&nbsp;danh mục</div>
                        </label>
                    </div>
                </div>
                <!-- Search-->
                <div class="col-sm-12 col-md-4">
                    <div id="sampleTable_filter" class="dataTables_filter">
                        <label style="display: flex; align-items: center;">
                            <div class="search">
                                <form action="action"method="GET">
                                    <input type="text" name="Search" class="form-control-sm" placeholder="Tìm kiếm..."> 
                                    <button onclick="this.form.submit()" class="form-control-sm">
                                        <i class="ti-search "></i>
                                    </button>
                                </form>
                            </div>
                        </label>
                    </div>
                </div>
                <div class="col-sm-12 col-md-4">
                    <form action="action"method="POST">
                        <select name="statusFilter" class="form-control-sm">
                            <option disabled selected value="">Order Status</option>
                            <option value="Processing">Processing</option>
                            <option value="Shipped">Shipped</option>
                            <option value="Delivered">Delivered</option>
                            <option value="Return">Return</option>
                        </select>
                        <select name="paymemtFilter" class="form-control-sm">
                            <option disabled selected value="">Payment Method</option>
                            <option value="Credit Card">Credit Card</option>
                            <option value="PayPal">PayPal</option>
                            <option value="Cash on Delivery">Cash on Delivery</option>
                        </select>
                        <input type="submit" value="Lọc" class="form-control-sm"/>
                    </form>
                </div>
            </div>
            <div id="test">
                <table  border=""style="">
                    <tr>
                        <th>Order</th>
                        <th>Customer</th>
                        <th>Order Date</th>
                        <th>Created By</th>
                        <th>Payment Method</th>
                        <th>Order Status</th>
                        <th colspan="3">Action</th>
                    </tr>
                    <c:forEach var="l" items="${listOrders}">
                        <tr>
                            <td>${l.getOrderID()}</td> 
                            <td>${l.getCustomers().getFullName()}</td> 
                            <td>${l.getOrderDate()}</td> 
                            <td>${l.getCreatedByAdmin().getFullName()}</td>
                            <td>${l.paymentMethod}</td>
                            <td <c:if test="${l.getOrderStatus() == 'Processing'}">
                                    style="color: #007bff"
                                </c:if>
                                <c:if test="${l.getOrderStatus() == 'Shipped'}">
                                    style="color: #008c04"
                                </c:if>
                                <c:if test="${l.getOrderStatus() == 'Delivered'}">
                                    style="color:orange "
                                </c:if>
                                <c:if test="${l.getOrderStatus() == 'Return'}">
                                    style="color:red "
                                </c:if>
                                >${l.getOrderStatus()}</td> 
                            <td>
                                <a href="details?orderID=${l.getOrderID()}"> <i class="ti-eye"></i>
                                    <span class="tooltip">Xem</span>
                            </td>
                            <td>
                                <a href="create?orderID=${l.getOrderID()}&action=Edit"> <i class="ti-pencil-alt"></i>
                                    <span class="tooltip">Sửa</span>                             
                            </td>
                            <td>
                                <a href="ordermanagement?orderID=${l.getOrderID()}&action=Delete"> <i class="ti-trash"></i>
                                    <span class="tooltip">Xóa</span>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="end-page">
                <form action="ordermanagement" method="POST">
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <button type="submit" name="index" value="${i}" class="${tag == i ? 'onactive' : ''}">${i}</button>
                    </c:forEach>
                </form>
            </div>
        </main>

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>

        <script type="text/javascript">
                            $('#sampleTable').DataTable();
                            //Thời Gian
                            function time() {
                                var today = new Date();
                                var weekday = new Array(7);
                                weekday[0] = "Sunday";
                                weekday[1] = "Monday";
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
                                    dd = '0' + dd;
                                }
                                if (mm < 10) {
                                    mm = '0' + mm;
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
    </body>
</html>
