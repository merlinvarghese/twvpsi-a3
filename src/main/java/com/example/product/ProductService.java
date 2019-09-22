package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ProductService {

  @Autowired
  ProductRepository productRepository;

  Product createProduct(Product product) {
    return productRepository.save(product);
  }
}
