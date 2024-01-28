package controller;

import dal.DAOCustomer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/UpdateCustomerServlet"})
public class UpdateCustomerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCustomer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("customerId");
        int customerId;
        DAOCustomer customerDAO = new DAOCustomer();
        try {
            customerId = Integer.parseInt(id_raw);
            Customer customer = customerDAO.GetCustomerById(customerId);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
        } catch (ServletException | IOException | NumberFormatException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("customerId");
        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        try {
            DAOCustomer customerDAO = new DAOCustomer();
            int customerId = Integer.parseInt(id_raw);

            Customer oldCustomer = customerDAO.GetCustomerById(customerId);
            Customer newCustomer = new Customer(customerId, fullName, phone, email, oldCustomer.getImage(), username, password, address);
            customerDAO.UpdateCustomer(newCustomer);
        } catch (NumberFormatException e) {
        }
        response.sendRedirect("ListCustomerServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
