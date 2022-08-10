package com.example.springboot.entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;

    @ManyToOne
    private Course course;

    protected Review() {
    }

    public Review(String description, String rating) {
        this.rating = rating;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Review[%s,%s]",rating,description);
    }
}
