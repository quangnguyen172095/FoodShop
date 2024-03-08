package model;

import java.sql.Date;

public class News {

    private int newsId;
    private NewsGroup newsGroup;
    private String title;
    private String content;
    private String image;
    private int createdBy;
    private Date createdOn;
    private int modifiedBy;
    private Date modifiedOn;

    public News() {
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
