package controller;

import dal.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import model.Admin;

@WebServlet(name = "UpdateAdminServlet", urlPatterns = {"/UpdateAdminServlet"})
public class UpdateAdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateAdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("adminId");
        int adminId;
        AdminDAO adminDAO = new AdminDAO();
        try {
            adminId = Integer.parseInt(id_raw);
            Admin admin = adminDAO.GetAdminById(adminId);
            request.setAttribute("admin", admin);
            request.getRequestDispatcher("updateAdmin.jsp").forward(request, response);
        } catch (ServletException | IOException | NumberFormatException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("adminId");
        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String joinedDate_raw = request.getParameter("joinedDate");
        String address = request.getParameter("address");
        String department = request.getParameter("department");
        String role = request.getParameter("role");
        int adminId;
        Date joinedDate;
        try {
            AdminDAO adminDAO = new AdminDAO();
            adminId = Integer.parseInt(id_raw);
            joinedDate = Date.valueOf(joinedDate_raw);
            Admin oldAdmin = adminDAO.GetAdminById(adminId);
            Admin newAdmin = new Admin(adminId, fullName, username, password, email, phone, role, oldAdmin.getImage(), joinedDate, address, department);
            adminDAO.UpdateAdmin(newAdmin);

            // Redirect after the update operation
            response.sendRedirect("ListAdminServlet");
        } catch (IOException | NumberFormatException e) {
            // Handle exceptions
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
