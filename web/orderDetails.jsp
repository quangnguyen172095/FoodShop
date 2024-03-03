<%-- 
    Document   : orderDetails
    Created on : 21-Jan-2024, 09:07:25
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
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
            function doDelete() {
                if (confirm("Are you sure to delete this order ?")) {
                    window.location = "details";
                }
            }
        </script>
        <style>
            body {
                background-color: #f8f9fa;
            }

            .container {
                margin-top: 50px;
            }

            .header {
                background-color: #ff8c00;
                color: #ffffff;
                padding: 20px;
                text-align: center;
                font-size: 24px;
                margin-bottom: 30px;
            }

            .info-section {
                background-color: #ffffff;
                border: 1px solid #ddd;
                padding: 20px;
                margin-bottom: 30px;
                border-radius: 8px;
            }

            .info-section h4 {
                color: #ff8c00;
            }

            .total {
                font-weight: bold;
            }

            .btn-action {
                margin-top: 20px;
            }

            .btn-delete {
                background-color: #dc3545;
                color: #fff;
                border: none;
            }

            .btn-delete:hover {
                background-color: #c82333;
            }
            .btn-back {
                position: absolute;
                left: 10px;
                top: 10px;
                background-color: #fff;
                color: #007bff;
                border: 1px solid #007bff;
                padding: 10px 20px;
                font-size: 16px;
                text-decoration: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out;
            }

            .btn-back:hover {
                background-color: #007bff;
                color: #fff;
            }
            .message {
                text-align: center;
                margin-top: 20px;
                padding: 10px;
                background-color: #d4edda;
                color: #155724;
                border: 1px solid #c3e6cb;
                border-radius: 5px;
            }
        </style> 

    </head>
    <body>
        <a href="ordermanagement" class="btn btn-back"><i class="ti-control-backward">Back</i></a>
        <div class="container">
            <c:if test="${sessionScope.message!= null}">
                <div class="message">
                    ${message}
                </div>
            </c:if>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.4/xlsx.full.min.js"></script>

            <script type="text/javascript">
            function exportToExcel() {
                // Tạo một đối tượng workbook mới
                var wb = XLSX.utils.book_new();

                // Thêm một sheet vào workbook
                var ws = XLSX.utils.json_to_sheet(convertToJson(${foundOD})); // Dữ liệu sheet là một mảng trống ban đầu
                XLSX.utils.book_append_sheet(wb, ws, "Chi Tiết Đơn Đặt Hàng");

                // Thực hiện tải xuống
                XLSX.writeFile(wb, "ChiTietDonDatHang.xlsx");
            }
            function convertToJson(data) {
                // Chuyển đối dữ liệu thành mảng JSON
                var jsonData = [];

                // Duyệt qua dữ liệu và thêm vào mảng JSON
                <c:forEach var="l" items="${data}">
                var row = {};
                row['Product Name'] = "${l.getProducts().getProductName()}";
                row['Price'] = "${l.getProducts().getPrice()}";
                row['Quantity'] = "${l.getQuantity()}";
                row['Discount'] = "${l.getProducts().getDiscount()}";
                row['Total'] = "${(l.getProducts().getPrice() - l.getProducts().getPrice()*l.getProducts().getDiscount())*l.getQuantity()}";
                jsonData.push(row);
                </c:forEach>

                return jsonData;
            }
            </script>
            <div class="btn-action">
                <button onclick="exportToExcel()" class="btn btn-success">Tải Xuống Excel</button>
            </div>
            <div class="header">
                Order Details
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="info-section order-info">
                        <h4>Order Information</h4>
                        <p><strong>Order ID:</strong> ${foundOrder.getOrderID()}</p>
                        <p><strong>Order Status:</strong>  ${foundOrder.getOrderStatus()}</p>
                        <p><strong>Order Date:</strong> ${foundOrder.getOrderDate()}</p>
                        <p><strong>Payment Method:</strong> ${foundOrder.getPaymentMethod()}</p>
                        <p><strong>Shipping Address:</strong> ${foundOrder.getShippingAddress()}</p>
                        <p><strong>Created By:</strong>  ${foundOrder.getCreatedBy().getFullName()} 
                            (${foundOrder.getCreatedBy().getRole()})</p>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="info-section customer-info">
                        <h4>Customer Information</h4>
                        <!--<p><img src="assets/img/logo.png" width="25%" alt="alt"/></p>-->
                        <p><strong>Customer Name:</strong> ${foundOrder.getCustomers().getFullName()}</p>
                        <p><strong>Phone:</strong> ${foundOrder.getCustomers().getPhone()}</p>
                        <p><strong>Email:</strong> ${foundOrder.getCustomers().getEmail()}</p>
                        <p><strong>Address:</strong> ${foundOrder.getCustomers().getAddress()}</p>
                    </div>
                </div>
            </div>

            <div class="info-section product-info">
                <h4>Product Information</h4>
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Discount</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="l" items="${foundOD}">
                                <tr>
                                    <td>${l.getProducts().getProductName()}</td>
                                    <td><fmt:formatNumber type="currency" currencySymbol="$" 
                                                      value="${l.getProducts().getPrice()}"/></td>
                                    <td>${l.getQuantity()}</td>
                                    <td>${l.getProducts().getDiscount()}</td>
                                    <td><fmt:formatNumber type="currency" currencySymbol="$"
                                                      value="${(l.getProducts().getPrice() - 
                                                               l.getProducts().getPrice()*l.getProducts().getDiscount())*l.getQuantity()}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="info-section payment-info">
                <h4>Payment Information</h4>
                <p><strong>Order Status:</strong> ${foundOrder.getOrderStatus()}</p>
                <c:if test="${foundOrder.getTransactionStatus()  == 'Pending'}">
                    <p><img width="15%"src="assetsManageOrder/img/unpaid.png" alt="${foundOrder.getTransactionStatus()}"/></p>
                    </c:if>
                    <c:if test="${foundOrder.getTransactionStatus()  == 'Success'}">
                    <p><img width="15%"src="assetsManageOrder/img/paid.png" alt="${foundOrder.getTransactionStatus()}"/></p>
                    </c:if>
                    <c:if test="${foundOrder.getTransactionStatus()  == 'Refund'}">
                    <p><img width="15%"src="assetsManageOrder/img/refund.png" alt="${foundOrder.getTransactionStatus()}"/></p>
                    </c:if>

            </div>

            <div class="total">
                <h5>Total: 
                    <fmt:formatNumber type="currency" currencySymbol="$" value="${foundOrder.getFreight()}"/></h5>
            </div>

            <div class="btn-action">
                <form action="details" method="POST">
                    <c:if test="${foundOrder.getTransactionStatus()  == 'Pending'}">
                        <button type="submit" name="action" value="confirm" class="btn btn-primary">Confirm Order</button>
                    </c:if>
                    <button onclick="doDelete()" type="submit" name="action" value="delete" 
                            class="btn btn-danger btn-delete">Delete Order</button>
                </form>
            </div>
        </div>

        <!-- Bootstrap JS and Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>

