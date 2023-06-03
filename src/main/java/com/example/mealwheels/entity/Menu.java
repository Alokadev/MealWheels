package com.example.mealwheels.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private long id;

    private String meal1;

    private String meal2;

    private String meal3;

    private boolean frozen;

    private Timestamp planDate;

    @ManyToOne
    @JoinColumn(name = "partner_id", nullable = false)
    private User user;

    private Timestamp prepareDate;

   private boolean safety;

    public Menu(long id, String meal1, String meal2, String meal3, boolean frozen, Timestamp planDate, User user, Timestamp prepareDate, boolean safety) {
        this.id = id;
        this.meal1 = meal1;
        this.meal2 = meal2;
        this.meal3 = meal3;
        this.frozen = frozen;
        this.planDate = planDate;
        this.user = user;
        this.prepareDate = prepareDate;
        this.safety = safety;
    }

    public Menu(String meal1, String meal2, String meal3, boolean frozen, Timestamp planDate, User user, Timestamp prepareDate, boolean safety) {
        this.meal1 = meal1;
        this.meal2 = meal2;
        this.meal3 = meal3;
        this.frozen = frozen;
        this.planDate = planDate;
        this.user = user;
        this.prepareDate = prepareDate;
        this.safety = safety;
    }

    public Menu() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMeal1() {
        return meal1;
    }

    public void setMeal1(String meal1) {
        this.meal1 = meal1;
    }

    public String getMeal2() {
        return meal2;
    }

    public void setMeal2(String meal2) {
        this.meal2 = meal2;
    }

    public String getMeal3() {
        return meal3;
    }

    public void setMeal3(String meal3) {
        this.meal3 = meal3;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public Timestamp getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Timestamp planDate) {
        this.planDate = planDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getPrepareDate() {
        return prepareDate;
    }

    public void setPrepareDate(Timestamp prepareDate) {
        this.prepareDate = prepareDate;
    }

    public boolean isSafety() {
        return safety;
    }

    public void setSafety(boolean safety) {
        this.safety = safety;
    }
}
