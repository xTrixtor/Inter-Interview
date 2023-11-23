package com.interview.Models.Db;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @SequenceGenerator(
            name="car_id_sequence",
            sequenceName = "car_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String brand;

    private String model;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
