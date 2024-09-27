package org.example.part_three_testing.controllers;

import org.example.part_three_testing.entities.Product;
import org.example.part_three_testing.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String home(){
        return "index";
    }

    @GetMapping("products")
    public String getProductsView(Model model){
        List<Product> products = service.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("products/{id}")
    public String getProductsView(@PathVariable int id, Model model){
        Product product = service.findProduct(id);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("products/new")
    public String getAddNewView(Model model){
        Product newProduct = new Product();
        model.addAttribute("product", newProduct);
        return "add-product";
    }

    @PostMapping("products/add")
    public String addProduct(@ModelAttribute Product payload){
        Product product = service.createProduct(payload);
        return "redirect:/products";
    }
}
