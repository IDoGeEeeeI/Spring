package ru.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CartService {
    private ProductService productService;
    private List<String> products;
    private ArrayList<String> a1 = new ArrayList<>();

    @Autowired
    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }
    public  void addOrderFromProduct(Long productId){
        System.out.println("добавлен в корзину: "+productService.getTitleById(productId)+ " " + productService.getCostById(productId));
        a1.add(productService.getTitleById(productId));
    }
    public  void  delOrderFromProduct(Long productId){
        System.out.println("удален из корзины: "+productService.getCostById(productId)+" "+ productService.getCostById(productId));
        a1.remove(productService.getTitleById(productId));
    }
    public void show(){
        System.out.println(a1);
    }

}
