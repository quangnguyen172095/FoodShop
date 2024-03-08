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
import model.Admin;
import model.Product;
import model.Products;

/**
 *
 * @author acer
 */
public class ProductsDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public List<Product> getAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        String sql = "SELECT *  FROM [dbo].[Products]";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
//                Categories foundCategories = CategoriesDAO.SearchByID(rs.getInt("CategoryID"));
//            foundProducts.setCategories(foundCategories);
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getFloat("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setStatus(rs.getString("Status"));
                p.setDiscount(rs.getFloat("Discount"));

                AdminsDAO adminDAO = new AdminsDAO();
                Admin createdBy = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                p.setCreatedBy(createdBy.getAdminId());
                p.setCreatedOn(rs.getDate("CreatedOn"));

                Admin modifiedBy = adminDAO.SearchByID(rs.getInt("ModifiedBy"));
                p.setModifiedBy(modifiedBy.getAdminId());
                p.setModifiedOn(rs.getDate("ModifiedOn"));

                listProducts.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listProducts;
    }

    public Product SearchByID(int productsID) {
        AdminsDAO adminDAO = new AdminsDAO();
        String sql = "SELECT *  FROM [dbo].[Products] WHERE ProductID = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, productsID);
            rs = stm.executeQuery();
            if (rs.next()) {

                Product foundProducts = new Product();
                foundProducts.setProductID(rs.getInt("ProductID"));

//                Categories foundCategories = CategoriesDAO.SearchByID(rs.getInt("CategoryID"));
//            foundProducts.setCategories(foundCategories);
                foundProducts.setProductName(rs.getString("ProductName"));
                foundProducts.setImage(rs.getString("Image"));
                foundProducts.setDescription(rs.getString("Description"));
                foundProducts.setPrice(rs.getFloat("Price"));
                foundProducts.setQuantity(rs.getInt("Quantity"));
                foundProducts.setStatus(rs.getString("Status"));
                foundProducts.setDiscount(rs.getFloat("Discount"));

                Admin createdBy = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                foundProducts.setCreatedBy(createdBy.getAdminId());
                foundProducts.setCreatedOn(rs.getDate("CreatedOn"));

                Admin modifiedBy = adminDAO.SearchByID(rs.getInt("ModifiedBy"));
                foundProducts.setModifiedBy(modifiedBy.getAdminId());
                foundProducts.setModifiedOn(rs.getDate("ModifiedOn"));
                return foundProducts;
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }
 public Product SearchByName(String productName) {
        AdminsDAO adminDAO = new AdminsDAO();
        String sql = "SELECT *  FROM [dbo].[Products] WHERE ProductName = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, productName);
            rs = stm.executeQuery();
            if (rs.next()) {

                Product foundProducts = new Product();
                foundProducts.setProductID(rs.getInt("ProductID"));

//                Categories foundCategories = CategoriesDAO.SearchByID(rs.getInt("CategoryID"));
//            foundProducts.setCategories(foundCategories);
                foundProducts.setProductName(rs.getString("ProductName"));
                foundProducts.setImage(rs.getString("Image"));
                foundProducts.setDescription(rs.getString("Description"));
                foundProducts.setPrice(rs.getFloat("Price"));
                foundProducts.setQuantity(rs.getInt("Quantity"));
                foundProducts.setStatus(rs.getString("Status"));
                foundProducts.setDiscount(rs.getFloat("Discount"));

                Admin createdBy = adminDAO.SearchByID(rs.getInt("CreatedBy"));
                foundProducts.setCreatedBy(createdBy.getAdminId());
                foundProducts.setCreatedOn(rs.getDate("CreatedOn"));

                Admin modifiedBy = adminDAO.SearchByID(rs.getInt("ModifiedBy"));
                foundProducts.setModifiedBy(modifiedBy.getAdminId());
                foundProducts.setModifiedOn(rs.getDate("ModifiedOn"));
                return foundProducts;
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }
    public static void main(String[] args) {
        ProductsDAO productsDAO = new ProductsDAO();
//        Products p = productsDAO.SearchByName("Coca Cola");
//        List<Products> listProducts = productsDAO.getAllProducts();
//        for (Products listProduct : listProducts) {
//            System.out.println(p.getProductID());
//        }
    }
}
