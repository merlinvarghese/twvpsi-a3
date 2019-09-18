package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  ModelMap modelMapper;

  @Autowired
  ProductRepository productRepository;

  ProductDTO createProduct(ProductDTO products){

    for (Product product:products.getProducts() ){
      productRepository.save(product);
    }
    //return productRepository.save(products);
    return null;
  }

  private void convertDtoToEntity(){

  }


}
