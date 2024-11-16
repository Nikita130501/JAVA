package com.example.carmarket;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Computer {

    @Id
    private Long id; // Уникальный идентификатор

    @ManyToOne
    private CarBrand brand;

    @ManyToOne
    private CarModel model;

    @OneToMany
    private List<CarPart> parts;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public List<CarPart> getParts() {
        return parts;
    }

    public void setParts(List<CarPart> parts) {
        this.parts = parts;
    }
}

