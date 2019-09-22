package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/products")
  @ResponseStatus(HttpStatus.CREATED)
  ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
    List<Product> listProd = productDTO.getProducts();

    if (listProd.size() > 0) {
      for (Product product : listProd) {
        productService.createProduct(product);
      }
    }
    return productDTO;
  }
}