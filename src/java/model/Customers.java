/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Customers {

    private int customerID;
    private String fullName;
    private String phone;
    private String email;
    private String image;
    private String username;
    private String password;
    private String address;

    public Customers() {
    }

    public Customers(int customerId, String fullName, String phone, String email, String image, String username, String password, String address) {
        this.customerID = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" + "customerID=" + customerID + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email + ", image=" + image + ", username=" + username + ", password=" + password + ", address=" + address + '}';
    }

}
