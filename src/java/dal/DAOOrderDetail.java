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
import model.Order;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author PC
 */
public class DAOOrderDetail extends DBContext {
    
    PreparedStatement stm;
    ResultSet rs;
    DAOOrder ordersDAO = new DAOOrder();
    DAOProducts productsDAO = new DAOProducts();
    public boolean saveOrderDetail(OrderDetail orderDetail) {
        String query = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity) VALUES (?, ?, ?)";
        try (PreparedStatement pre = con.prepareStatement(query)) {
            pre.setInt(1, orderDetail.getOrderID());
            pre.setInt(2, orderDetail.getProductID());
            pre.setInt(3, orderDetail.getQuantity());


            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<OrderDetail> SearchByID(int ordersID) {
        List<OrderDetail> listOrderDetails = new ArrayList<>();
        String sql = "SELECT *  FROM [dbo].[OrderDetails] WHERE OrderID = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, ordersID);
            rs = stm.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setOrderID(rs.getInt("OrderID"));
                Product foundProduct = productsDAO.SearchByID(rs.getInt("ProductID"));
                od.setProducts(foundProduct);
                od.setQuantity(rs.getInt("Quantity"));
                listOrderDetails.add(od);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listOrderDetails;}
}
