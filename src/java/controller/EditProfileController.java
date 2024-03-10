/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CustomersDAO;
import dal.DAOHome;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Customers;
import model.HeaderHome;

/**
 *
 * @author PC
 */
@WebServlet(name = "EditProfileController", urlPatterns = {"/editprofile"})
public class EditProfileController extends HttpServlet {

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
            out.println("<title>Servlet EditProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfileController at " + request.getContextPath() + "</h1>");
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
            ArrayList<HeaderHome> listHeader = dh.getHeader();
            request.setAttribute("listHeader", listHeader);

            request.setAttribute("customer", customer);
            request.getRequestDispatcher("DetailProfile.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        model.Customers customer = (Customers) session.getAttribute("CUS");
        if (customer == null) {
            // Chuyển hướng người dùng đến trang đăng nhập
            response.sendRedirect("login.jsp"); // Đây là đường dẫn đến trang đăng nhập của bạn
        } else {
            String mess = "";
            CustomersDAO dao = new CustomersDAO();
            DAOHome dh = new DAOHome();
            ArrayList<HeaderHome> listHeader = dh.getHeader();
            request.setAttribute("listHeader", listHeader);

            String fullname = request.getParameter("name");
            String username = request.getParameter("username");
            String address = request.getParameter("address");
            Customers checkUsername = dao.checkCustomerExist(username);
            if (!username.equalsIgnoreCase(customer.getUsername())) {
                if (checkUsername != null) {
                    mess = "Tên đăng nhập đã tồn tại";
                    request.setAttribute("mess", mess);
                    request.setAttribute("customer", customer);
                } else {
                    customer.setFullName(fullname);
                    customer.setUsername(username);
                    customer.setAddress(address);
                    dao.updateCustomer(customer);
                    request.setAttribute("customer", customer);
                }
            } else {
                //neu username khong thay doi
                customer.setFullName(fullname);
                customer.setAddress(address);
                dao.updateCustomer(customer);
                request.setAttribute("customer", customer);
            }

            request.getRequestDispatcher("DetailProfile.jsp").forward(request, response);
        }
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
