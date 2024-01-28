package model;

import java.sql.Date;

public class Admin {

    private int adminId;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
    private String image;
    private Date joinedDate;
    private String address;
    private String department;

    public Admin() {
    }

    public Admin(int adminId, String fullName, String username, String password, String email, String phone, String role, String image, Date joinedDate, String address, String department) {
        this.adminId = adminId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.image = image;
        this.joinedDate = joinedDate;
        this.address = address;
        this.department = department;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getImage() {
        return image;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
