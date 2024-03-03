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
 * @author PC
 */
public class DAOCustomer extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public Customers checkCustomerExist(String user) {
        String query = "select * from Customers where Username = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
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

    public void UpDatePassWordCustomer(String pass, String user) {

        try {
            String sql = "UPDATE Customers\n"
                    + "   SET [Password] = ?\n"
                    + " WHERE [Username] = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, pass);
            stm.setString(2, user);
            stm.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public Customers login(String username, String password) throws SQLException {
        String sql = "select * from Customers\n"
                + "where Username = ? and Password = ?";

        if (con != null) {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customers(rs.getInt("CustomerID"),
                        rs.getString("FullName"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getString("Image"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Address"));

            }
        }
        return null;
    }

    public Customers getById(Integer userId) throws SQLException {
        String sql = "select * from Customers where CustomerID = ?";

        if (con != null) {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customers(rs.getInt("CustomerID"),
                        rs.getString("Fullname"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getString("Department"));
            }
        }
        return null;
    }

    public Customers updateCusAccount(Customers account) throws SQLException {
        String sql = "UPDATE Customers\n"
                + "SET\n"
                + "    Username = ?,\n"
                + "    Password = ?,\n"
                + "    Email = ?,\n"
                + "    FullName = ?,\n"
                + "    Phone = ?,\n"
                + "    Address = ?,\n"
                + "    Department = ?\n"
                + "WHERE\n"
                + "    CustomerID = ?;";

        if (con != null) {
            ps = con.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getFullName());
            ps.setString(7, account.getPhone());
            ps.setString(8, account.getAddress());
            ps.setInt(10, account.getCustomerId());
            if (ps.executeUpdate() > 0) {
                return getById(account.getCustomerId());
            }
        }
        return null;
    }

    public void InsertCustomer(Customers customer) {
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "                                ([FullName]\n"
                + "                                ,[Phone]\n"
                + "                                ,[Email]\n"
                + "                                ,[Image]\n"
                + "                                ,[Username]\n"
                + "                                ,[Password]\n"
                + "                                ,[Address])\n"
                + "                          VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, customer.getFullName());
            st.setString(2, customer.getPhone());
            st.setString(3, customer.getEmail());
            st.setString(4, customer.getImage());
            st.setString(5, customer.getUsername());
            st.setString(6, customer.getPassword());
            st.setString(7, customer.getAddress());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void DeleteCustomer(int customerId) {
        String sql = "DELETE FROM [dbo].[Customers]\n"
                + "                          WHERE CustomerID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, customerId);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public int getTotalCustomer() {
        String sql = "select count(*) from Customers";
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

    public List<Customers> pagingCustomer(int index) {
        List<Customers> list = new ArrayList<>();
        String sql = "SELECT * FROM Customers\n"
                + "                       ORDER BY CustomerID\n"
                + "                       OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customers customer = new Customers();
                customer.setCustomerId(rs.getInt("CustomerID"));
                customer.setFullName(rs.getString("Fullname"));
                customer.setPhone(rs.getString("Phone"));
                customer.setEmail(rs.getString("Email"));
                customer.setImage(rs.getString("Image"));
                customer.setUsername(rs.getString("Username"));
                customer.setPassword(rs.getString("Password"));
                customer.setAddress(rs.getString("Address"));
                list.add(customer);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Customers GetCustomerById(int customerId) {
        String sql = "SELECT [CustomerID]\n"
                + "                          ,[FullName]\n"
                + "                          ,[Phone]\n"
                + "                          ,[Email]\n"
                + "                          ,[Image]\n"
                + "                          ,[Username]\n"
                + "                          ,[Password]\n"
                + "                          ,[Address]\n"
                + "                      FROM [dbo].[Customers]\n"
                + "                      WHERE CustomerID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, customerId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customers customer = new Customers();
                customer.setCustomerId(rs.getInt("CustomerID"));
                customer.setFullName(rs.getString("Fullname"));
                customer.setPhone(rs.getString("Phone"));
                customer.setEmail(rs.getString("Email"));
                customer.setImage(rs.getString("Image"));
                customer.setUsername(rs.getString("Username"));
                customer.setPassword(rs.getString("Password"));
                customer.setAddress(rs.getString("Address"));
                return customer;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void UpdateCustomer(Customers customer) {
        String sql = "UPDATE [dbo].[Customers]\n"
                + "                                            SET [FullName] = ?\n"
                + "                                               ,[Phone] = ?\n"
                + "                                               ,[Email] = ?\n"
                + "                                               ,[Image] = ?\n"
                + "                                               ,[Username] = ?\n"
                + "                                               ,[Password] = ?\n"
                + "                                               ,[Address] = ?\n"
                + "                                          WHERE CustomerID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, customer.getFullName());
            st.setString(2, customer.getPhone());
            st.setString(3, customer.getEmail());
            st.setString(4, customer.getImage());
            st.setString(5, customer.getUsername());
            st.setString(6, customer.getPassword());
            st.setString(7, customer.getAddress());
            st.setInt(8, customer.getCustomerId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Customers SearchByID(int customersID) {
        String sql = "SELECT *  FROM [dbo].[Customers] WHERE CustomerID = ?";
        PreparedStatement stm;
        ResultSet rs;
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
}
