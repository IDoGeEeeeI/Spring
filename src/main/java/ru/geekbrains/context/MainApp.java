package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.context");
            CartService cartService = context.getBean(CartService.class);
            cartService.addOrderFromProduct(1L);
            cartService.addOrderFromProduct(1L);
            cartService.addOrderFromProduct(2L);
            cartService.addOrderFromProduct(5L);
            context.close();

            boolean a= true;
                while (a){
            System.out.println("");
            System.out.println("введите 1 , чтобы показать корзину");
            System.out.println("введите 2 , чтобы удалить хлеб");
            System.out.println("введите 3 , чтобы добавить хлеб");
            System.out.println("введите 0 , чтобы выйти");


                    Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i){
                case 1->{
                cartService.show();
                }
                case 2->{
                cartService.delOrderFromProduct(1L);
                cartService.show();
                }
                case 3->{
                cartService.addOrderFromProduct(1L);
                cartService.show();
                }
                case 0-> a=false;

            }

        }


    }
}
