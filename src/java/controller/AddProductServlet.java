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
import java.security.Timestamp;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import model.Categories;
import model.Product;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProductServlet"})
public class AddProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO category_DAO = new CategoryDAO();
        List<Categories> listCategory = category_DAO.GetAllCategory();
        request.setAttribute("categories", listCategory);
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form data
            String productName = request.getParameter("name");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int categoryId = Integer.parseInt(request.getParameter("category"));
            float price = Float.parseFloat(request.getParameter("price"));
            String description = request.getParameter("description");
            int createdBy = Integer.parseInt(request.getParameter("creator"));

            // Assuming you have a Category object, replace Category.EMPTY_CATEGORY with your actual implementation
            Categories category = new Categories(); // You need to replace this with actual Category retrieval based on categoryId
            category.setCategoryID(categoryId);

            // Create a Product object
            Product product = new Product();
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setCategories(category);
            product.setPrice(price);
            product.setDescription(description);
            product.setCreatedBy(createdBy);

            // Set other product properties as needed

            // Set createdOn to the current timestamp
//            Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime());
//            product.setCreatedOn(new Date(currentTimestamp.getTime()));

            // Set modifiedOn to null
            product.setModifiedOn(null);

            // Call the InsertProduct method from your DAO class
            // Replace 'yourDAO' with the actual name of your DAO class
//            YourDAO yourDAO = new YourDAO(); // You need to replace this with the actual name
//            yourDAO.InsertProduct(product);

            // Redirect to the product list page after successful insertion
            response.sendRedirect("ListProductServlet");
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately (log or display an error message)
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
