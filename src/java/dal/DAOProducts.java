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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.Categories;
import model.Products;

/**
 *
 * @author PC
 */
public class DAOProducts extends DBContext {


    public Products findById(int pid) {
        Products pro = null;
        String sql = "select * from products where ProductID =" + pid;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(rs.getInt("ProductID"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getFloat("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setStatus(rs.getString("Status"));
                p.setDiscount(rs.getFloat("Discount"));
                p.setCreatedBy(rs.getInt("CreatedBy"));
                p.setCreatedOn(rs.getDate("CreatedOn"));
                p.setModifiedBy(rs.getInt("ModifiedBy"));
                p.setModifiedOn(rs.getDate("ModifiedOn"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
    

    public void updateAmounProduct(int amount, int productID) {
        String query = "UPDATE Products SET Quantity = ? WHERE ProductID = ?";
        DBContext db = new DBContext();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, productID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Products> searchProductByCategory(int cateId) {
        ArrayList<Products> searchList = new ArrayList<>();

        try {
            String sql = "select * from Products\n"
                    + "where CategoryID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, cateId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(rs.getInt("ProductID"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getFloat("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setStatus(rs.getString("Status"));
                p.setDiscount(rs.getFloat("Discount"));
                p.setCreatedBy(rs.getInt("CreatedBy"));
                p.setCreatedOn(rs.getDate("CreatedOn"));
                p.setModifiedBy(rs.getInt("ModifiedBy"));
                p.setModifiedOn(rs.getDate("ModifiedOn"));

                searchList.add(p);

            }
        } catch (Exception e) {
        }

        return searchList;
    }

    public ArrayList<Products> getProducts() {
        ArrayList<Products> products = new ArrayList<>();

        try {
            String sql = "select * \n"
                    + "from Products p inner join Categories c\n"
                    + "on p.CategoryID = c.CategoryID";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(rs.getInt("ProductID"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getFloat("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setStatus(rs.getString("Status"));
                p.setDiscount(rs.getFloat("Discount"));
                p.setCreatedBy(rs.getInt("CreatedBy"));
                p.setCreatedOn(rs.getDate("CreatedOn"));
                p.setModifiedBy(rs.getInt("ModifiedBy"));
                p.setModifiedOn(rs.getDate("ModifiedOn"));

                Categories c = new Categories();
                c.setCategoryID(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                c.setCreatedBy(rs.getInt("CreatedBy"));
                c.setCreatedOn(rs.getDate("CreatedOn"));
                c.setModifiedBy(rs.getInt("ModifiedBy"));
                c.setModifiedOn(rs.getDate("ModifiedOn"));

                p.setCategories(c);
                products.add(p);

            }
        } catch (Exception e) {
        }

        return products;
    }

    public ArrayList<Products> gettop6Products() {
        ArrayList<Products> products = new ArrayList<>();

        try {
            String sql = "SELECT TOP 6 p.productid, p.productname, p.price, p.discount, p.image, c.categoryname, SUM(od.quantity) AS total_quantity\n"
                    + "FROM Products p\n"
                    + "JOIN OrderDetails od ON p.productid = od.productid\n"
                    + "JOIN Categories c ON p.categoryid = c.categoryid\n"
                    + "GROUP BY p.productid, p.productname, p.price, p.discount, p.image, c.categoryname\n"
                    + "ORDER BY total_quantity DESC";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(rs.getInt("productid")); // Điều chỉnh tên cột thành chữ thường
                p.setProductName(rs.getString("productname"));
                p.setPrice(rs.getFloat("price"));
                p.setDiscount(rs.getFloat("discount"));
                p.setImage(rs.getString("image"));

                Categories c = new Categories();
                c.setCategoryName(rs.getString("categoryname"));
                p.setCategories(c);

                products.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để bạn có thể kiểm tra và sửa lỗi một cách dễ dàng hơn
        }

        return products;
    }

    public ArrayList<Categories> getCategories() {
        ArrayList<Categories> categories = new ArrayList<>();

        try {
            String sql = "select * from Categories";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();
                c.setCategoryID(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                c.setCreatedBy(rs.getInt("CreatedBy"));
                c.setCreatedOn(rs.getDate("CreatedOn"));
                c.setModifiedBy(rs.getInt("ModifiedBy"));
                c.setModifiedOn(rs.getDate("ModifiedOn"));
                categories.add(c);

            }
        } catch (Exception e) {
        }

        return categories;
    }

    public static void main(String[] args) {
        DAOProducts dao = new DAOProducts();
        for (Products pro : dao.getProducts()) {
            System.out.println(pro);
        }
    }

    public void DeleteProduct(int productId) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "                           WHERE ProductID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, productId);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public int getTotalProduct() {
        String sql = "select count(*) from Products";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Products> pagingProduct(int index) {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT * FROM Products\n"
                + "                       ORDER BY ProductID\n"
                + "                       OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("ProductID"));
                CategoryDAO categoryDAO = new CategoryDAO();
                Categories category = categoryDAO.GetCategoryById(rs.getInt("CategoryID"));
                product.setCategories(category);
                product.setProductName(rs.getString("ProductName"));
                product.setImage(rs.getString("Image"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getFloat("Price"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStatus(rs.getString("Status"));
                product.setDiscount(rs.getFloat("Discount"));
                product.setCreatedBy(rs.getInt("CreatedBy"));
                product.setCreatedOn(rs.getDate("CreatedOn"));
                product.setModifiedBy(rs.getInt("ModifiedBy"));
                product.setModifiedOn(rs.getDate("ModifiedOn"));
                list.add(product);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Products GetProductById(int productId) {
        String sql = "SELECT [ProductID]\n"
                + "                           ,[CategoryID]\n"
                + "                           ,[ProductName]\n"
                + "                           ,[Image]\n"
                + "                           ,[Description]\n"
                + "                           ,[Price]\n"
                + "                           ,[Quantity]\n"
                + "                           ,[Status]\n"
                + "                           ,[Discount]\n"
                + "                           ,[CreatedBy]\n"
                + "                           ,[CreatedOn]\n"
                + "                           ,[ModifiedBy]\n"
                + "                           ,[ModifiedOn]\n"
                + "                       FROM [dbo].[Products]\n"
                + "                       WHERE ProductID = ?";
        DBContext db = new DBContext();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Products product = new Products();
                CategoryDAO categoryDAO = new CategoryDAO();
                Categories category = categoryDAO.GetCategoryById(rs.getInt("CategoryID"));
                product.setCategories(category);
                product.setProductName(rs.getString("ProductName"));
                product.setImage(rs.getString("Image"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getFloat("Price"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStatus(rs.getString("Status"));
                product.setDiscount(rs.getFloat("Discount"));
                product.setCreatedBy(rs.getInt("CreatedBy"));
                product.setCreatedOn(rs.getDate("CreatedOn"));
                product.setModifiedBy(rs.getInt("ModifiedBy"));
                product.setModifiedOn(rs.getDate("ModifiedOn"));
                return product;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void UpdateProduct(Products product) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "                        SET [CategoryID] = ?\n"
                + "                           ,[ProductName] = ?\n"
                + "                           ,[Image] = ?\n"
                + "                           ,[Description] = ?\n"
                + "                           ,[Price] = ?\n"
                + "                           ,[Quantity] = ?\n"
                + "                           ,[Status] = ?\n"
                + "                           ,[Discount] = ?\n"
                + "                           ,[CreatedBy] = ?\n"
                + "                           ,[CreatedOn] = ?\n"
                + "                           ,[ModifiedBy] = ?\n"
                + "                           ,[ModifiedOn] = ?\n"
                + "                      WHERE ProductID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, product.getCategories().getCategoryID());
            st.setString(2, product.getProductName());
            st.setString(3, product.getImage());
            st.setString(4, product.getDescription());
            st.setDouble(5, product.getPrice());
            st.setInt(6, product.getQuantity());
            st.setString(7, product.getStatus());
            st.setDouble(8, product.getDiscount());
            st.setInt(9, product.getCreatedBy());
            st.setDate(10, product.getCreatedOn());
            st.setInt(11, product.getModifiedBy());
            st.setDate(12, product.getModifiedOn());
            st.setInt(13, product.getProductID());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Products SearchByID(int productsID) {
        AdminDAO adminDAO = new AdminDAO();
        String sql = "SELECT *  FROM [dbo].[Products] WHERE ProductID = ?";
        PreparedStatement stm;
        ResultSet rs;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, productsID);
            rs = stm.executeQuery();
            if (rs.next()) {

                Products foundProducts = new Products();
//                Categories foundCategories = CategoriesDAO.SearchByID(rs.getInt("CategoryID"));
//            foundProducts.setCategories(foundCategories);
                foundProducts.setProductName(rs.getString("ProductName"));
                foundProducts.setImage(rs.getString("Image"));
                foundProducts.setDescription(rs.getString("Description"));
                foundProducts.setPrice(rs.getFloat("Price"));
                foundProducts.setQuantity(rs.getInt("Quantity"));
                foundProducts.setStatus(rs.getString("Status"));
                foundProducts.setDiscount(rs.getFloat("Discount"));

                foundProducts.setCreatedBy(rs.getInt("CreatedBy"));
                foundProducts.setCreatedOn(rs.getDate("CreatedOn"));

//                Admin modifiedBy = adminDAO.SearchByID(rs.getInt("ModifiedBy"));
                foundProducts.setModifiedBy(rs.getInt("ModifiedBy"));
                foundProducts.setModifiedOn(rs.getDate("ModifiedOn"));
                return foundProducts;
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }
}
