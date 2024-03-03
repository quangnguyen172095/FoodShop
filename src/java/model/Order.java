/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DAOCustomer;
import dal.DAOProducts;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class Order {

    private int OrderID;
    private int CustomerID;
    private String OrderStatus;
    private Date OrderDate;
    private String PaymentMethod;
    private String ShippingAddress;
    private float Freight;
    private int CreatedBy;
    private Date CreatedOn;
    private String TransactionStatus;
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order(int CustomerID, String OrderStatus, Date OrderDate, String PaymentMethod, String ShippingAddress, float Freight, String TransactionStatus) {
        this.CustomerID = CustomerID;
        this.OrderStatus = OrderStatus;
        this.OrderDate = OrderDate;
        this.PaymentMethod = PaymentMethod;
        this.ShippingAddress = ShippingAddress;
        this.Freight = Freight;
        this.TransactionStatus = TransactionStatus;
    }

    public Order(int OrderID, int CustomerID, String OrderStatus, Date OrderDate, String PaymentMethod, String ShippingAddress, float Freight, String TransactionStatus, List<OrderDetail> orderDetails) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OrderStatus = OrderStatus;
        this.OrderDate = OrderDate;
        this.PaymentMethod = PaymentMethod;
        this.ShippingAddress = ShippingAddress;
        this.Freight = Freight;
        this.TransactionStatus = TransactionStatus;
        this.orderDetails = orderDetails;
    }

    public Order(int OrderID, int CustomerID, String OrderStatus, Date OrderDate, String PaymentMethod, String ShippingAddress, float Freight, int CreatedBy, Date CreatedOn, String TransactionStatus) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OrderStatus = OrderStatus;
        this.OrderDate = OrderDate;
        this.PaymentMethod = PaymentMethod;
        this.ShippingAddress = ShippingAddress;
        this.Freight = Freight;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.TransactionStatus = TransactionStatus;
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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order() {
        this.orderDetails = new ArrayList<>();
    }

    public Order(int OrderID, int CustomerID, String OrderStatus, Date OrderDate, String PaymentMethod, String ShippingAddress, float Freight, String TransactionStatus) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OrderStatus = OrderStatus;
        this.OrderDate = OrderDate;
        this.PaymentMethod = PaymentMethod;
        this.ShippingAddress = ShippingAddress;
        this.Freight = Freight;
        this.TransactionStatus = TransactionStatus;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String ShippingAddress) {
        this.ShippingAddress = ShippingAddress;
    }

    public float getFreight() {
        return Freight;
    }

    public void setFreight(float Freight) {
        this.Freight = Freight;
    }

    public String getTransactionStatus() {
        return TransactionStatus;
    }

    public void setTransactionStatus(String TransactionStatus) {
        this.TransactionStatus = TransactionStatus;
    }

    private Product getProductById(int productId) {
        DAOProducts dao = new DAOProducts();
        return dao.findById(productId);
    }

    public float getTotalPrice() {
        float total = 0;
        for (OrderDetail od : orderDetails) {
            Product product = getProductById(od.getProductID());
            if (product != null) {
                total += od.getQuantity() * (product.getPrice() - product.getPrice() * product.getDiscount());
            }
        }
        return total;
    }

    public void addItems(Product product) {
        for (OrderDetail od : orderDetails) {
            if (od.getProductID() == product.getProductID()) {
                od.setQuantity(od.getQuantity() + 1);
                return;
            }
        }
        this.orderDetails.add(new OrderDetail(product.getProductID(), product.getProductName(), product.getPrice(), product.getImage(), product.getDiscount()));
    }

    public void removeItem(int productId) {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i).getProductID() == productId) {
                orderDetails.remove(i);
                return;
            }
        }
    }

    public void updateItem(int productId, int quantity) {
        if (quantity == 0) {
            removeItem(productId);
        } else {
            for (int i = 0; i < orderDetails.size(); i++) {
                if (orderDetails.get(i).getProductID() == productId) {
                    orderDetails.get(i).setQuantity(quantity);
                    return;
                }
            }
        }
    }

    public float getItemPrice(int productId) {
        float price = 0;
        for (OrderDetail od : orderDetails) {
            if (od.getProductID() == productId) {
                price = od.getQuantity() * od.getPrice();
                break;
            }
        }
        return price; // Trả về 0 nếu không tìm thấy sản phẩm
    }

}
