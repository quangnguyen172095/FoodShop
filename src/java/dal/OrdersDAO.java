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
import model.Customers;
import model.Orders;
import model.Admin;

/**
 *
 * @author acer
 */
public class OrdersDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    CustomersDAO customersDAO = new CustomersDAO();
    AdminsDAO adminDAO = new AdminsDAO();

    public List<Orders> getAllOrders() {
        List<Orders> listCustomers = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Orders]";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                order.setCreatedBy(foundAdmin);
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getDouble("Freight"));
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

    public List<Orders> getAllOrders(int index, int length) {
        List<Orders> listCustomers = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Orders] ORDER BY  OrderID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, (index - 1) * length);
            stm.setInt(2, length);
            rs = stm.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                order.setCreatedBy(foundAdmin);
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getDouble("Freight"));
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

    public Orders SearchByID(int ordersID) {
        String sql = "SELECT *  FROM [dbo].[Orders] WHERE OrderID = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, ordersID);
            rs = stm.executeQuery();
            if (rs.next()) {
                Orders foundOrder = new Orders();
                foundOrder.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                foundOrder.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                foundOrder.setCreatedBy(foundAdmin);
                foundOrder.setOrderStatus(rs.getString("OrderStatus"));
                foundOrder.setOrderDate(rs.getTimestamp("OrderDate"));
                foundOrder.setFreight(rs.getDouble("Freight"));
                foundOrder.setPaymentMethod(rs.getString("PaymentMethod"));
                foundOrder.setShippingAddress(rs.getString("ShippingAddress"));
                foundOrder.setTransactionStatus(rs.getString("TransactionStatus"));
                return foundOrder;
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

    public List<Orders> searchAll(String textSearchString) {
        List<Orders> listOrders = new ArrayList<>();
        String sql = "SELECT o.* FROM [dbo].[Orders] o "
                + "JOIN Customers c ON o.CustomerID = c.CustomerID\n"
                + "JOIN Admin a on a.AdminID = o.CreatedBy\n"
                + "WHERE CONCAT(o.OrderID, c.FullName, o.OrderDate, a.FullName, o.PaymentMethod, o.OrderStatus) LIKE ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + textSearchString + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                order.setCreatedBy(foundAdmin);
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getDouble("Freight"));
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

    public List<Orders> filterOrders(String orderStatus, String payment) {
        List<Orders> listOrders = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Orders] \n"
                + "WHERE OrderStatus like ? AND PaymentMethod like ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + orderStatus + "%");
            stm.setString(2, "%" + payment + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("OrderID"));
                Customers foundCustomers = customersDAO.SearchByID(rs.getInt("CustomerID"));
                order.setCustomers(foundCustomers);
                Admin foundAdmin = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                order.setCreatedBy(foundAdmin);
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setFreight(rs.getDouble("Freight"));
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

    public int insertOrders(Orders orders) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + " ([CustomerID],[OrderStatus],[OrderDate],[PaymentMethod],[ShippingAddress],"
                + "[Freight],[CreatedBy],[CreatedOn],[TransactionStatus])\n"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            stm = con.prepareStatement(sql, stm.RETURN_GENERATED_KEYS);
            stm.setInt(1, orders.getCustomers().getCustomerID());
            stm.setString(2, orders.getOrderStatus());
            stm.setTimestamp(3, orders.getOrderDate());
            stm.setString(4, orders.getPaymentMethod());
            stm.setString(5, orders.getShippingAddress());
            stm.setDouble(6, orders.getFreight());
            stm.setInt(7, orders.getCreatedBy().getAdminId());
            stm.setTimestamp(8, orders.getCreatedOn());
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
            String shippingAddress, Timestamp createdOn, String transactionStatus, int orderID) {
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
            stm.setTimestamp(4, createdOn);
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

        List<Orders> listOrders = ordersDAO.filterOrders("","");
        for (Orders listOrder : listOrders) {
            System.out.println(listOrder.getOrderID());
        }
    }
}
