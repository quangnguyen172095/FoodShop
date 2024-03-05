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
public class NewsGroups {

    private int newsGroupID;
    private String newsGroupName;
    private Admin createdBy;
    private Timestamp createdOn;
    private Admin modifiedBy;
    private Timestamp modifiedOn;

    public NewsGroups() {
    }

    public NewsGroups(int newsGroupID, String newsGroupName, Admin createdBy, Timestamp createdOn, Admin modifiedBy, Timestamp modifiedOn) {
        this.newsGroupID = newsGroupID;
        this.newsGroupName = newsGroupName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
    }

    public int getNewsGroupID() {
        return newsGroupID;
    }

    public void setNewsGroupID(int newsGroupID) {
        this.newsGroupID = newsGroupID;
    }

    public String getNewsGroupName() {
        return newsGroupName;
    }

    public void setNewsGroupName(String newsGroupName) {
        this.newsGroupName = newsGroupName;
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

    @Override
    public String toString() {
        return "NewsGroups{" + "newsGroupID=" + newsGroupID + ", newsGroupName=" + newsGroupName + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + '}';
    }

}
