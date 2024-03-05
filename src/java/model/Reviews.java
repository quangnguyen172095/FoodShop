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
public class Reviews {

    private int reviewID;
    private Customers customers;
    private Products products;
    private String title;
    private String description;
    private int rate;
    private Timestamp reviewDate;

    public Reviews() {
    }

    public Reviews(int reviewID, Customers customers, Products products, String title, String description,
            int rate, Timestamp reviewDate) {
        this.reviewID = reviewID;
        this.customers = customers;
        this.products = products;
        this.title = title;
        this.description = description;
        this.rate = rate;
        this.reviewDate = reviewDate;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Reviews{" + "reviewID=" + reviewID + ", customers=" + customers + ", products=" + products + ", title=" + title + ", description=" + description + ", rate=" + rate + ", reviewDate=" + reviewDate + '}';
    }

}
