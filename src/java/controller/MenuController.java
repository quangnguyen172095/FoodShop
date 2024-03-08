/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOHome;
import dal.DAOProducts;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Categories;
import model.ContentHome;
import model.HeaderHome;
import model.Product;


/**
 *
 * @author PC
 */
public class MenuController extends HttpServlet {

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
            out.println("<title>Servlet MenuController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MenuController at " + request.getContextPath() + "</h1>");
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
        DAOProducts dao = new DAOProducts();
        String index_raw = request.getParameter("index");
        if(index_raw==null){
            index_raw = "1";
        }
        int index = Integer.parseInt(index_raw);
                
        int count = dao.getTotalProduct();
        int endpage = count/10;
        if(count%10!=0){
            endpage++;
        }
        List<Product> listProductByPage = dao.pagingProduct(index);
        ArrayList<Categories> listCategories = dao.getCategories();
        
        //header
        DAOHome dh = new DAOHome();
        ArrayList<HeaderHome> listHeader = dh.getHeader();
        request.setAttribute("listHeader", listHeader);
        
        //footer
        ContentHome ch4 = dh.getContentById(7);
        request.setAttribute("ch4", ch4);
        
        request.setAttribute("listbypage", listProductByPage);
        request.setAttribute("endpage", endpage);
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("Menu.jsp").forward(request, response);
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
