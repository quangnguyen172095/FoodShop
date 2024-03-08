/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AdminDAO;
import dal.CustomersDAO;
import dal.OrderDetailsDAO;
import dal.OrdersDAO;
import dal.ProductsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Admin;
import model.Customers;
import model.Order;
import model.OrderDetail;
import model.OrderDetails;
import model.Orders;
import model.Product;
import model.Products;

/**
 *
 * @author acer
 */
public class CreateOrderServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateOrderServlet at " + request.getContextPath() + "</h1>");
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
        ProductsDAO productsDAO = new ProductsDAO();
        OrdersDAO ordersDAO = new OrdersDAO();
        OrderDetailsDAO detailsDAO = new OrderDetailsDAO();
        String action = request.getParameter("action");
        if (action != null) {
            String id_raw = request.getParameter("orderID");
            int orderID = Integer.parseInt(id_raw);
            Order orders = ordersDAO.SearchByID(orderID);
            List<OrderDetail> details = detailsDAO.SearchByID(orderID);
            request.setAttribute("orderIDUpdate", orderID);
            request.setAttribute("orders", orders);
            request.setAttribute("details", details);
        }
        List<Product> listProducts = productsDAO.getAllProducts();
        request.setAttribute("listP", listProducts);
        request.getRequestDispatcher("createOrder.jsp").forward(request, response);
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

        CustomersDAO cdao = new CustomersDAO();
        OrdersDAO ordersDAO = new OrdersDAO();
        ProductsDAO productsDAO = new ProductsDAO();
        OrderDetailsDAO detailsDAO = new OrderDetailsDAO();
        AdminDAO adao = new AdminDAO();
        HttpSession session = request.getSession();

        List<OrderDetail> detailsList = new ArrayList<>();

        String cname = request.getParameter("cname");
        String cphone = request.getParameter("cphone");
        String cmail = request.getParameter("cmail");
        String caddress = request.getParameter("caddress");
        String csaddress = request.getParameter("csaddress");
        String orderDateStr = request.getParameter("orderDate");
        String orderstatus = request.getParameter("orderstatus");
        String payment = request.getParameter("payment");
        String transactionstatus = request.getParameter("transactionstatus");
        Date createdOn = new Timestamp(System.currentTimeMillis());
        String action = request.getParameter("action");

        if (action.equals("Create")) {
//            Add customer
            Customers customers = cdao.SearchByName(cname);
            if (customers != null && customers.getPhone().equals(cphone)
                    && customers.getEmail().equals(cmail) && customers.getAddress().equals(caddress)) {
            } else {
                customers = cdao.SearchByID(cdao.insertCustomers(new Customers(0, cname, cphone, cmail, null, null, null, caddress)));
            }

            float freight = 0;
            
//        Admin lay tu login
            Admin admin = (Admin)session.getAttribute("account");
            //Lay san pham

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"); // Define the format of datetime-local input
            LocalDateTime dateTime = LocalDateTime.parse(orderDateStr, formatter); // Parse the string into LocalDateTime
            Date orderDate = Timestamp.valueOf(dateTime.atZone(ZoneId.systemDefault()).toLocalDateTime()); // Convert LocalDateTime to Timestamp

            String[] products = request.getParameterValues("product[]");
            String[] quantities = request.getParameterValues("quantity[]");
            for (int i = 0; i < products.length; i++) {
                detailsList.add(new OrderDetail(null, productsDAO.SearchByID(Integer.parseInt(products[i])),
                        Integer.parseInt(quantities[i])));
            }

            for (OrderDetail od : detailsList) {
                freight += (od.getProducts().getPrice() - od.getProducts().getPrice() * od.getProducts().getDiscount()) * od.getQuantity();
            }

            Order orders = ordersDAO.SearchByID(ordersDAO.insertOrders(new Order(0, customers, orderstatus, orderDate,
                    payment, csaddress, freight, admin.getAdminId(), createdOn, transactionstatus)));
            for (OrderDetail od : detailsList) {
                od.setOrders(orders);
                detailsDAO.insertDetails(od);
            }
        } else if (action.equals("Update")) {
            String orderID_raw = request.getParameter("orderIDUpdate");
            int orderID = Integer.parseInt(orderID_raw);
            if (ordersDAO.updateOrder(orderstatus, payment, csaddress, (java.sql.Date) createdOn, transactionstatus, orderID)) {
            }
        }
        response.sendRedirect("ordermanagement");
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
