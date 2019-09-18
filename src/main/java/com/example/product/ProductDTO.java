package com.example.product;

import java.util.List;

public class ProductDTO {

  List<Product> products;

  public ProductDTO(List<Product> products) {
    this.products = products;
  }

  public List<Product> getProducts() {
    return products;
  }
}

