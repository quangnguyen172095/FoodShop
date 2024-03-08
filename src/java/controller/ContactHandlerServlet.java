package controller;

import dal.ContactDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import model.Contact;

@WebServlet(name = "ContactHandlerServlet", urlPatterns = {"/contact"})
public class ContactHandlerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactHandlerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactHandlerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        Contact contact = new Contact(0, name, email, phone, message, LocalDateTime.MAX, "Chưa được liên hệ");
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.InsertContact(contact);
        request.setAttribute("message", "Đã gửi liên hệ thành công. Chúng tôi sẽ sớm phản hồi cho bạn!");
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
