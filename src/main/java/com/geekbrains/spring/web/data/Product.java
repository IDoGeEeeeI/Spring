package com.geekbrains.spring.web.data;

public class Product {
    private Long id;
    private String name;
    private String cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    public Product(){}

    public Product(Long id, String title, String cost) {
        this.id = id;
        this.name = title;
        this.cost= cost;
    }
}
