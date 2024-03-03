/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import config.Config;
import jakarta.servlet.http.HttpSession;
import model.Customers;
import model.Order;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dal.DAOHome;
import dal.DAOOrder;
import dal.DAOOrderDetail;
import dal.DAOProducts;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;
import model.HeaderHome;
import model.OrderDetail;
import model.Product;

public class CheckoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAOHome dh = new DAOHome();
        ArrayList<HeaderHome> listHeader = dh.getHeader();
        request.setAttribute("listHeader", listHeader);
        Customers a = (Customers) session.getAttribute("CUS");
        Order order = (Order) session.getAttribute("order");
        float total = 0;
        if (order != null) {
            total = order.getTotalPrice();
        }
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            if (total == 0.0) {
                response.sendRedirect("menu");
            } else {
                String respCode = request.getParameter("vnp_ResponseCode");

                if (respCode != null && respCode.equals("00")) {
                    String address = request.getParameter("address");
                    String freight = request.getParameter("freight");
                    String paymentMethod = request.getParameter("paymentMethod");
                    try {
                        handleCheckout(session, a, order, address, order.getTotalPrice(), paymentMethod);
                        request.setAttribute("message", "Thanh toán thành công!");
                    } catch (Exception e) {
                        request.setAttribute("errorMessage", "Thanh toán thất bại!");
                    }
                } else if (respCode != null && !respCode.equals("00")) {
                    request.setAttribute("errorMessage", "Thanh toán thất bại!");
                }

                request.getRequestDispatcher("Checkout.jsp").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOHome dh = new DAOHome();
        ArrayList<HeaderHome> listHeader = dh.getHeader();
        request.setAttribute("listHeader", listHeader);
        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");
        HttpSession session = request.getSession();
        Customers c = (Customers) session.getAttribute("CUS");
        Order order = (Order) session.getAttribute("order");
        float total = 0;
        if (order != null) {
            total = order.getTotalPrice();
        }
        if (total == 0.0) {
            response.sendRedirect("menu");
        } else {

            if (paymentMethod.equals("1")) {
                //cod
                try {
                    handleCheckout(session, c, order, address, order.getTotalPrice(), paymentMethod);
                    request.setAttribute("message", "Thanh toán thành công!");
                    request.getRequestDispatcher("Checkout.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("errorMessage", "Thanh toán thất bại!");
                    request.getRequestDispatcher("Checkout.jsp").forward(request, response);
                }

            } else {
                //vnpay
                String vnp_Version = "2.1.0";
                String vnp_Command = "pay";
                String orderType = "other";
                long amount = (long) (order.getTotalPrice() * 100 *10000);
                String bankCode = "NCB";

                String vnp_TxnRef = Config.getRandomNumber(8);
                String vnp_IpAddr = Config.getIpAddress(request);

                String vnp_TmnCode = Config.vnp_TmnCode;

                Map<String, String> vnp_Params = new HashMap<>();
                vnp_Params.put("vnp_Version", vnp_Version);
                vnp_Params.put("vnp_Command", vnp_Command);
                vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
                vnp_Params.put("vnp_Amount", String.valueOf(amount));
                vnp_Params.put("vnp_CurrCode", "VND");

                vnp_Params.put("vnp_BankCode", bankCode);
                vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
                vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
                vnp_Params.put("vnp_OrderType", orderType);

                String locate = request.getParameter("language");
                if (locate != null && !locate.isEmpty()) {
                    vnp_Params.put("vnp_Locale", locate);
                } else {
                    vnp_Params.put("vnp_Locale", "vn");
                }
                String returnURL = Config.vnp_ReturnUrl + "?address=" + address + "&paymentMethod=" + paymentMethod + "&";
                vnp_Params.put("vnp_ReturnUrl", returnURL);
                vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

                Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String vnp_CreateDate = formatter.format(cld.getTime());
                vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

                cld.add(Calendar.MINUTE, 15);
                String vnp_ExpireDate = formatter.format(cld.getTime());
                vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

                List fieldNames = new ArrayList(vnp_Params.keySet());
                Collections.sort(fieldNames);
                StringBuilder hashData = new StringBuilder();
                StringBuilder query = new StringBuilder();
                Iterator itr = fieldNames.iterator();
                while (itr.hasNext()) {
                    String fieldName = (String) itr.next();
                    String fieldValue = (String) vnp_Params.get(fieldName);
                    if ((fieldValue != null) && (fieldValue.length() > 0)) {
                        //Build hash data
                        hashData.append(fieldName);
                        hashData.append('=');
                        hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                        //Build query
                        query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                        query.append('=');
                        query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                        if (itr.hasNext()) {
                            query.append('&');
                            hashData.append('&');
                        }
                    }
                }
                String queryUrl = query.toString();

                String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
                queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
                String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;

                response.sendRedirect(paymentUrl);
            }
        }
    }

    public void handleCheckout(HttpSession session, Customers c, Order order, String address, float freight, String paymentMethod) {
        DAOOrder daoOrder = new DAOOrder();
        DAOOrderDetail daoOrderDetail = new DAOOrderDetail();
        DAOProducts daoProduct = new DAOProducts();
        //get Date
        Date dateInsert = new Date();
        String transaction = "";
        String payment = "";
        if (paymentMethod.equals("1")) {
            transaction = "Pending";
            payment = "Cash on Delivery";
        } else {
            transaction = "Success";
            payment = "VNPay";
        }

        //insert order
        daoOrder.saveOrder(new Order(c.getCustomerId(), "Processing", dateInsert, payment, address, freight, transaction));

        //insert order detail
        int orderID = daoOrder.getOrderID();

        for (OrderDetail orderDetail : order.getOrderDetails()) {
            daoOrderDetail.saveOrderDetail(new OrderDetail(orderID, orderDetail.getProductID(), orderDetail.getQuantity()));
        }

        //update quantity of product
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            Product p = daoProduct.GetProductById(orderDetail.getProductID());
            int reduceAmount = p.getQuantity() - orderDetail.getQuantity();
            daoProduct.updateAmounProduct(reduceAmount, orderDetail.getProductID());
        }

        //remove cart
        order = new Order();
        session.setAttribute("order", order);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
