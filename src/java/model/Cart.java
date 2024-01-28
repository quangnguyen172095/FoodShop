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
public class Cart {

    private Customer customers;
    private Products products;
    private int quantity;
    private Timestamp confirmedOn;

    public Cart() {
    }

    public Cart(Customer customers, Products products, int quantity, Timestamp confirmedOn) {
        this.customers = customers;
        this.products = products;
        this.quantity = quantity;
        this.confirmedOn = confirmedOn;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getConfirmedOn() {
        return confirmedOn;
    }

    public void setConfirmedOn(Timestamp confirmedOn) {
        this.confirmedOn = confirmedOn;
    }

    @Override
    public String toString() {
        return "Cart{" + "customers=" + customers + ", products=" + products + ", quantity=" + quantity + ", confirmedOn=" + confirmedOn + '}';
    }

}
