package com.flamexander.hibernate.h2;

import java.util.List;

public interface ProductDao {
    product findById(Long id);
    product findByTitle(String name);
    List<product> findAll();
    void deleteById(Long id);
    void save(product product);
    void testCaching();
}
