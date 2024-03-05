/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author acer
 */
public class News {

    private int newsID;
    private NewsGroups newsGroups;
    private String title;
    private String content;
    private String image;
    private String author;
    private Admin createdBy;
    private Timestamp createdOn;
    private Admin modifiedBy;
    private Timestamp modifiedOn;

    public News() {
    }

    public News(int newsID, NewsGroups newsGroupID, String title, String content, String image, 
            String author, Admin createdBy, Timestamp createdOn, Admin modifiedBy, Timestamp modifiedOn) {
        this.newsID = newsID;
        this.newsGroups = newsGroupID;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Admin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Admin createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Admin getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Admin modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public NewsGroups getNewsGroups() {
        return newsGroups;
    }

    public void setNewsGroups(NewsGroups newsGroups) {
        this.newsGroups = newsGroups;
    }

    @Override
    public String toString() {
        return "News{" + "newsID=" + newsID + ", newsGroups=" + newsGroups + ", title=" + title + ", content=" + content + ", image=" + image + ", author=" + author + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + '}';
    }

    
}
