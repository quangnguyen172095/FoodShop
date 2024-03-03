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
import model.Admin;
import model.ContentHome;
import model.HeaderHome;
import model.Product;

/**
 *
 * @author PC
 */
public class HomeController extends HttpServlet {

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
            out.println("<title>Servlet ProductsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductsController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Product> listProductHome = dao.gettop6Products();
        DAOHome dh = new DAOHome();
        
        //content aboutus
        ContentHome ch1 = dh.getContentById(4);
        request.setAttribute("ch1", ch1);
        
        //content menu
        ContentHome ch2 = dh.getContentById(5);
        request.setAttribute("ch2", ch2);
        
        //content team
        ContentHome ch3 = dh.getContentById(6);
        request.setAttribute("ch3", ch3);
        
        //list chef
        ArrayList<Admin> admins = dh.getChef();
        request.setAttribute("admins", admins);
        
        //content footer
        ContentHome ch4 = dh.getContentById(7);
        request.setAttribute("ch4", ch4);
        
        
        
        //content slide
        ArrayList<ContentHome> listContent = dh.getContent();
        request.setAttribute("listContent", listContent);
        ArrayList<HeaderHome> listHeader = dh.getHeader();
        request.setAttribute("listHeader", listHeader);
        request.setAttribute("listProductHome", listProductHome);
        request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
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
        DAOProducts dao = new DAOProducts();
        ArrayList<Product> listProductHome = dao.gettop6Products();
        DAOHome dh = new DAOHome();
        
        //content aboutus
        ContentHome ch1 = dh.getContentById(4);
        request.setAttribute("ch1", ch1);
        
        //content menu
        ContentHome ch2 = dh.getContentById(5);
        request.setAttribute("ch2", ch2);
        
        //content team
        ContentHome ch3 = dh.getContentById(6);
        request.setAttribute("ch3", ch3);
        
        //list chef
        ArrayList<Admin> admins = dh.getChef();
        request.setAttribute("admins", admins);
        
        //content footer
        ContentHome ch4 = dh.getContentById(7);
        request.setAttribute("ch4", ch4);
        
        //content slide
        ArrayList<ContentHome> listContent = dh.getContent();
        request.setAttribute("listContent", listContent);
        ArrayList<HeaderHome> listHeader = dh.getHeader();
        request.setAttribute("listHeader", listHeader);
        request.setAttribute("listProductHome", listProductHome);
        request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
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
