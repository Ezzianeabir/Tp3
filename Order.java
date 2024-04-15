package org.example;

public class Order {
    private long orderId;
    private String customerName;


    public Order(long orderId, String customerName ) {
        this.orderId = orderId;
        this.customerName = customerName;

    }

    // Getters et setters pour les attributs de la commande

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
