/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.Customers;

public class AccountDAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public boolean checkMailExist(String email) {
        String sql = "select * from Admin where Email = ? ";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean checkPhoneExist(String phone_num) {
        String sql = "select * from Admin where Phone = ? ";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, phone_num);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
     public Admin checkAccountExist(String user) {
                String query = "select * from Admin where Username = ?";

                try{
                    ps= con.prepareStatement(query);
                    ps.setString(1, user);
                    rs= ps.executeQuery();
                    while(rs.next()){
                        return new Admin(rs.getInt("AdminID"),rs.getString("Fullname")
                                ,rs.getString("Username"),rs.getString("Password")
                                ,rs.getString("Email"),rs.getString("Phone")
                                ,rs.getString("Role"),rs.getString("Image")
                                ,rs.getDate("JoinedDate"),rs.getString("Address"), 
                                rs.getString("Department"));
                    }
                }catch(Exception E){     
                }
        return null;
    }
    
    public void UpDatePassWord(String pass, String user) {

        try {
            String sql = "UPDATE Admin\n"
                    + "   SET [Password] = ?\n"
                    + " WHERE [Username] = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, pass);
            stm.setString(2, user);
            stm.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public Admin login(String username, String password) throws SQLException {
        String sql = "select * from Admin where Username = ? and Password = ?";

        if (con != null) {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("AdminID"),
                        rs.getString("Fullname"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Role"),
                        rs.getString("Image"),
                        rs.getDate("JoinedDate"),
                        rs.getString("Address"),
                        rs.getString("Department"));
            }
        }
        return null;
    }

    public Admin getById(Integer userId) throws SQLException {
        String sql = "select * from Admin where AdminId = ?";

 
        if (con != null) {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("AdminID"),
                        rs.getString("Fullname"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Role"),
                        rs.getString("Image"),
                        rs.getDate("JoinedDate"),
                        rs.getString("Address"),
                        rs.getString("Department"));
            }
        }
        return null;
    }

    public Admin updateAccount(Admin account) throws SQLException {

        String sql = "UPDATE Users\n"
                + "SET\n"
                + "    Username = ?,\n"
                + "    Password = ?,\n"
                + "    Email = ?,\n"
                + "    FullName = ?,\n"
                + "    Role = ?,\n"
                + "    JoinDate = ?, -- Use the desired date\n"
                + "    Phone = ?,\n"
                + "    Address = ?,\n"
                + "    Department = ?\n"
                + "WHERE\n"
                + "    UserID = ?;";
        
        if (con != null) {
            ps = con.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getFullName());
            ps.setString(5, account.getRole());
            ps.setDate(6, new Date(account.getJoinedDate().getTime()));
            ps.setString(7, account.getPhone());
            ps.setString(8, account.getAddress());
            ps.setString(9, account.getDepartment());
            ps.setInt(10, account.getAdminId());
            if (ps.executeUpdate() > 0) {
                return getById(account.getAdminId());
            }
        }
        return null;
    }

    public void insertAccount(Customers customers) {
        String sql = "insert into Customers (FullName, Phone, Email, Username, Password, Address) \n"
                + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, customers.getFullName());
            pre.setString(2, customers.getPhone());
            pre.setString(3, customers.getEmail());
            pre.setString(4, customers.getUsername());
            pre.setString(5, customers.getPassword());
            pre.setString(6, customers.getAddress());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }


    
}
