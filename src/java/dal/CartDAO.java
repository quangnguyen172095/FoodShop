/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Customer;
import model.Products;

/**
 *
 * @author acer
 */
public class CartDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    DAOCustomer customersDAO = new DAOCustomer();
    DAOProducts productsDAO = new DAOProducts();

    public List<Cart> getAllCarts() {
        List<Cart> listCarts = new ArrayList<>();
        String sql = "SELECT CustomerID, ConfirmedOn  FROM [dbo].[Cart] "
                + "Group By CustomerID, ConfirmedOn  "
                + "ORDER BY CustomerID, ConfirmedOn";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                Customer customers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                cart.setCustomers(customers);
                cart.setConfirmedOn(rs.getTimestamp("ConfirmedOn"));
                listCarts.add(cart);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listCarts;
    }

    public List<Cart> getCartsByIDDate(int customerID, Timestamp confirmedOn) {
        List<Cart> listCarts = new ArrayList<>();
        String sql = "SELECT *  FROM [dbo].[Cart] \n" +
        "WHERE CustomerID = ? and ConfirmedOn = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, customerID);
            stm.setTimestamp(2, confirmedOn);
            rs = stm.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                Customer customers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                cart.setCustomers(customers);
                Products products = productsDAO.SearchByID(rs.getInt("ProductID"));
                cart.setProducts(products);
                cart.setQuantity(rs.getInt("Quantity"));
                cart.setConfirmedOn(rs.getTimestamp("ConfirmedOn"));
                listCarts.add(cart);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listCarts;
    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        List<Cart> listCarts = cartDAO.getCartsByIDDate(1, Timestamp.valueOf("2023-01-02 08:30:00.000"));
        for (Cart listCart : listCarts) {
            System.out.println(listCart.getProducts().getProductName());
            
        }
    }
}
