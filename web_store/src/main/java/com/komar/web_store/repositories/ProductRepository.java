package com.komar.web_store.repositories;

import com.komar.web_store.data.Product;
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
                new Product(1L, "Walnut", 10),
                new Product(2L, "Hazelnut", 15),
                new Product(3L, "Peanut", 3),
                new Product(4L, "Almond", 14),
                new Product(5L, "Cashews", 12),
                new Product(6L, "Coconut", 8),
                new Product(7L, "Brazil nut", 20)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteById(Long id){
        products.removeIf(p->p.getId().equals(id));
    }
}
