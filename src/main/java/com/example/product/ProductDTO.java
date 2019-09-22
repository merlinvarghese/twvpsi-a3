package com.example.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class ProductDTO implements Serializable {

  public List<Product> products;

  public ProductDTO() {
    this.products = new ArrayList<>();
  }

  public ProductDTO(List<Product> products) {
    this.products = products;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return new String("ProductDTO : " + products.toString());
  }
}

