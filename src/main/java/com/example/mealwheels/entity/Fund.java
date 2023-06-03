package com.example.mealwheels.entity;

import javax.persistence.*;

@Entity
public class Fund {

    @Id
    @GeneratedValue
    private long id;

    private double amount;

    private String document;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Fund(long id, double amount, String document, User user) {
        this.id = id;
        this.amount = amount;
        this.document = document;
        this.user = user;
    }

    public Fund(double amount, String document, User user) {
        this.amount = amount;
        this.document = document;
        this.user = user;
    }

    public Fund() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
