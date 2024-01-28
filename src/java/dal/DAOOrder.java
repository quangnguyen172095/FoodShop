/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Admin;
import model.Order;

/**
 *
 * @author PC
 */
public class DAOOrder extends DBContext {
    PreparedStatement stm;
    ResultSet rs;
    DAOCustomer customersDAO = new DAOCustomer();
    AdminDAO adminDAO = new AdminDAO();


    public boolean saveOrder(Order order) {
        String query = "INSERT INTO orders (CustomerID, OrderStatus, OrderDate, PaymentMethod, ShippingAddress, Freight, CreatedBy, CreatedOn, TransactionStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement pre = con.prepareStatement(query)) {
            pre.setInt(1, order.getCustomerID());
            pre.setString(2, order.getOrderStatus());
            pre.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            pre.setString(4, order.getPaymentMethod());
            pre.setString(5, order.getShippingAddress());
            pre.setFloat(6, order.getFreight());
            pre.setInt(7, order.getCreatedBy());
            pre.setDate(8, new java.sql.Date(order.getCreatedOn().getTime()));
            pre.setString(9, order.getTransactionStatus());

            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Order SearchByID(int ordersID) {
//        String sql = "SELECT *  FROM [dbo].[Orders] WHERE OrderID = ?";
//        try {
//            stm = con.prepareStatement(sql);
//            stm.setInt(1, ordersID);
//            rs = stm.executeQuery();
//            if (rs.next()) {
//                Order foundOrder = new Order();
//                foundOrder.setOrderID(rs.getInt("OrderID"));
//                model.Customer foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
//                foundOrder.setCustomers(foundCustomers);
//                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
//                foundOrder.setCreatedBy(foundAdmin);
//                foundOrder.setOrderStatus(rs.getString("OrderStatus"));
//                foundOrder.setOrderDate(rs.getTimestamp("OrderDate"));
//                foundOrder.setFreight(rs.getDouble("Freight"));
//                foundOrder.setPaymentMethod(rs.getString("PaymentMethod"));
//                foundOrder.setShippingAddress(rs.getString("ShippingAddress"));
//                foundOrder.setTransactionStatus(rs.getString("TransactionStatus"));
//                return foundOrder;
//            }
//        } catch (SQLException e) {
//            System.out.println("Error");
//        }
        return null;
    }

    public List<Order> getAllOrders(String orderBy, int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getNRecords() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
