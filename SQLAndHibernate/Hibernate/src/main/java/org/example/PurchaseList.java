package org.example;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @Id
    @Column(name = "student_name")
    private String student;
    @Column(name = "course_name")
    private String course;

    private int price;
    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
