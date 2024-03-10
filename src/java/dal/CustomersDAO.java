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
import model.Customers;

/**
 *
 * @author acer
 */
public class CustomersDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    
    public Customers checkCustomerExist(String user) {
        String query = "select * from Customers where Username = ?";

        try {
            stm = con.prepareStatement(query);
            stm.setString(1, user);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Customers(rs.getInt("CustomerID"),
                        rs.getString("FullName"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getString("Image"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Address"));
            }
        } catch (Exception E) {
        }
        return null;
    }

    public void updateCustomer(Customers c) {
        try {
            String sql = "update Customers\n"
                    + "set FullName = ?, Username = ?, Password = ? , Address = ?\n"
                    + "where CustomerID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, c.getFullName());
            statement.setString(2, c.getUsername());
            statement.setString(3, c.getPassword());
            statement.setString(4, c.getAddress());
            statement.setInt(5, c.getCustomerId());
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Customers> getAllCustomers() {
        List<Customers> listCustomers = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Customers]";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Customers customer = new Customers();
                customer.setCustomerId(rs.getInt("CustomerID"));
                customer.setFullName(rs.getString("FullName"));
                customer.setPhone(rs.getString("Phone"));
                customer.setEmail(rs.getString("Email"));
                customer.setImage(rs.getString("Image"));
                customer.setUsername(rs.getString("Username"));
                customer.setPassword(rs.getString("Password"));
                customer.setAddress(rs.getString("Address"));
                listCustomers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return listCustomers;
    }

    public Customers SearchByID(int customersID) {
        String sql = "SELECT *  FROM [dbo].[Customers] WHERE CustomerID = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, customersID);
            rs = stm.executeQuery();
            if (rs.next()) {
                Customers foundCustomers = new Customers();
                foundCustomers.setCustomerId(rs.getInt("CustomerID"));
                foundCustomers.setFullName(rs.getString("FullName"));
                foundCustomers.setPhone(rs.getString("Phone"));
                foundCustomers.setEmail(rs.getString("Email"));
                foundCustomers.setImage(rs.getString("Image"));
                foundCustomers.setUsername(rs.getString("Username"));
                foundCustomers.setPassword(rs.getString("Password"));
                foundCustomers.setAddress(rs.getString("Address"));
                return foundCustomers;
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }

    public Customers SearchByName(String fullName) {
        String sql = "SELECT *  FROM [dbo].[Customers] WHERE FullName = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, fullName);
            rs = stm.executeQuery();
            if (rs.next()) {
                Customers foundCustomers = new Customers();
                foundCustomers.setCustomerId(rs.getInt("CustomerID"));
                foundCustomers.setFullName(rs.getString("FullName"));
                foundCustomers.setPhone(rs.getString("Phone"));
                foundCustomers.setEmail(rs.getString("Email"));
                foundCustomers.setImage(rs.getString("Image"));
                foundCustomers.setUsername(rs.getString("Username"));
                foundCustomers.setPassword(rs.getString("Password"));
                foundCustomers.setAddress(rs.getString("Address"));
                return foundCustomers;
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }

    public int insertCustomers(Customers customer) {
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "([FullName],[Phone],[Email],[Image],[Username],[Password],[Address])\n"
                + "VALUES (? ,?,?,?,?,?,?)";
        try {
            stm = con.prepareStatement(sql, stm.RETURN_GENERATED_KEYS);
            stm.setString(1, customer.getFullName());
            stm.setString(2, customer.getPhone());
            stm.setString(3, customer.getEmail());
            stm.setString(4, customer.getImage());
            stm.setString(5, customer.getUsername());
            stm.setString(6, customer.getPassword());
            stm.setString(7, customer.getAddress());
            stm.executeUpdate();
            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Trả về giá trị của khóa chính tự tăng
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return 0;
    }

    public static void main(String[] args) {
        CustomersDAO customersDAO = new CustomersDAO();
//        List<Customers> listCustomers = customersDAO.getAllCustomers();
        Customers foundCustomers = customersDAO.SearchByName("Lai Tuan Hai");
//        int x = customersDAO.insertCustomers(new Customers(0, "aa", "032", "HH", null, null, null, "vlHH"));
        System.out.println(foundCustomers.getCustomerId());

//        System.out.println(foundCustomers.getFullName());
    }
}
