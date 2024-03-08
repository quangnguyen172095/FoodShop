<%-- 
    Document   : orderDetail
    Created on : 17-Feb-2024, 09:39:18
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function printPage() {
                window.print();
            }
        </script>

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #666;
            }

            /* Main */
            .main {
                width: 85%;
                margin: 0 auto;
                border: 3px solid orange !important;
                padding: 16px;
                background-color: aliceblue;
                border-radius: 5px;
            }

            /* Header */
            .header {
                text-align: center;
                border-bottom: 1px solid #000;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            h2 {
                color: orangered;
            }

            .logo {
                text-align: center;
            }

            .order-info {
                text-align: right;
            }
            .order-info a {
                text-decoration: none;
            }
            .order-info a:hover{
                font-style: italic;
                color: brown;
            }
            /* Header */

            /* In4 */
            .in4 .lightText {
                color: orangered;
                font-size: 18px;
            }

            .seller {
                margin-top: 16px;
                padding-bottom: 16px;
                margin-bottom: 16px;
                border-bottom: 1px solid #000;
            }

            .seller th {
                width: 300px;
                text-align: left;
            }

            /* Detatil */
            .detail table {
                width: 100%;
                border-collapse: collapse;
            }

            .detail th,
            .detail td {
                border: 1px solid #000;
                padding: 8px;
                text-align: center;
            }
            .status{
                display: flex;
                justify-content: start;
            }
            .footer{
                text-align: center;
                display: flex;
                justify-content: space-evenly;
                align-items: center;
            }
            @media print {
                .back-button {
                    display: none;
                }
            }
        </style>
    </head>

    <body>
        <div><a  href="ordermanagement"><button class="back-button">Back</button></a></div>
        <div class="main">

            <!-- Header -->
            <div class="header">
                <div class="logo">
                    <a href="ordermanagement"><img src="asset/img/logo.png" width="70px" alt="Logo"></a>
                    <h2>ONLINE GROCERY STORE</h2>
                </div>
                <div>
                    <h2>HÓA ĐƠN CHI TIẾT </h2>
                    <h2>(ORDER DETAILS)</h2>
                    <p>Thời gian (Time): <b>${sessionScope.foundOrder.getOrderDate()}</b> </p>
                </div>
                <div class="order-info">
                    <p>Mã hóa đơn (No.): <span style="color: orangered;">${sessionScope.foundOrder.getOrderID()}</span></p>
                    <p><a href="#" onclick="printPage()">Print PDF</a> | <a href="email">Email</a></p>
                </div>
            </div>
            <!-- Header -->

            <!-- Info -->
            <div class="in4">
                <!-- Seller -->
                <div class="seller">
                    <table>
                        <tr>
                            <th>Tên đơn vị bán hàng (Seller)</th>
                            <td><span class="lightText">ONLINE GROCERY STORE</span></td>
                        </tr>
                        <tr>
                            <th>Mã số thuế (Tax code)</th>
                            <td>0102100740</td>
                        </tr>
                        <tr>
                            <th>Địa chỉ (Address)</th>
                            <td>Khu Giáo dục và Đào tạo - Khu công nghệ cao Hoà Lạc - Km29 Đại lộ Thăng Long,
                                Huyện Thạch Thất, Thành phố Hà Nội</td>
                        </tr>
                        <tr>
                            <th>Điện thoại (Tel.)</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Số tài khoản (A/C No.)</th>
                            <td>00006969002 tại Ngân hàng TMCP Tiên Phong - Chi nhánh Thăng Long</td>
                        </tr>
                    </table>
                </div>
                <!-- Seller -->
                <!-- Customer -->
                <div class="seller">
                    <table>
                        <tr>
                            <th>Tên khách hàng (Customer Name)</th>
                            <td><span class="lightText">${sessionScope.foundOrder.getCustomers().getFullName()}</span></td>
                        </tr>
                        <tr>
                            <th>Điện thoại (Tel.)</th>
                            <td>${sessionScope.foundOrder.getCustomers().getPhone()}</td>
                        </tr>
                        <tr>
                            <th>Email (Email)</th>
                            <td>${sessionScope.foundOrder.getCustomers().getEmail()}</td>
                        </tr>
                        <tr>
                            <th>Địa chỉ (Address)</th>
                            <td>${sessionScope.foundOrder.getCustomers().getAddress()}</td>
                        </tr>
                        <tr>
                            <th>Nơi giao hàng (Shipping Address)</th>
                            <td>${sessionScope.foundOrder.getShippingAddress()}</td>
                        </tr>
                    </table>
                </div>
                <!-- Seller -->
            </div>
            <!-- Info -->

            <!-- Detail -->
            <div class="detail">
                <table>
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Discount</th>
                            <th>Thành tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="l" items="${foundOD}">
                            <c:set var="count" value="${count+1}"></c:set>
                                <tr>
                                    <td>${count}</td>
                                <td>${l.getProducts().getProductName()}</td>
                                <td><fmt:formatNumber type="currency" currencySymbol="$" 
                                                  value="${l.getProducts().getPrice()}"/></td>
                                <td>${l.getQuantity()}</td>
                                <td>${l.getProducts().getDiscount()}</td>
                                <td><fmt:formatNumber type="currency" currencySymbol="$"
                                                  value="${(l.getProducts().getPrice() - 
                                                           l.getProducts().getPrice() * l.getProducts().getDiscount())* l.getQuantity()}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="5" style="text-align: right; font-weight: bold;">Tổng tiền:</td>
                            <td><fmt:formatNumber type="currency" currencySymbol="$" value="${foundOrder.getFreight()}"/></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <!-- Detail --> 
            <div class="status">
                <div>
                    <p><Strong>Hình thức thanh toán (Payment Method)</Strong></p>
                    <p><Strong>Trạng thái giao dịch (Transaction Status)</Strong></p>
                    <p><Strong>Trạng thái đơn hàng (Order Status)</Strong></p>
                </div>
                <div>
                    <p>: ${foundOrder.getPaymentMethod()}</p>
                    <p>: ${foundOrder.getTransactionStatus()}</p>
                    <p>: ${foundOrder.getOrderStatus()}</p>
                </div>
            </div>
            <!-- Footer -->
            <div class="footer">
                <div>
                    <h3>NGƯỜI MUA HÀNG (Buyer)</h3>
                    <p>Ký tên (Sign)</p>
                    <br><br><br>
                    <p><Strong>${sessionScope.foundOrder.getCustomers().getFullName()}</Strong></p>
                </div>
                <div class="">
                    <h3>NGƯỜI BÁN HÀNG (Sales Agent)</h3>
                    <p>Ký tên (Sign)</p>
                    <br><br><br>
                    <p><Strong>${foundOrder.getCreatedBy().getFullName()}</Strong></p>
                </div>
            </div>
            <!-- Footer -->

        </div>

    </body>

</html>
