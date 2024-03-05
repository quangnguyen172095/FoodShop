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

/**
 *
 * @author acer
 */
public class AdminsDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public List<Admin> getAllUsers() {
        List<Admin> listUsers = new ArrayList<>();
        String sql = "SELECT *  FROM [dbo].[Admin]";
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setAdminID(rs.getInt("AdminID"));
                admin.setFullName(rs.getString("FullName"));
                admin.setUsername(rs.getString("Username"));
                admin.setPassword(rs.getString("Password"));
                admin.setEmail(rs.getString("Email"));
                admin.setPhone(rs.getString("Phone"));
                admin.setRole(rs.getString("Role"));
                admin.setImage(rs.getString("Image"));
                admin.setJoinedDate(rs.getDate("JoinedDate"));
                admin.setAddress(rs.getString("Address"));
                admin.setDepartment(rs.getString("Department"));
                listUsers.add(admin);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listUsers;
    }

    public Admin SearchByID(int adminID) {
        String sql = "SELECT *  FROM [dbo].[Admin] WHERE AdminID = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, adminID);
            rs = stm.executeQuery();
            if (rs.next()) {
                Admin foundAdmin = new Admin();
                foundAdmin.setAdminID(rs.getInt("AdminID"));
                foundAdmin.setFullName(rs.getString("FullName"));
                foundAdmin.setUsername(rs.getString("Username"));
                foundAdmin.setPassword(rs.getString("Password"));
                foundAdmin.setEmail(rs.getString("Email"));
                foundAdmin.setPhone(rs.getString("Phone"));
                foundAdmin.setRole(rs.getString("Role"));
                foundAdmin.setImage(rs.getString("Image"));
                foundAdmin.setJoinedDate(rs.getDate("JoinedDate"));
                foundAdmin.setAddress(rs.getString("Address"));
                foundAdmin.setDepartment(rs.getString("Department"));
                return foundAdmin;
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }

    public static void main(String[] args) {
        AdminsDAO adminDAO = new AdminsDAO();
        Admin foundUsers = adminDAO.SearchByID(5);
//        List<Admin> listUsers = adminDAO.getAllUsers();
        System.out.println(foundUsers.toString());
    }
}
