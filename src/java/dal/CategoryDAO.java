package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categories;

public class CategoryDAO extends DBContext {

    // GET ALL CATEGORIES
    public List<Categories> GetAllCategory() {
        List<Categories> list = new ArrayList<>();
        String sql = "SELECT [CategoryID]\n" +
"                           ,[CategoryName]\n" +
"                           ,[CreatedBy]\n" +
"                           ,[CreatedOn]\n" +
"                           ,[ModifiedBy]\n" +
"                           ,[ModifiedOn]\n" +
"                       FROM [dbo].[Categories]";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories category = new Categories();
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setCreatedBy(rs.getInt("CreatedBy"));
                category.setCreatedOn(rs.getDate("CreatedOn"));
                category.setModifiedBy(rs.getInt("ModifiedBy"));
                category.setModifiedOn(rs.getDate("ModifiedOn"));
                list.add(category);
            }
        } catch (SQLException e) {
            // Handle exception

        }

        return list;
    }

    // GET CATEGORY VIA CATEGORYID
    public Categories GetCategoryById(int category_id) {
        String sql = "SELECT [CategoryID]\n" +
"                           ,[CategoryName]\n" +
"                           ,[CreatedBy]\n" +
"                           ,[CreatedOn]\n" +
"                           ,[ModifiedBy]\n" +
"                           ,[ModifiedOn]\n" +
"                       FROM [dbo].[Categories]\n" +
"                       WHERE CategoryID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, category_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Categories category = new Categories();
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setCreatedBy(rs.getInt("CreatedBy"));
                category.setCreatedOn(rs.getDate("CreatedOn"));
                category.setModifiedBy(rs.getInt("ModifiedBy"));
                category.setModifiedOn(rs.getDate("ModifiedOn"));
                return category;
            }
        } catch (SQLException e) {
            // Handle exception

        }
        return null;
    }

    // INSERT A CATEGORY
    public void InsertCategory(Categories category) {
        String sql = "INSERT INTO [dbo].[Categories]\n" +
"                                ([CategoryName], [CreatedBy], [CreatedOn], [ModifiedBy], [ModifiedOn])\n" +
"                          VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, category.getCategoryName());
            st.setInt(2, category.getCreatedBy());
            st.setDate(3, category.getCreatedOn());
            st.setInt(4, category.getModifiedBy());
            st.setDate(5, category.getModifiedOn());
            st.executeUpdate();
        } catch (SQLException e) {
            // Handle exception

        }
    }

    // DELETE A CATEGORY
    public void DeleteCategory(int categoryId) {
        String sql = "DELETE FROM [dbo].[Categories]\n" +
"                           WHERE CategoryID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, categoryId);
            st.executeUpdate();
        } catch (SQLException e) {
            // Handle exception

        }
    }

    // UPDATE A CATEGORY
    public void UpdateCategory(Categories category) {
        String sql = "UPDATE [dbo].[Categories]\n" +
"                        SET [CategoryName] = ?,\n" +
"                            [CreatedBy] = ?,\n" +
"                            [CreatedOn] = ?,\n" +
"                            [ModifiedBy] = ?,\n" +
"                            [ModifiedOn] = ?\n" +
"                      WHERE CategoryID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, category.getCategoryName());
            st.setInt(2, category.getCreatedBy());
            st.setDate(3, category.getCreatedOn());
            st.setInt(4, category.getModifiedBy());
            st.setDate(5, category.getModifiedOn());
            st.setInt(6, category.getCategoryID());
            st.executeUpdate();
        } catch (SQLException e) {
            // Handle exception

        }
    }

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Categories> list = categoryDAO.GetAllCategory();
        for (Categories category : list) {
            System.out.println(category.getCategoryName());
        }
    }
}
