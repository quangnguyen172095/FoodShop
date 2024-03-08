/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Categories {
    private int CategoryID;
    private String CategoryName;
    private int CreatedBy;
    private Date CreatedOn;
    private int ModifiedBy;
    private Date ModifiedOn;

    public Categories(int CategoryID, String CategoryName, int CreatedBy, Date CreatedOn, int ModifiedBy, Date ModifiedOn) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.ModifiedBy = ModifiedBy;
        this.ModifiedOn = ModifiedOn;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(int CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Date CreatedOn) {
        this.CreatedOn = CreatedOn;
    }

    public int getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(int ModifiedBy) {
        this.ModifiedBy = ModifiedBy;
    }

    public Date getModifiedOn() {
        return ModifiedOn;
    }

    public void setModifiedOn(Date ModifiedOn) {
        this.ModifiedOn = ModifiedOn;
    }
    
    

    public Categories() {
    }

    public Categories(int CategoryID, String CategoryName) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    
    
    
}
