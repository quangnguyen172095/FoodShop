<%-- 
    Document   : createorder
    Created on : 17-Jan-2024, 12:17:30
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="cssheet/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <style>
            label {
                font-weight: bold;
            }

            /* Style for readonly inputs */
            .form-control[readonly] {
                background-color: #f8f9fa;
                cursor: not-allowed;
            }

            /* Style for buttons */
            .btn-save {
                background-color: #28a745;
                color: white;
            }

            .btn-cancel {
                background-color: #dc3545;
                color: white;
            }
        </style>
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
        </header>
        <!-- Sidebar menu-->
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
                            class="app-menu__label">Bảng điều khiển</span></a></li>
                <li><a class="app-menu__item " href="table-data-table.html"><i class='app-menu__icon bx bx-id-card'></i> <span
                            class="app-menu__label">Quản lý nhân viên</span></a></li>
                <li><a class="app-menu__item" href="table-data-product.html"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item" href="table-data-oder.html"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Quản lý đơn hàng</span></a></li>

            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item"><a href="ordermanagement">Order Management</a></li>
                    <li class="breadcrumb-item"><a href="">Create Order</a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Create New Order</h3>
                        <div class="tile-body">
                            <form id="orderForm" action="create" method="POST" >
                                <!-- Customer Information -->
                                <div class="form-group col-md-8">
                                    <label><h4>Customer Information</h4></label>
                                    <input hidden name="cid" value="${orders.getCustomers().getCustomerID()}">

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Name:</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="cname"  class="form-control"  
                                                   value="${orders.getCustomers().getFullName()}"<c:if test="${orders != null}">readonly</c:if>>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Phone Number:</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="cphone" class="form-control" 
                                                       value="${orders.getCustomers().getPhone()}" <c:if test="${orders != null}">readonly</c:if>>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Email:</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="cmail" class="form-control" 
                                                       value="${orders.getCustomers().getEmail()}" <c:if test="${orders != null}">readonly</c:if>>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Address:</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="caddress" class="form-control" 
                                                       value="${orders.getCustomers().getAddress()}" <c:if test="${orders != null}">readonly</c:if>>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Shipping Address:</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="csaddress" class="form-control" value="${orders.getShippingAddress()}">
                                        </div>
                                    </div>
                                </div>

                                <!-- Staff Information : Based on login-->
                                <div class="form-group col-md-8">
                                    <label><h4>Staff Information</h4></label>
                                    <input hidden name="adminID" value=
                                           <c:if test="${orders != null}">
                                               "${orders.getCreatedBy().getAdminID()}"
                                           </c:if><c:if test="${orders == null}">
                                              "${sessionScope.account.getAdminID()}"
                                           </c:if>
                                           >
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Name:</label>
                                        <div class="col-sm-9">
                                            <input readonly class="form-control" value=
                                                   <c:if test="${orders != null}">
                                                      " ${orders.getCreatedBy().getFullName()}"
                                                   </c:if>
                                                   <c:if test="${orders == null}">
                                                       "${sessionScope.account.getFullName()}"
                                                   </c:if>
                                                   >
                                        </div>
                                    </div>
                                </div>

                                <!-- Product Information -->
                               
                                <c:choose>
                                    <c:when test="${orders != null}">
                                        <!<!-- Update -->
                                        
                                        <input type="text" hidden name="orderIDUpdate" value="${orderIDUpdate}">
                                        <div class="form-group col-md-8">
                                             <label><h4>List Products</h4></label><br>
                                            <div id="productFields">
                                                <div class="form-group row product-row">
                                                    <c:forEach var="d" items="${details}">
                                                        <div class="col-sm-8">
                                                            <input type="text" readonly class="form-control" value="${d.getProducts().getProductName()}">
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="number" readonly class="form-control" value="${d.getQuantity()}">
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <!<!-- Create -->
                                        <div class="form-group col-md-8">
                                           <label><h4>List Products</h4></label><br>
                                            <div id="productFields">
                                                <div class="form-group row product-row">
                                                    <label class="col-sm-3 col-form-label">Product Name</label>
                                                    <div class="col-sm-6">
                                                        <select name="product[]" class="form-control">
                                                            <c:forEach var="list" items="${listP}">
                                                                <option value="${list.getProductID()}">${list.getProductName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <input type="number" name="quantity[]" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <button type="button" class="btn btn-primary" onclick="addProductField()">Add</button>
                                        </div>
                                    </c:otherwise>
                                </c:choose>

                                <script>
                                    function addProductField() {
                                        var productFields = document.getElementById('productFields');
                                        var productRow = document.createElement('div');
                                        productRow.classList.add('form-group', 'row', 'product-row');
                                        productRow.innerHTML = `
                                            <label class="col-sm-3 col-form-label">Product Name</label>
                                            <div class="col-sm-6">
                                                <select name="product[]" class="form-control">
                                    <c:forEach var="list" items="${listP}">
                                                        <option value="${list.getProductID()}">${list.getProductName()}</option>
                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="number" name="quantity[]" class="form-control" value="">
                                            </div>
                                        `;
                                        productFields.appendChild(productRow);
                                    }
                                </script>

                                <!--Transaction Status-->
                                <div class="form-group col-md-8">
                                    <label><h4>Transaction Status</h4></label>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Order Date</label>
                                        <div class="col-sm-9">
                                            <input type="datetime-local" name="orderDate"  class="form-control" value="${orders.getOrderDate()}"
                                                   <c:if test="${orders != null}">readonly</c:if>>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Order Status</label>
                                            <div class="col-sm-9">
                                                <select name="orderstatus" class="form-control">
                                                    <option value="${orders.getOrderStatus()}">${orders.getOrderStatus()}</option>
                                                <option value="Processing">Processing</option>
                                                <option value="Shipped">Shipped</option>
                                                <option value="Delivered">Delivered</option>
                                                <option value="Return">Return</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Freight</label>
                                        <div class="col-sm-9">
                                            <input type="text" readonly class="form-control" 
                                                   value="<fmt:formatNumber type="currency" currencySymbol="$" value="${orders.getFreight()}"/>">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Payment Method</label>
                                        <div class="col-sm-9">
                                            <select name="payment" class="form-control">
                                                <option value="${orders.getPaymentMethod()}">${orders.getPaymentMethod()}</option>
                                                <option value="PayPal">PayPal</option>
                                                <option value="Credit Card">Credit Card</option>
                                                <option value="Cash on Delivery">Cash on Delivery</option>
                                            </select>
                                        </div>                                  
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Transaction Status</label>
                                        <div class="col-sm-9">
                                            <select name="transactionstatus" class="form-control">
                                                <option value="${orders.getTransactionStatus()}">${orders.getTransactionStatus()}</option>
                                                <option value="Sucess">Success</option>
                                                <option value="Pending">Pending</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <!--Button-->
                                <div>
                                    <c:choose>
                                        <c:when test="${orders != null}">
                                            <input type="submit" name="action" value="Update" class="btn btn-save">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="submit" name="action" value="Create" class="btn btn-save">
                                        </c:otherwise>
                                    </c:choose>
                                    <a class="btn btn-cancel" href="ordermanagement">Cancel</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    </main>
                    <!-- Essential javascripts for application to work-->
                    <script src="js/jquery-3.2.1.min.js"></script>
                    <script src="js/popper.min.js"></script>
                    <script src="js/bootstrap.min.jxs"></script>
                    <script src="js/main.js"></script>
                    <!-- The javascript plugin to display page loading on top-->
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
