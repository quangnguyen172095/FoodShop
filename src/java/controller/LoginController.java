/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dal.AccountDAO;
import dal.DAOCustomer;
import model.Admin;
import model.Role;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import model.Customers;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String url = LOGIN_PAGE;
        try {
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            String remember = request.getParameter("remember");
            Cookie u = new Cookie("userc", username);
            Cookie p = new Cookie("passc", password);
            Cookie r = new Cookie("remc", remember);
            if (remember != null) {
                u.setMaxAge(60 * 60 * 24 * 7);
                p.setMaxAge(60 * 60 * 24 * 7);
                r.setMaxAge(60 * 60 * 24 * 7);
            } else {
                u.setMaxAge(0);
                p.setMaxAge(0);
                r.setMaxAge(0);
            }
            response.addCookie(u);
            response.addCookie(p);
            response.addCookie(r);

            AccountDAO accDao = new AccountDAO();
            Admin accDto = accDao.login(username, password);
            DAOCustomer cusDao = new DAOCustomer();
            Customers cusDto = cusDao.login(username, password);
            HttpSession session = request.getSession();
            String msg = "";
            if (accDto == null && cusDto == null) {
                msg = "Your Username or Password is Invalid!";
            } else {
                if (accDto != null) {
                    session.setAttribute("ACC", accDto);
                    if (accDto.getRole().equals(Role.MANAGER)) {
                        url = "HomeAdmin"; // Home for admin
                    } else {
                        url = "HomeAdmin"; // Home for non-admin accounts
                    }
                } else if (cusDto != null) {
                    session.setAttribute("CUS", cusDto);
                    url = "home"; // Home for customer accounts
                }
            }

            request.setAttribute("LOGIN_MSG", msg);

        } catch (SQLException e) {
            log("Error SQL EXCEPTION AT LOGINSERVLET:" + e.toString());
        } catch (Exception e) {
            log("Error AT LOGINSERVLET:" + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
