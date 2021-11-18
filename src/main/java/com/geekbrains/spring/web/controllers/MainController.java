package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.repositories.InMemProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    private InMemProductRepository productRepository;

    public MainController(InMemProductRepository Repository) {
        this.productRepository = Repository;
    }

    // Создать класс Товар (Product), с полями id, title, cost;

    // GET [http://localhost:8189/app]/add?a=5&b=10
    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // GET [http://localhost:8189/app]/product/110/info
    @GetMapping("/product/{id}/info")
    @ResponseBody
    public String showProductInfo(@PathVariable Long id) {
        return "Product #" + id;
    }

    @GetMapping("/products")
    public String showStudentsPage(Model model) {
        model.addAttribute("products", productRepository.getAll());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showStudentPage(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }
}
