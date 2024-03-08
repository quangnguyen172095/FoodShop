package model;

import java.sql.Date;

public class Review {

    private int reviewId;
    private Customers customer;
    private Product product;
    private String title;
    private String description;
    int rate;
    private Date reviewDate;

    public Review() {
    }

    public Review(int reviewId, Customers customer, Product product, String title, String description, int rate, Date reviewDate) {
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

    public Customers getCustomer() {
        return customer;
    }

    public Product getProduct() {
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

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
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
