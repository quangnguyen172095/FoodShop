package model;

import java.sql.Date;

public class Review {

    private int reviewId;
    private Customer customer;
    private Products product;
    private String title;
    private String description;
    int rate;
    private Date reviewDate;

    public Review() {
    }

    public Review(int reviewId, Customer customer, Products product, String title, String description, int rate, Date reviewDate) {
        this.reviewId = reviewId;
        this.customer = customer;
        this.product = product;
        this.title = title;
        this.description = description;
        this.rate = rate;
        this.reviewDate = reviewDate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Products getProduct() {
        return product;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRate() {
        return rate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

}
