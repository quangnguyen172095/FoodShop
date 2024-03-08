package controller;

import dal.CategoryDAO;
import dal.DAOProducts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;
import model.Categories;
import model.Product;
import model.Products;

@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class UpdateProductServlet extends HttpServlet {

    public static final String UPLOAD_DIR = "menu";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id_raw = request.getParameter("productId");
        int productId;
        DAOProducts productDAO = new DAOProducts();
        CategoryDAO category_DAO = new CategoryDAO();
        List<Categories> listCategory = category_DAO.GetAllCategory();
        request.setAttribute("categories", listCategory);

        try {
            productId = Integer.parseInt(id_raw);
            Product product = productDAO.GetProductById(productId);
            request.setAttribute("product", product);
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
        } catch (NumberFormatException e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String quantity_raw = request.getParameter("quantity");
        String status = request.getParameter("status");
        String category_raw = request.getParameter("category");

        String price_raw = request.getParameter("price");
        price_raw = price_raw.replaceAll(",", "");
        String discount_raw = request.getParameter("discount");
        String desc = request.getParameter("description");
        String modifier_raw = request.getParameter("modifier");

        Part filePart = request.getPart("NewImage");
        String fileName = extractFileName(filePart);
        String uploadPath = "C:\\Users\\PC\\Desktop\\swpfoodshop\\web\\assets\\images" + File.separator + UPLOAD_DIR;
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdir();
        }
        String savePath = uploadPath + File.separator + fileName;
        filePart.write(savePath + File.separator);

        int quantity, productID, modifier, categoryID;
        float price, discount;
        Timestamp modifiedOn = new Timestamp(System.currentTimeMillis());

        DAOProducts productDAO = new DAOProducts();
        Date modifiedDate = new Date(modifiedOn.getTime());
        quantity = Integer.parseInt(quantity_raw);
        price = Float.parseFloat(price_raw);
        discount = Float.parseFloat(discount_raw);
        productID = Integer.parseInt(id_raw);
        modifier = Integer.parseInt(modifier_raw);
        categoryID = Integer.parseInt(category_raw);
        Product oldProduct = productDAO.GetProductById(productID);

        Product updatedProduct = new Product();
        updatedProduct.setCategoryID(categoryID);
        updatedProduct.setProductName(productName);
        updatedProduct.setImage(fileName);
        updatedProduct.setDescription(desc);
        updatedProduct.setPrice(price);
        updatedProduct.setQuantity(quantity);
        updatedProduct.setStatus(status);
        updatedProduct.setDiscount(discount);
        updatedProduct.setCreatedBy(oldProduct.getCreatedBy());
        updatedProduct.setCreatedOn(oldProduct.getCreatedOn());
        updatedProduct.setModifiedBy(modifier);
        updatedProduct.setModifiedOn(modifiedDate);
        updatedProduct.setProductID(productID);

//            try ( PrintWriter out = response.getWriter()) {
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet UpdateProductServlet</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>Servlet UpdateProductServlet at " + categoryID + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + productName + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + fileName + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + desc + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + price + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + quantity + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + status + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + discount + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + oldProduct.getCreatedBy() + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + oldProduct.getCreatedOn() + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + modifier + "</h1>");
//                out.println("<h1>Servlet UpdateProductServlet at " + modifiedDate + "</h1>");
//                out.println("</body>");
//                out.println("</html>");
//            }
        productDAO.UpdateProduct(updatedProduct);
        response.sendRedirect("ListProductServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
