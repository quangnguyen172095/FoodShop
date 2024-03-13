package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NewsGroup;

public class NewsGroupDAO extends DBContext {
    public ArrayList<NewsGroup> getNewsGroup(){
        ArrayList<NewsGroup> newsgroups = new ArrayList<>();

        try {
            String sql = "select * from NewsGroups";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NewsGroup ng = new NewsGroup();
                ng.setNewsGroupId(rs.getInt("NewsGroupID"));
                ng.setNewsGroupName(rs.getString("NewsGroupName"));
                ng.setCreatedBy(rs.getInt("CreatedBy"));
                ng.setCreatedOn(rs.getDate("CreatedOn"));
                ng.setModifiedBy(rs.getInt("ModifiedBy"));
                ng.setModifiedOn(rs.getDate("ModifiedOn"));
                newsgroups.add(ng);

            }
        } catch (Exception e) {
        }

        return newsgroups   ;
    } 
}
