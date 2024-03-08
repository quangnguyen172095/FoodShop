package controller;

import dal.CategoryDAO;
import dal.DAOProducts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Categories;
import model.Product;
import model.Products;

@WebServlet(name = "ProductDisplayServlet", urlPatterns = {"/ProductDisplayServlet"})
public class ProductDisplayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDisplayServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDisplayServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String limit_raw = request.getParameter("limit");

        try {
            int limit = Integer.parseInt(limit_raw);
            DAOProducts product_DAO = new DAOProducts();
            CategoryDAO category_DAO = new CategoryDAO();

            List<Product> product_list = product_DAO.getProducts(limit);
            List<Categories> category_list = category_DAO.GetAllCategory();

            request.setAttribute("products", product_list);
            request.setAttribute("categories", category_list);
            request.setAttribute("limit", limit);

            request.getRequestDispatcher("listProduct.jsp").forward(request, response);
        } catch (IOException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
