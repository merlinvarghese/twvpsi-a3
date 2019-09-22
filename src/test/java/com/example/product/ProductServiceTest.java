package com.example.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductService productService;

  @Test
  void expectsProductsToBeCreated() {
    ProductDTO productDTO = populateDTO();
    List<Product> listProd = productDTO.getProducts();

    if (listProd.size() > 0) {
      for (Product product : listProd) {
        Product createdProduct = productService.createProduct(product);
        Product fetchedProduct = productRepository.findById(createdProduct.getId()).get();

        assertEquals(product.getName(), fetchedProduct.getName());
        assertEquals(product.getType(), fetchedProduct.getType());
      }
    }
  }

  private ProductDTO populateDTO() {
    Product toothPaste = new Product(1L, "toothpaste", "fmcg");
    Product soap = new Product(2L, "soap", "fmcg");
    Product bodyMoisturizer = new Product(3L, "body moisturizer", "fmcg");
    Product deodarant = new Product(4L, "deodarant", "fmcg");
    Product biscuit = new Product(5L, "biscuit", "eatable");
    Product peanuts = new Product(6L, "peanuts", "eatable");
    Product panipuri = new Product(7L, "pani puri", "eatable");

    List<Product> products = new ArrayList<>();
    products.add(toothPaste);
    products.add(soap);
    products.add(bodyMoisturizer);
    products.add(deodarant);
    products.add(biscuit);
    products.add(peanuts);
    products.add(panipuri);
    return new ProductDTO(products);
  }
}
