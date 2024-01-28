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
public class Products {
    private int ProductID;
    private int CategoryID;
    private String ProductName;
    private String Image;
    private String Description;
    private float Price;
    private int Quantity;
    private String Status;
    private float Discount;
    private int CreatedBy;
    private Date CreatedOn;
    private int ModifiedBy;
    private Date ModifiedOn;
    private Categories categories;
    private Admin createdAdminInfo;
    private Admin modifiedAdminInfo;

    public Products() {
    }
    
    

    public Products(int ProductID, int CategoryID, String ProductName, String Image, String Description, float Price, int Quantity, String Status, float Discount, int CreatedBy, Date CreatedOn, int ModifiedBy, Date ModifiedOn, Categories categories) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.ProductName = ProductName;
        this.Image = Image;
        this.Description = Description;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Status = Status;
        this.Discount = Discount;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.ModifiedBy = ModifiedBy;
        this.ModifiedOn = ModifiedOn;
        this.categories = categories;
    }

    public Products(int ProductID, int CategoryID, String ProductName, String Image, String Description, float Price, int Quantity, String Status, float Discount, int CreatedBy, Date CreatedOn, int ModifiedBy, Date ModifiedOn, Categories categories, Admin createdAdminInfo, Admin modifiedAdminInfo) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.ProductName = ProductName;
        this.Image = Image;
        this.Description = Description;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Status = Status;
        this.Discount = Discount;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.ModifiedBy = ModifiedBy;
        this.ModifiedOn = ModifiedOn;
        this.categories = categories;
        this.createdAdminInfo = createdAdminInfo;
        this.modifiedAdminInfo = modifiedAdminInfo;
    }

    public Admin getCreatedAdminInfo() {
        return createdAdminInfo;
    }

    public void setCreatedAdminInfo(Admin createdAdminInfo) {
        this.createdAdminInfo = createdAdminInfo;
    }

    public Admin getModifiedAdminInfo() {
        return modifiedAdminInfo;
    }

    public void setModifiedAdminInfo(Admin modifiedAdminInfo) {
        this.modifiedAdminInfo = modifiedAdminInfo;
    }
    
    
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public float getDiscount() {
        return Discount;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }
    
    

    public Products(int ProductID, int CategoryID, String ProductName, String Image, String Description, float Price, int Quantity, int CreatedBy, Date CreatedOn, int ModifiedBy, Date ModifiedOn) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.ProductName = ProductName;
        this.Image = Image;
        this.Description = Description;
        this.Price = Price;
        this.Quantity = Quantity;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.ModifiedBy = ModifiedBy;
        this.ModifiedOn = ModifiedOn;
    }

    public Products(int ProductID, int CategoryID, String ProductName, String Image, String Description, float Price, int Quantity, int CreatedBy, Date CreatedOn, int ModifiedBy, Date ModifiedOn, Categories categories) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.ProductName = ProductName;
        this.Image = Image;
        this.Description = Description;
        this.Price = Price;
        this.Quantity = Quantity;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.ModifiedBy = ModifiedBy;
        this.ModifiedOn = ModifiedOn;
        this.categories = categories;
    }
    
    

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
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

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Products{" + "ProductID=" + ProductID + ", CategoryID=" + CategoryID + ", ProductName=" + ProductName + ", Image=" + Image + ", Description=" + Description + ", Price=" + Price + ", Quantity=" + Quantity + ", CreatedBy=" + CreatedBy + ", CreatedOn=" + CreatedOn + ", ModifiedBy=" + ModifiedBy + ", ModifiedOn=" + ModifiedOn + ", categories=" + categories + '}';
    }
    
    
}
