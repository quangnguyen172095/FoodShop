package model;

import java.sql.Date;

public class NewsGroup {

    private int newsGroupId;
    private String newsGroupName;
    private int createdBy;
    private Date createdOn;
    private int modifiedBy;
    private Date modifiedOn;

    public NewsGroup() {
    }

    public NewsGroup(int newsGroupId, String newsGroupName, int createdBy, Date createdOn, int modifiedBy, Date modifiedOn) {
        this.newsGroupId = newsGroupId;
        this.newsGroupName = newsGroupName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
    }

    public int getNewsGroupId() {
        return newsGroupId;
    }

    public String getNewsGroupName() {
        return newsGroupName;
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

    public void setNewsGroupId(int newsGroupId) {
        this.newsGroupId = newsGroupId;
    }

    public void setNewsGroupName(String newsGroupName) {
        this.newsGroupName = newsGroupName;
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
