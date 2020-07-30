package com.creativity.registrymicroservice.dto;


import java.io.Serializable;

public class CourseDto implements Serializable {

    private static final long serialVersionUID = 2663917142757924812L;

    private String name;

    private String description;

    private int price;

    private int hour;

    public CourseDto(){

    }

    public CourseDto(String name, String description, int price, int hour) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.hour = hour;
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
