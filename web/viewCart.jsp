<%-- 
    Document   : viewCart
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
        <meta http-equiv="refresh" content="30">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="cssManageOrder/main.css">
        <!-- Font-icon css-->
        <link href="assetsManageOrder/fonts/themify-icons-font/themify-icons/themify-icons.css" rel="stylesheet" type="text/css"/>
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
            .end-page a{
                display: inline-block;
                padding: 8px 12px;
                text-decoration: none;
                color: black;
                border: 1px solid black;
                border-radius: 4px;
                margin: 10px 10px;
            }
            .end-page a:hover{
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
                <img class="app-sidebar__user-avatar" src="assetsManageOrder/img/info.png" width="50px"
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
                <li><a class="app-menu__item" href="home"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Order Management</span></a></li>
            </ul>
        </aside>

        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item"><a href="ordermanagement">Order Management</a></li>
                    <li class="breadcrumb-item"><a href="">List Orders</a></li>
                </ul>
                <c:if test="${message != null}">
                    <div>
                        ${message}
                        <a href="cart"><i class="ti-eye"></i>
                            <span class="tooltip">View</span>
                        </a>
                    </div>
                </c:if>
                <div id="clock"></div>
            </div>
            <div id="test">
                <table  border=""style="">
                    <tr>
                        <th>Customer Name</th>
                        <th>Confirmed Date</th>
                        <th></th>
                    </tr>
                    <c:forEach var="l" items="${listCarts}">
                            <tr>
                                <td>${l.getCustomers().getFullName()}</td> 
                                <td>${l.getConfirmedOn()}</td> 
                                <td>
                                    <a href="create?customerID=${l.getCustomers().getCustomerID()}&confirmedOn=${l.getConfirmedOn()}">
                                        <i class="ti-more"></i>
                                        <span class="tooltip">Create Order</span>
                                    </a>
                                </td>
                            </tr>
                    </c:forEach>
                </table>
            </div>
        </main>

        <script src="jsManageOrder/jquery-3.2.1.min.js"></script>
        <script src="jsManageOrder/popper.min.js"></script>
        <script src="jsManageOrder/bootstrap.min.js"></script>
        <script src="jsManageOrder/main.js"></script>
        <script src="jsManageOrder/plugins/pace.min.js"></script>

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
