/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOHome;
import dal.DAOOrder;
import dal.OrderDetailsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Customers;
import model.HeaderHome;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author PC
 */
@WebServlet(name = "HistoryOrderDetail", urlPatterns = {"/historyorderdetail"})
public class HistoryOrderDetailController extends HttpServlet {

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
            out.println("<title>Servlet HistoryOrderDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HistoryOrderDetail at " + request.getContextPath() + "</h1>");
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
        model.Customers customer = (Customers) session.getAttribute("CUS");
        if (customer == null) {
            // Chuyển hướng người dùng đến trang đăng nhập
            response.sendRedirect("login.jsp"); // Đây là đường dẫn đến trang đăng nhập của bạn
        } else {
            DAOHome dh = new DAOHome();
            OrderDetailsDAO od = new OrderDetailsDAO();
            ArrayList<HeaderHome> listHeader = dh.getHeader();
            request.setAttribute("listHeader", listHeader);
            request.setAttribute("customer", customer);

            String orderid_raw = request.getParameter("orderid");
            int orderid = Integer.parseInt(orderid_raw);
            DAOOrder dao = new DAOOrder();
            model.Order order = dao.getOrderById(orderid);
            
            List<OrderDetail> foudOD = od.SearchByID(orderid);
            session.setAttribute("order", order);
            session.setAttribute("foundOD", foudOD);
            request.getRequestDispatcher("HistoryOrderDetail.jsp").forward(request, response);
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
        processRequest(request, response);
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
