/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Customers;
import model.Orders;
import model.Admin;
import model.Order;

/**
 *
 * @author acer
 */
public class OrdersDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    CustomersDAO customersDAO = new CustomersDAO();
    AdminsDAO adminDAO = new AdminsDAO();

    public List<Order> getAllOrders() {
        List<Order> listCustomers = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Orders]";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                order.setCreatedBy(rs.getInt("CreatedBy"));
                order.setCreatedByAdmin(foundAdmin);
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getFloat("Freight"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setShippingAddress(rs.getString("ShippingAddress"));
                order.setTransactionStatus(rs.getString("TransactionStatus"));
                listCustomers.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listCustomers;
    }

    public List<Order> getAllOrders(int index, int length) {
        List<Order> listCustomers = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Orders] ORDER BY  OrderID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, (index - 1) * length);
            stm.setInt(2, length);
            rs = stm.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                if(foundAdmin == null){
                order.setCreatedBy(0);
                }else{
                order.setCreatedBy(foundAdmin.getAdminId());}
                order.setCreatedByAdmin(foundAdmin);
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getFloat("Freight"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setShippingAddress(rs.getString("ShippingAddress"));
                order.setTransactionStatus(rs.getString("TransactionStatus"));
                listCustomers.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listCustomers;
    }

    public Order SearchByID(int ordersID) {
        String sql = "SELECT *  FROM [dbo].[Orders] WHERE OrderID = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, ordersID);
            rs = stm.executeQuery();
            if (rs.next()) {
                Order foundOrder = new Order();
                foundOrder.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                foundOrder.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                if(foundAdmin == null){
                foundOrder.setCreatedBy(0);
                }else{
                foundOrder.setCreatedBy(foundAdmin.getAdminId());
                foundOrder.setOrderStatus(rs.getString("OrderStatus"));
                foundOrder.setOrderDate(rs.getDate("OrderDate"));
                foundOrder.setFreight(rs.getFloat("Freight"));
                foundOrder.setPaymentMethod(rs.getString("PaymentMethod"));
                foundOrder.setShippingAddress(rs.getString("ShippingAddress"));
                foundOrder.setTransactionStatus(rs.getString("TransactionStatus"));
                return foundOrder;}
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }

    public int getNRecords() {
        String sql = "SELECT COUNT(*)  FROM [dbo].[Orders]";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return 0;
    }

    public List<Order> searchAll(String textSearchString) {
        List<Order> listOrders = new ArrayList<>();
        String sql = "SELECT o.* FROM [dbo].[Orders] o "
                + "JOIN Customers c ON o.CustomerID = c.CustomerID\n"
                + "JOIN Admin a on a.AdminID = o.CreatedBy\n"
                + "WHERE CONCAT(o.OrderID, c.FullName, o.OrderDate, a.FullName, o.PaymentMethod, o.OrderStatus) LIKE ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + textSearchString + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                order.setCreatedBy(foundAdmin.getAdminId());
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getFloat("Freight"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setShippingAddress(rs.getString("ShippingAddress"));
                order.setTransactionStatus(rs.getString("TransactionStatus"));
                listOrders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listOrders;
    }

    public List<Order> filterOrders(String orderStatus, String payment) {
        List<Order> listOrders = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Orders] \n"
                + "WHERE OrderStatus like ? AND PaymentMethod like ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + orderStatus + "%");
            stm.setString(2, "%" + payment + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                order.setCreatedBy(foundAdmin.getAdminId());
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getFloat("Freight"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setShippingAddress(rs.getString("ShippingAddress"));
                order.setTransactionStatus(rs.getString("TransactionStatus"));
                listOrders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listOrders;
    }

    public int insertOrders(Order orders) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + " ([CustomerID],[OrderStatus],[OrderDate],[PaymentMethod],[ShippingAddress],"
                + "[Freight],[CreatedBy],[CreatedOn],[TransactionStatus])\n"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            stm = con.prepareStatement(sql, stm.RETURN_GENERATED_KEYS);
            stm.setInt(1, orders.getCustomers().getCustomerId());
            stm.setString(2, orders.getOrderStatus());
            stm.setDate(3, new Date(orders.getOrderDate().getTime()));
            stm.setString(4, orders.getPaymentMethod());
            stm.setString(5, orders.getShippingAddress());
            stm.setDouble(6, orders.getFreight());
            stm.setInt(7, orders.getCreatedBy());
            stm.setDate(8, new Date(orders.getCreatedOn().getTime()));
            stm.setString(9, orders.getTransactionStatus());
            stm.executeUpdate();
            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Trả về giá trị của khóa chính tự tăng
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public boolean updateOrder(String orderStatus, String paymentMethod,
            String shippingAddress, Date createdOn, String transactionStatus, int orderID) {
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [OrderStatus] = ?\n"
                + "          ,[PaymentMethod] = ?\n"
                + "         ,[ShippingAddress] = ?\n"
                + "         ,[CreatedOn] = ?\n"
                + "         ,[TransactionStatus] = ?\n"
                + " WHERE OrderID = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, orderStatus);
            stm.setString(2, paymentMethod);
            stm.setString(3, shippingAddress);
            stm.setDate(4, createdOn);
            stm.setString(5, transactionStatus);
            stm.setInt(6, orderID);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean deleteOrder(int orderID) {
        OrderDetailsDAO detailsDAO = new OrderDetailsDAO();
        String sql = "DELETE FROM [dbo].[Orders] WHERE OrderID = ?";
        try {
            if (detailsDAO.deleteOrderDetail(orderID)) {
                stm = con.prepareStatement(sql);
                stm.setInt(1, orderID);
                stm.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public static void main(String[] args) {
        OrdersDAO ordersDAO = new OrdersDAO();
        CustomersDAO cdao = new CustomersDAO();

//        List<Orders> listOrders = ordersDAO.filterOrders("","");
//        for (Orders listOrder : listOrders) {
//            System.out.println(listOrder.getOrderID());
//        }
    }
}
