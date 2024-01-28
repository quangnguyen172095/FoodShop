/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dal.AccountDAO;
import dal.DAOCustomer;
import java.io.IOException;
import java.io.PrintWriter;
import model.Admin;
import model.Customer;

/**
 *
 * @author Admin
 */
//forgetPassword
@WebServlet(name = "forgetPasswordController", urlPatterns = {"/forgetPasswordController"})
public class forgetPasswordController extends HttpServlet {

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
            out.println("<title>Servlet forgetPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet forgetPasswordController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("forgot.jsp").forward(request, response);
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
        String user = request.getParameter("user");
        String pass = request.getParameter("newPassword");
        String repass = request.getParameter("confirmPassword");
        AccountDAO adb = new AccountDAO();
        DAOCustomer cdb = new DAOCustomer();
        Customer customer = cdb.checkCustomerExist(user);
        Admin account = adb.checkAccountExist(user);
        if (account == null && customer == null) {
            request.setAttribute("mess", "Account does not exist!");
            request.getRequestDispatcher("forgot.jsp").forward(request, response);
        }
        if (!pass.equals(repass)) {
            request.setAttribute("mess", "password does not match!");
            request.getRequestDispatcher("forgot.jsp").forward(request, response);
            return;
        } else {
            if (account != null) {
                // Nếu tài khoản tồn tại, cập nhật mật khẩu của tài khoản
                adb.UpDatePassWord(pass, user);
            } else if (customer != null) {
                // Nếu khách hàng tồn tại, cập nhật mật khẩu của khách hàng
                cdb.UpDatePassWordCustomer(pass, user);
            }
            request.setAttribute("mess", "Change Password successfully!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
