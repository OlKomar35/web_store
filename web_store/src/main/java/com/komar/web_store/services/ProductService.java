package com.komar.web_store.services;

import com.komar.web_store.data.Product;
import com.komar.web_store.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
