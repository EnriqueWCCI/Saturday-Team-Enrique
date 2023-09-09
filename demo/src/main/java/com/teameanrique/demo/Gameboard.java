package com.teameanrique.demo;

import jakarta.persistence.Id;

    @Data
    @Entity(name = "Gameboards")
    @Table(name = "Gameboards")


public class Gameboard {
    
    @Id
    @GeneratedValue
    private long id;

    private String publisher;

    private String title;

    private String date_purchased;

    private String date_created;

    public Gameboard () {

    }

    public Gameboard(String publisher, String title, String date_purchased, String date_created) {
        this.publisher = publisher;
        this.title = title;
        this.date_purchased = date_purchased;
        this.date_created = date
    }



}
