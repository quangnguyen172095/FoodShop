package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Categories;
import model.News;
import model.NewsGroup;
import model.Product;

public class NewsDAO extends DBContext {

    public ArrayList<News> getNewsByNewsGroupId(int id) {
        ArrayList<News> searchList = new ArrayList<>();

        try {
            String sql = "select n.NewsID, n.Title, n.Content, n.Image, n.Author,ng.NewsGroupName, ng.NewsGroupID\n"
                    + "from news n inner join NewsGroups ng\n"
                    + "on n.NewsGroupID = ng.NewsGroupID\n"
                    + "where ng.newsgroupid = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                News n = new News();
                n.setNewsId(rs.getInt("NewsID"));
                n.setTitle(rs.getString("Title"));
                n.setContent(rs.getString("Content"));
                n.setImage(rs.getString("Image"));
                n.setAuthor(rs.getString("Author"));

                NewsGroup ng = new NewsGroup();
                ng.setNewsGroupName(rs.getString("NewsGroupName"));
                ng.setNewsGroupId(rs.getInt("NewsGroupID"));

                n.setNewsGroup(ng);
                
                searchList.add(n);


            }
        } catch (Exception e) {
        }

        return searchList;
    }

    public ArrayList<model.News> getNews() {
        ArrayList<model.News> news = new ArrayList<>();

        try {
            String sql = "select n.NewsID, n.Title, n.Content, n.Image, n.Author, ng.NewsGroupName\n"
                    + "from news n inner join NewsGroups ng\n"
                    + "on n.NewsGroupID = ng.NewsGroupID";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                News n = new News();
                n.setNewsId(rs.getInt("NewsID"));
                n.setTitle(rs.getString("Title"));
                n.setContent(rs.getString("Content"));
                n.setImage(rs.getString("Image"));
                n.setAuthor(rs.getString("Author"));

                NewsGroup ng = new NewsGroup();
                ng.setNewsGroupName(rs.getString("NewsGroupName"));

                n.setNewsGroup(ng);
                news.add(n);
            }
        } catch (Exception e) {
        }

        return news;
    }

    public static void main(String[] args) {
        NewsDAO dao = new NewsDAO();
        for (News n : dao.getNews()) {
            System.out.println(n.getTitle());
        }
//        DAOProducts pro_dao = new DAOProducts();
//        Product pro = pro_dao.findById(1);
//        System.out.println(pro);
    }
}
