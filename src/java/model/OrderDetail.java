/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class OrderDetail {

    private int OrderID;
    private int ProductID;
    private int Quantity = 1;
    private String ProductName;
    private float price;
    private String image;
    private Order orders;
    private Products products;
    private float getTotalPrice;
    private float discount;

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    
    public OrderDetail(Order orders, Products products, int quantity) {
        this.orders = orders;
        this.products = products;
        this.Quantity = quantity;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public OrderDetail() {
    }

    public OrderDetail(int ProductID, String ProductName, float price) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.price = price;
    }

    public OrderDetail(int ProductID, String ProductName, float price, String image, float discount) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.price = price;
        this.image = image;
        this.discount = discount;
    }

    public OrderDetail(int OrderID, int ProductID, int Quantity, String ProductName, float price) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.ProductName = ProductName;
        this.price = price;
    }

    public OrderDetail(int OrderID, int ProductID, int Quantity) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;

    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
    
    public float getTotalPrice() {
        return getQuantity()*getPrice();
    }

    

}
