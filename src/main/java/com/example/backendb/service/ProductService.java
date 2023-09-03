package com.example.backendb.service;

import com.example.backendb.entity.Product;
import com.example.backendb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductById(Long id){

        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){

        return repository.findByName(name);
    }
    public String deleteProduct(Long id){
        repository.deleteById(id);
        return "Product Removed!! "+id;
    }
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
