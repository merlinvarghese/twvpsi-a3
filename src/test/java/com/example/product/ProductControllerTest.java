package com.example.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class ProductControllerTest {

  @MockBean
  private ProductService productService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void expectProductToBeCreated() throws Exception {

    Product toothPaste = new Product(1L,"toothpaste","fmcg");
    Product soap = new Product(2L,"soap","fmcg");
    Product bodyMoisturizer = new Product(3L,"body moisturizer","fmcg");
    Product deodarant = new Product(4L,"deodarant","fmcg");
    Product biscuit = new Product(5L,"biscuit","eatable");
    Product peanuts = new Product(6L,"peanuts","eatable");
    Product panipuri = new Product(7L,"pani puri","eatable");

    List<Product> products = new ArrayList<>();
    products.add(toothPaste);
    products.add(soap);
    products.add(bodyMoisturizer);
    products.add(deodarant);
    products.add(biscuit);
    products.add(peanuts);
    products.add(panipuri);

    ProductDTO productDTO = new ProductDTO(products);

    when(productService.createProduct(productDTO)).thenReturn(productDTO);

    /*mockMvc.perform(post("/products"))
    .andExpect(status.isCreated);
*/
  }
}
