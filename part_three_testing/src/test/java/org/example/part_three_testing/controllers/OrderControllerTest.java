package org.example.part_three_testing.controllers;

import org.example.part_three_testing.entities.Product;
import org.example.part_three_testing.repository.OrderRepository;
import org.example.part_three_testing.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() throws Exception {
        Product product = new Product();
        product.setName("Microwave Oven");
        product.setImage("https://gh.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/72/907799/1.jpg?9353");
        product.setDescription("Bruhm BMM-20MW Microwave Oven - White - 20L - 12 Months Warranty");
        product.setPrice(20);
        productRepository.save(product);
    }

    @Test
    public void testOrderPlacement() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/order/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("order-successful"));
    }

}