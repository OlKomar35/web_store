package com.komar.web_store.controller;

import com.komar.web_store.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String showMainPage(){
        return "index";
    }

    @GetMapping("/products")
    public String showProductsPage(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @GetMapping("/card")
    public String showCardPage(Model model){
        model.addAttribute("product",productService.getAllProducts());
        return "card";
    }

}
