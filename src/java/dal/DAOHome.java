/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Admin;
import model.Categories;
import model.ContentHome;
import model.HeaderHome;
import model.Products;

/**
 *
 * @author PC
 */
public class DAOHome extends DBContext {

    public ArrayList<Admin> getChef() {
        ArrayList<Admin> admins = new ArrayList<>();

        try {
            String sql = "select * from admin\n"
                    + "where role = N'Đầu bếp'";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Admin a = new Admin();
                a.setFullName(rs.getString("FullName"));
                a.setRole(rs.getString("Role"));
                a.setImage(rs.getString("Image"));
                a.setAdminId(rs.getInt("AdminID"));
                a.setUsername(rs.getString("Username")); 
                a.setPassword(rs.getString("Password"));
                a.setEmail(rs.getString("Email"));
                a.setPhone(rs.getString("Phone"));
                a.setJoinedDate(rs.getDate("JoinedDate"));
                a.setAddress(rs.getString("Address"));
                a.setDepartment(rs.getString("Department"));
                admins.add(a);

            }
        } catch (Exception e) {
        }

        return admins;
    }

    public ContentHome getContentById(int contentId) {
        String sql = "select * from ContentHome\n"
                + "where id = ?";
        DBContext db = new DBContext();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, contentId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ContentHome c = new ContentHome();
                c.setId(rs.getInt("id"));
                c.setButtonText(rs.getString("buttonText"));
                c.setIntroduce(rs.getString("introduce"));
                c.setDescriptionIntro(rs.getString("descriptionIntro"));
                c.setImage(rs.getString("image"));
                return c;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<ContentHome> getContent() {
        ArrayList<ContentHome> contents = new ArrayList<>();

        try {
            String sql = "select top 3 * from ContentHome";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ContentHome c = new ContentHome();
                c.setId(rs.getInt("id"));
                c.setButtonText(rs.getString("buttonText"));
                c.setIntroduce(rs.getString("introduce"));
                c.setDescriptionIntro(rs.getString("descriptionIntro"));
                c.setImage(rs.getString("image"));
                contents.add(c);

            }
        } catch (Exception e) {
        }

        return contents;
    }

    public ArrayList<HeaderHome> getHeader() {
        ArrayList<HeaderHome> hh = new ArrayList<>();

        try {
            String sql = "select * from headerhome";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HeaderHome h = new HeaderHome();
                h.setId(rs.getInt("id"));
                h.setTitle(rs.getString("title"));
                h.setLink(rs.getString("link"));
                hh.add(h);

            }
        } catch (Exception e) {
        }

        return hh;
    }

    public static void main(String[] args) {
        DAOHome dao = new DAOHome();
        for (Admin pro : dao.getChef()) {
            System.out.println(pro.getFullName());
        }
    }
}
