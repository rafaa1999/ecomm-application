package com.rafaa;

import com.rafaa.entities.Product;
import com.rafaa.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class);
    }
    @Bean
    public CommandLineRunner runner(ProductRepository productRepository){

        return args -> {

            Product product_one = Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("product_one")
                    .price(456.3)
                    .quantity(1)
                    .build();
            Product product_two = Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("product_two")
                    .price(485.99)
                    .quantity(4)
                    .build();
            Product product_three = Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("product_three")
                    .price(765.99)
                    .quantity(2)
                    .build();
            Product product_four = Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("product_four")
                    .price(567.99)
                    .quantity(3)
                    .build();

            List<Product> products = List.of(product_one,product_two,product_three,product_four);

            productRepository.saveAll(products);

        };
    }
}