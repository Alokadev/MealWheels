package com.example.mealwheels.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders") // Specify a different table name
public class Order {

    @Id
    @GeneratedValue
    private long id;

    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "rider_id")
    private User rider;

    public Order(long id, Timestamp date, User user, User rider) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.rider = rider;
    }

    public Order(Timestamp date, User user, User rider) {
        this.date = date;
        this.user = user;
        this.rider = rider;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRider() {
        return rider;
    }

    public void setRider(User rider) {
        this.rider = rider;
    }
}
