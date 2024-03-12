/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.Categories;
import model.Order;
import model.Product;

/**
 *
 * @author PC
 */
public class DAOOrder extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    DAOCustomer customersDAO = new DAOCustomer();
    AdminDAO adminDAO = new AdminDAO();
    
    public Order getOrderById(int orderid) {
        String sql = "select * from Orders where OrderID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, orderid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getDate("OrderDate"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setShippingAddress(rs.getString("ShippingAddress"));
                order.setFreight(rs.getFloat("Freight"));
                order.setCreatedBy(rs.getInt("CreatedBy"));
                order.setCreatedOn(rs.getDate("CreatedOn"));
                order.setTransactionStatus(rs.getString("TransactionStatus"));
                return order;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<Order> getOrderByCustomerId(int customerid) {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "select * from Orders where CustomerID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, customerid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getDate("OrderDate"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setShippingAddress(rs.getString("ShippingAddress"));
                order.setFreight(rs.getFloat("Freight"));
                order.setCreatedBy(rs.getInt("CreatedBy"));
                order.setCreatedOn(rs.getDate("CreatedOn"));
                order.setTransactionStatus(rs.getString("TransactionStatus"));
                orders.add(order);
            }
        } catch (SQLException e) {
        }
        return orders;
    }

    public boolean saveOrder(Order order) {
        String query = "INSERT INTO orders (CustomerID, OrderStatus, OrderDate, PaymentMethod, ShippingAddress, Freight, TransactionStatus) VALUES (?, ?, ?, ?, ?, ?,?)";

        try ( PreparedStatement pre = con.prepareStatement(query)) {
            pre.setInt(1, order.getCustomerID());
            pre.setString(2, order.getOrderStatus());
            pre.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            pre.setString(4, order.getPaymentMethod());
            pre.setString(5, order.getShippingAddress());
            pre.setFloat(6, order.getFreight());
            pre.setString(7, order.getTransactionStatus());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getOrderID() {
        String query = "SELECT TOP(1) OrderID from orders order by OrderID DESC";
        try {
            DBContext db = new DBContext();
            PreparedStatement pre = con.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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

    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
        Order o = dao.getOrderById(7);
        System.out.println(o);
//        for (Order pro : dao.getOrderByCustomerId(24)) {
//            System.out.println(pro.getOrderID());
//        }
    }
}
