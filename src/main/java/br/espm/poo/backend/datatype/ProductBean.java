package br.espm.poo.backend.datatype;

import java.util.UUID;

public class ProductBean {
    private UUID id;
    private String name;
    private double price;

    public ProductBean(UUID id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double applyDiscount(double discount){
        return price * (1 - discount);
    }
}
