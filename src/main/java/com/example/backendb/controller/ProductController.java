package com.example.backendb.controller;

import com.example.backendb.entity.Product;
import com.example.backendb.repository.ProductRepository;
import com.example.backendb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    @GetMapping("/Products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/ProductById/{id}")
    public Product findProductById(@PathVariable Long id){
        return service.getProductById(id);
    }
    @GetMapping("/ProductByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }
    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable Long Id,@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.deleteProduct(id);
    }

    public void setProductRepository(ProductRepository productRepository) {
    }
}
