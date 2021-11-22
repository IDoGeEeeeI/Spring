package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Bread",50),
                new Product(2L, "Milk",100),
                new Product(3L, "Apples",30),
                new Product(4L,"Pineapple",110),
                new Product(5L,"Water",60)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
