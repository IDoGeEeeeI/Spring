package ru.geekbrains.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class InMemProductRepository implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread","50"),
                new Product(2L, "Milk","100"),
                new Product(3L, "Apples","30"),
                new Product(4L,"Pineapple","110"),
                new Product(5L,"Water","60")
        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }
}
