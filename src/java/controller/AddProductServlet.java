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

@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProductServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class AddProductServlet extends HttpServlet {

    public static final String UPLOAD_DIR = "menu";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String quantity_raw = request.getParameter("quantity");
        String category = request.getParameter("category");
        String price_raw = request.getParameter("price");
        price_raw = price_raw.replaceAll(",", "");
        String creator_raw = request.getParameter("creator");
        String desc = request.getParameter("description");
        String discount_raw = request.getParameter("discount");

        Part filePart = request.getPart("ImageUpload");
        String fileName = extractFileName(filePart);
        String image = fileName;

        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = "C:\\Users\\PC\\Desktop\\swpfoodshop\\web\\assets\\images" + File.separator + UPLOAD_DIR;

        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdir();
        }
        String savePath = uploadPath + File.separator + fileName;
        filePart.write(savePath + File.separator);

//        try ( PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddProductServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddProductServlet at " + extractFileName(request.getPart("ImageUpload")) + "</h1>");
//            out.println("<h1>Servlet AddProductServlet at " + request.getParameter("name") + "</h1>");
//            out.println("<h1>Servlet AddProductServlet at " + request.getParameter("quantity") + "</h1>");
//            out.println("<h1>Servlet AddProductServlet at " + request.getParameter("category") + "</h1>");
//            out.println("<h1>Servlet AddProductServlet at " + request.getParameter("price") + "</h1>");
//            out.println("<h1>Servlet AddProductServlet at " + request.getParameter("creator") + "</h1>");
//            out.println("<h1>Servlet AddProductServlet at " + request.getParameter("description") + "</h1>");
//            
//            out.println("</body>");
//            out.println("</html>");
//        }
        int quantity, createdBy;
        float price, discount;
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        Date createdOn = new Date(createdDate.getTime());
        quantity = Integer.parseInt(quantity_raw);
        price = Float.parseFloat(price_raw);
        createdBy = Integer.parseInt(creator_raw);
        discount = Float.parseFloat(discount_raw);

        DAOProducts pDAO = new DAOProducts();
        model.Product p = new Product();
        p.setProductName(name);
        p.setQuantity(quantity);
        p.setCategoryID(Integer.parseInt(category));
        p.setPrice(price);
        p.setCreatedBy(createdBy);
        p.setDescription(desc);
        p.setImage(fileName);
        p.setCreatedOn(createdOn);
        p.setStatus("Còn hàng");
        p.setDiscount(discount);

        pDAO.InsertProduct(p);
        response.sendRedirect("ListProductServlet");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
