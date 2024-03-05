/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetails;
import model.Orders;
import model.Products;

/**
 *
 * @author acer
 */
public class OrderDetailsDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    OrdersDAO ordersDAO = new OrdersDAO();
    ProductsDAO productsDAO = new ProductsDAO();

    public List<OrderDetails> getAllOrderDetails() {
        List<OrderDetails> listOrderDetails = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[OrderDetails]";
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                OrderDetails od = new OrderDetails();
                Orders foundOrder = ordersDAO.SearchByID(rs.getInt("OrderID"));
                od.setOrders(foundOrder);
                Products foundProduct = productsDAO.SearchByID(rs.getInt("ProductID"));
                od.setProducts(foundProduct);
                od.setQuantity(rs.getInt("Quantity"));
                listOrderDetails.add(od);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listOrderDetails;
    }

    public List<OrderDetails> SearchByID(int ordersID) {
        List<OrderDetails> listOrderDetails = new ArrayList<>();
        String sql = "SELECT *  FROM [dbo].[OrderDetails] WHERE OrderID = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, ordersID);
            rs = stm.executeQuery();
            while (rs.next()) {
                OrderDetails od = new OrderDetails();
                Orders foundOrder = ordersDAO.SearchByID(rs.getInt("OrderID"));
                od.setOrders(foundOrder);
                Products foundProduct = productsDAO.SearchByID(rs.getInt("ProductID"));
                od.setProducts(foundProduct);
                od.setQuantity(rs.getInt("Quantity"));
                listOrderDetails.add(od);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listOrderDetails;
    }

    public boolean insertDetails(OrderDetails orderDetails) {
        String sql = "INSERT INTO [dbo].[OrderDetails]\n"
                + "           ([OrderID],[ProductID],[Quantity])\n"
                + "     VALUES (?,?,?)";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, orderDetails.getOrders().getOrderID());
            stm.setInt(2, orderDetails.getProducts().getProductID());
            stm.setInt(3, orderDetails.getQuantity());
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean deleteOrderDetail(int orderID) {
        try {
            String sql = "DELETE FROM OrderDetails WHERE OrderID = ?";
            if (orderID == 0) {
                sql = "DELETE * FROM OrderDetails";
            }
            stm = connection.prepareStatement(sql);
            stm.setInt(1, orderID);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        OrderDetailsDAO odDAO = new OrderDetailsDAO();
        List<OrderDetails> listOrderDetails = odDAO.SearchByID(1);
        for (OrderDetails listOrderDetail : listOrderDetails) {
            System.out.println(listOrderDetail.getProducts().getProductName());
            System.out.println(listOrderDetail.getQuantity());
        }
    }
}
