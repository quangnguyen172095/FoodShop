/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.JsonObject;
import dal.DAOHome;
import dal.DAOProducts;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import model.Customer;
import model.HeaderHome;
import model.Order;
import model.OrderDetail;
import model.Products;

/**
 *
 * @author PC
 */
public class AddCart extends HttpServlet {

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
            out.println("<title>Servlet AddCart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCart at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        DAOHome dh = new DAOHome();
        ArrayList<HeaderHome> listHeader = dh.getHeader();
        request.setAttribute("listHeader", listHeader);
        Customer cus = (Customer) session.getAttribute("CUS");
        if (cus == null) {
            response.sendRedirect("LoginController");
            return;
        }

        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("productID"));
        if (action == null || action.trim().equals("")) {
            //add
            // Lấy đối tượng Order từ session, hoặc tạo mới nếu chưa có
            Order order = (Order) session.getAttribute("order");
            if (order == null) {
                order = new Order();
            }
            Products p = new DAOProducts().findById(productId);
            order.addItems(p);
            session.setAttribute("order", order);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            //delete
            Order order = (Order) session.getAttribute("order");
            order.removeItem(productId);
            session.setAttribute("order", order);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        } else if (action != null && action.equals("update")) {
            //update quantity
            Order order = (Order) session.getAttribute("order");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            order.updateItem(productId, quantity);
            session.setAttribute("order", order);

            DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Định dạng số với 2 chữ số thập phân
            String totalPrice = "<strong>" + decimalFormat.format(order.getTotalPrice()) + " VNÐ</strong>";
            String cartList = "";
            for (OrderDetail item : order.getOrderDetails()) {
                float unitPrice = item.getPrice() - item.getPrice() * item.getDiscount();
                float totalPricePerItem = unitPrice * item.getQuantity();

                unitPrice = Float.parseFloat(decimalFormat.format(unitPrice)); // Làm tròn giá unitPrice
                totalPricePerItem = Float.parseFloat(decimalFormat.format(totalPricePerItem)); // Làm tròn giá totalPricePerItem

                cartList += "<tr>\n"
                        + "    <td class=\"p-4\">\n"
                        + "        <div class=\"media align-items-center\">\n"
                        + "            <img src=\"./assets/images/menu/" + item.getImage() + "\" class=\"d-block ui-w-40 ui-bordered mr-4\" alt=\"\">\n"
                        + "            <div class=\"media-body\">\n"
                        + "                <a href=\"/productdetail?id=" + item.getProductID() + "\" class=\"d-block text-dark\">" + item.getProductName() + "</a>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </td>\n"
                        + "    <td class=\"text-right font-weight-semibold align-middle p-4\">" + unitPrice + " VNÐ</td>\n"
                        + "    <td class=\"align-middle p-4\"><input type=\"number\" name=\"quantity\" class=\"form-control text-center\" value=\"" + item.getQuantity() + "\" min=\"0\" onchange=\"updateQuantity(this, " + item.getProductID() + ")\"></td>\n"
                        + "    <td class=\"text-right font-weight-semibold align-middle p-4\">" + totalPricePerItem + " VNÐ</td>\n"
                        + "    <td class=\"text-center align-middle px-0\"><a href=\"cart?productID=" + item.getProductID() + "&action=delete\" class=\"shop-tooltip close float-none text-danger\" title=\"\" data-original-title=\"Remove\">×</a></td>\n"
                        + "</tr>";
            }
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("total", totalPrice);
            jsonResponse.addProperty("list", cartList);
            response.getWriter().write(jsonResponse.toString());
        }

//        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
