/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.DAOCustomer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import model.Admin;
import model.Customers;
import model.JavaMailSender;

/**
 *
 * @author PC
 */
@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

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
            out.println("<title>Servlet SignupController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Signup.jsp").forward(request, response);
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
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String address = request.getParameter("address");
        if (!password.equals(confirm_password)) {
            request.setAttribute("err", "Mật khẩu không giống nhau");
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
        } else {
            AccountDAO dao = new AccountDAO();
            DAOCustomer daocus = new DAOCustomer();
            Customers c = daocus.checkCustomerExist(username);
            boolean checkEmail = daocus.checkMailExist(email);
            boolean checkPhone = daocus.checkPhoneExist(phone);
            
            Admin a = dao.checkAccountExist(username);
            boolean checkEmailAdmin = dao.checkMailExist(email);
            boolean checkPhoneAdmin = dao.checkPhoneExist(phone);
            if (c == null && checkEmail == false && checkPhone == false 
                    && a==null && checkEmailAdmin == false && checkPhoneAdmin == false) {
                JavaMailSender sm = new JavaMailSender();
                String code = sm.getRandom();
                boolean test = sm.sendEmailSignup(email, username, code);
                Customers c2 = new Customers(fullname, phone, email, username, password, address);
                if (test) {
                    HttpSession session = request.getSession();
                    session.setAttribute("code", code);
                    session.setAttribute("c2", c2);
                }
                response.sendRedirect("signupverify");
            }else{
                if (c != null) {
                    request.setAttribute("err", "Tên đăng nhập đã tồn tại");
                }else if(a!=null){
                    request.setAttribute("err", "Tên đăng nhập đã tồn tại");
                }
                else {
                    request.setAttribute("err", "Email hoặc Số điện thoại đã được sử dụng");
                }
                request.getRequestDispatcher("Signup.jsp").forward(request, response);
            }
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
