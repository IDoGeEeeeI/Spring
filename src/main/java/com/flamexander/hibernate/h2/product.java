package com.flamexander.hibernate.h2;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int score) {
        this.cost = score;
    }

    public product(String title) {
        this.title = title;
    }

    public product() {
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
