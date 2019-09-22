package com.example.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProductControllerTest {

  @MockBean
  private ProductService productService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void expectProductsToBeCreated() throws Exception {
    ProductDTO productDTO = populateDTO();
    when(productService.createProduct(any(Product.class))).thenReturn(new Product());

    mockMvc.perform(post("/products")
        .content(asJsonString(productDTO))
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isCreated());

    verify(productService, times(7)).createProduct(any(Product.class));
  }

  private static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private ProductDTO populateDTO(){
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
