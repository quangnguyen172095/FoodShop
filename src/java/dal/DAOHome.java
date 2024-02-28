/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Categories;
import model.HeaderHome;
import model.Products;

/**
 *
 * @author PC
 */
public class DAOHome extends DBContext {
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
        for (HeaderHome pro : dao.getHeader()) {
            System.out.println(pro.getLink());
        }
    }
}
