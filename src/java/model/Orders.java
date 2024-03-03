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
public class Orders {

    private int orderID;
    private Customers customers;
    private String orderStatus;
    private Timestamp orderDate;
    private String paymentMethod;
    private String shippingAddress;
    private double freight;
    private Admin createdBy;
    private Timestamp createdOn;
    private String transactionStatus;

    public Orders() {
    }

    public Orders(int orderID, Customers customers, String orderStatus, Timestamp orderDate, String paymentMethod, 
            String shippingAddress, double freight, Admin createdBy, Timestamp createdOn, String transactionStatus) {
        this.orderID = orderID;
        this.customers = customers;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
        this.freight = freight;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.transactionStatus = transactionStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
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

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", customers=" + customers + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", paymentMethod=" + paymentMethod + ", shippingAddress=" + shippingAddress + ", freight=" + freight + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", transactionStatus=" + transactionStatus + '}';
    }

}
