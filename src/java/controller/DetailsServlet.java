/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOOrderDetail;
import dal.DAOOrder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List;
import model.OrderDetail;
import model.Order;

/**
 *
 * @author acer
 */
public class DetailsServlet extends HttpServlet {

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
            out.println("<title>Servlet DetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailServlet at " + request.getContextPath() + "</h1>");
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
        DAOOrderDetail od = new DAOOrderDetail();
        DAOOrder ordersDAO = new DAOOrder();
        String orderID_raw = request.getParameter("orderID");
        int orderID = Integer.parseInt(orderID_raw);
        List<OrderDetail> foudOD = od.SearchByID(orderID);
        Order orders = ordersDAO.SearchByID(orderID);
        HttpSession session = request.getSession();
        session.setAttribute("orderID", orderID);
        request.setAttribute("foundOrder", orders);
        request.setAttribute("foundOD", foudOD);
        request.getRequestDispatcher("orderDetails.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        int orderID = (int) session.getAttribute("orderID");
        DAOOrder ordersDAO = new DAOOrder();

//        if ("confirm".equals(action)) {
//            if (ordersDAO.updateOrder(orderID, "TransactionStatus", "Success")) {
//                session.setAttribute("message", "Order has been confirmed");
//            }
//            String directURL = "details?orderID=" + orderID;
//            response.sendRedirect(directURL);
//        } else if ("delete".equals(action)) {
//            if (ordersDAO.deleteOrder(orderID)) {
//                request.setAttribute("message", "Order " + orderID + "has been deleted");
//                request.getRequestDispatcher("ordermanagement").forward(request, response);
//            }
//        }
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
