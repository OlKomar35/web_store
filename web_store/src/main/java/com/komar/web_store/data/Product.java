package com.komar.web_store.data;

import lombok.Data;

@Data
public class Product {
    private final Long id;
    private final String name;
    private final int price;

}
