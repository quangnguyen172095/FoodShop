package controller;

import dal.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.sql.Timestamp;
import java.sql.Date;
import model.Admin;

@WebServlet(name = "AddAdminServlet", urlPatterns = {"/AddAdminServlet"})
public class AddAdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
        String image = request.getParameter("image");
//        Part imagePart = request.getPart("image");
//        String imageName = extractFileName(imagePart);
        Timestamp joinedDate = new Timestamp(System.currentTimeMillis());
        String address = request.getParameter("address");
        String department = request.getParameter("department");

        Date dateJoined = new Date(joinedDate.getTime());

        Admin admin = new Admin();
        admin.setFullName(fullName);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setEmail(email);
        admin.setPhone(phone);
        admin.setRole(role);
        admin.setImage(null);
        admin.setJoinedDate(dateJoined);
        admin.setAddress(address);
        admin.setDepartment(department);

        AdminDAO adminDAO = new AdminDAO();
        adminDAO.InsertAdmin(admin);

        response.sendRedirect("ListAdminServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

//    private String extractFileName(Part part) {
//        if (part != null) {
//            String contentDisposition = part.getHeader("content-disposition");
//            String[] items = contentDisposition.split(";");
//            for (String item : items) {
//                if (item.trim().startsWith("filename")) {
//                    return item.substring(item.indexOf("=") + 2, item.length() - 1);
//                }
//            }
//        }
//        return "";
//    }
}
