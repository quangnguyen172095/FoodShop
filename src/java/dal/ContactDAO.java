package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Contact;

public class ContactDAO extends DBContext {

    public void InsertContact(Contact contact) {
        String sql = "INSERT INTO [dbo].[ContactInformation]\n"
                + "           ([FullName]\n"
                + "           ,[Email]\n"
                + "           ,[Phone]\n"
                + "           ,[Message]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, contact.getFullName());
            st.setString(2, contact.getEmail());
            st.setString(3, contact.getPhone());
            st.setString(4, contact.getMessage());
            st.setString(5, contact.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Contact> GetAllContactInformation() {
        List<Contact> list = new ArrayList<>();
        String sql = "SELECT [ContactID]\n"
                + "      ,[FullName]\n"
                + "      ,[Email]\n"
                + "      ,[Phone]\n"
                + "      ,[Message]\n"
                + "      ,[CreatedAt]\n"
                + "      ,[Status]\n"
                + "  FROM [dbo].[ContactInformation]";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setContactID(rs.getInt("ContactID"));
                contact.setFullName(rs.getString("FullName"));
                contact.setEmail(rs.getString("Email"));
                contact.setPhone(rs.getString("Phone"));
                contact.setMessage(rs.getString("Message"));
                contact.setCreatedAt(LocalDateTime.MAX);
                contact.setStatus(rs.getString("Status"));
                list.add(contact);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void DeleteAllContact() {
        String sql = "DELETE FROM [dbo].[ContactInformation]";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void DeleteContact(int contactId) {
        String sql = "DELETE FROM [dbo].[ContactInformation]\n"
                + "      WHERE ContactID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, contactId);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
