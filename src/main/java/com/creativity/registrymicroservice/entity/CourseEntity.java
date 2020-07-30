package com.creativity.registrymicroservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_course")
public class CourseEntity implements Serializable {

    private static final long serialVersionUID = 1338085848461691030L;

    @Id
    @GeneratedValue
    @Column(name = "CourseId")
    private int id;
    @Column(name = "CourseName")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private int price;
    @Column(name = "Hour")
    private int hour;

    public CourseEntity() {

    }
    public CourseEntity(int id, String name, String description, int price, int hour){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
