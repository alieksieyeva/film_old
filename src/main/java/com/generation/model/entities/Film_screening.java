package com.generation.model.entities;

import java.time.LocalDateTime;

public class Film_screening 
{
    private int id;
    private LocalDateTime screening_time;
    private String title;
    private String cinema_room;
    private double price;

    public Film_screening (){}
    
    public Film_screening(LocalDateTime screening_time, String title, String cinema_room, double price) {
        this.screening_time = screening_time;
        this.title = title;
        this.cinema_room = cinema_room;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getScreening_time() {
        return screening_time;
    }
    public void setScreening_time(LocalDateTime screening_time) {
        this.screening_time = screening_time;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCinema_room() {
        return cinema_room;
    }
    public void setCinema_room(String cinema_room) {
        this.cinema_room = cinema_room;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Film_screening [id=" + id + ", screening_time=" + screening_time + ", title=" + title + ", cinema_room="
                + cinema_room + ", price=" + price + "]";
    }

    

    
}
