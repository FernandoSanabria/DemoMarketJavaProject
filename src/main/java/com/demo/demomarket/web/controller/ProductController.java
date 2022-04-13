package com.demo.demomarket.web.controller;

import com.demo.demomarket.domain.Product;
import com.demo.demomarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll( ) {
       return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int id) {
        return  productService.getProduct(id);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return  productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable("id") int id) {
        return productService.delete(id);
    }

    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id") int id ) {
        return productService.getByCategory(id);
    }

}
