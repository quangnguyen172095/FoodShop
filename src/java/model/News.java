package model;

import java.sql.Date;

public class News {

    private int newsId;
    private NewsGroup newsGroup;
    private String title;
    private String content;
    private String image;
    private String author;
    private int createdBy;
    private Date createdOn;
    private int modifiedBy;
    private Date modifiedOn;
    private String body1;
    private String body2;
    private String img2;
    private String body3;

    public News(int newsId, NewsGroup newsGroup, String title, String content, String image, String author, int createdBy, Date createdOn, int modifiedBy, Date modifiedOn, String body1, String body2, String img2, String body3) {
        this.newsId = newsId;
        this.newsGroup = newsGroup;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
        this.body1 = body1;
        this.body2 = body2;
        this.img2 = img2;
        this.body3 = body3;
    }

    public String getBody1() {
        return body1;
    }

    public void setBody1(String body1) {
        this.body1 = body1;
    }

    public String getBody2() {
        return body2;
    }

    public void setBody2(String body2) {
        this.body2 = body2;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getBody3() {
        return body3;
    }

    public void setBody3(String body3) {
        this.body3 = body3;
    }
    
    

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public News() {
    }

    public News(int newsId, NewsGroup newsGroup, String title, String content, String image, String author) {
        this.newsId = newsId;
        this.newsGroup = newsGroup;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
    }
    

    public News(int newsId, NewsGroup newsGroup, String title, String content, String image, int createdBy, Date createdOn, int modifiedBy, Date modifiedOn) {
        this.newsId = newsId;
        this.newsGroup = newsGroup;
        this.title = title;
        this.content = content;
        this.image = image;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
    }

    public int getNewsId() {
        return newsId;
    }

    public NewsGroup getNewsGroup() {
        return newsGroup;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public void setNewsGroup(NewsGroup newsGroup) {
        this.newsGroup = newsGroup;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

}
