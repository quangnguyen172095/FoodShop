package model;

import java.time.LocalDateTime;

public class Contact {

    private int contactID;
    private String fullName;
    private String email;
    private String phone;
    private String message;
    private LocalDateTime createdAt;
    private String status;

    public Contact() {
    }

    public Contact(int contactID, String fullName, String email, String phone, String message, LocalDateTime createdAt, String status) {
        this.contactID = contactID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.createdAt = createdAt;
        this.status = status;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
