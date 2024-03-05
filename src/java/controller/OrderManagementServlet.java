/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AdminsDAO;
import dal.OrdersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Admin;
import model.Orders;

/**
 *
 * @author acer
 */
public class OrderManagementServlet extends HttpServlet {

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
            out.println("<title>Servlet OrderManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderManagementServlet at " + request.getContextPath() + "</h1>");
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
        OrdersDAO ordersDAO = new OrdersDAO();
        AdminsDAO adminDAO = new AdminsDAO();
        HttpSession session = request.getSession();
        Admin admin = adminDAO.SearchByID(2);
        session.setAttribute("account", admin);
        String action = request.getParameter("action");
        if (action != null) {
            String orderID_raw = request.getParameter("orderID");
            int orderID = Integer.parseInt(orderID_raw);
            ordersDAO.deleteOrder(orderID);
        }
        int count = ordersDAO.getNRecords();
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }
        List<Orders> listAllOrders = ordersDAO.getAllOrders();
        List<Orders> listOrders = ordersDAO.getAllOrders(1, 5);
        session.setAttribute("length", 5);
        session.setAttribute("tag", 1);
        session.setAttribute("endPage", endPage);
        request.setAttribute("listAllOrders", listAllOrders);
        request.setAttribute("listOrders", listOrders);
        request.getRequestDispatcher("orderManagement.jsp").forward(request, response);
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
        OrdersDAO ordersDAO = new OrdersDAO();

        HttpSession session = request.getSession();
        int length = (int) session.getAttribute("length");
        int index = (int) session.getAttribute("tag");
        String length_raw = request.getParameter("length");
        String index_raw = request.getParameter("index");
        if (length_raw == null) { // Chon page
            index = Integer.parseInt(index_raw);
        } else if (index_raw == null) { //Chon danh muc
            length = Integer.parseInt(length_raw);
        }
        int count = ordersDAO.getNRecords();
        int endPage = count / length;
        if (count % length != 0) {
            endPage++;
        }
        List<Orders> listOrders = ordersDAO.getAllOrders(index, length);
        session.setAttribute("length", length);
        session.setAttribute("tag", index);
        session.setAttribute("endPage", endPage);
        request.setAttribute("listOrders", listOrders);
        request.getRequestDispatcher("orderManagement.jsp").forward(request, response);
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
