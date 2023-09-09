package com.teameanrique.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Publisher")
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Publisher () {

};

    public Publisher(String name) {
        this.name = name;

    }
}


