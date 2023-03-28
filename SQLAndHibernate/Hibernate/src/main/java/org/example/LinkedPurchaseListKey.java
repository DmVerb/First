package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LinkedPurchaseListKey implements Serializable {

    @Column(name = "course_id",insertable = false,updatable = false)
    private Integer courseIdLinked;

    @Column(name = "student_id",insertable = false,updatable = false)
    private Integer studentIdLinked;

    public LinkedPurchaseListKey(Integer courseIdLinked, Integer studentIdLinked) {
        this.courseIdLinked = courseIdLinked;
        this.studentIdLinked = studentIdLinked;
    }

    public Integer getStudentIdLinked() {
        return studentIdLinked;
    }

    public void setStudentIdLinked(Integer studentIdLinked) {
        this.studentIdLinked = studentIdLinked;
    }

    public Integer getCourseIdLinked() {
        return courseIdLinked;
    }

    public void setCourseIdLinked(Integer courseIdLinked) {
        this.courseIdLinked = courseIdLinked;
    }
}
