package com.example.mealwheels.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class CareRequest {

    @Id
    @GeneratedValue
    private long id;

    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "care_id")
    private User care;

    public CareRequest(long id, Timestamp date, User user, User care) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.care = care;
    }

    public CareRequest(Timestamp date, User user, User care) {
        this.date = date;
        this.user = user;
        this.care = care;
    }

    public CareRequest() {
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

    public User getCare() {
        return care;
    }

    public void setCare(User care) {
        this.care = care;
    }
}
