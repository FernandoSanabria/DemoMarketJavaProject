package com.demo.demomarket.web.controller;

import com.demo.demomarket.domain.Product;
import com.demo.demomarket.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products ")
    @ApiResponse(code = 200 , message = "ok")
    public ResponseEntity<List<Product>> getAll( ) {
        return new ResponseEntity<> (productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("search product by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "product was not found")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "the id product",required = true, example = "4323")
                                                  @PathVariable("id") int id) {
        return  productService.getProduct(id)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return  new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        if (productService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int id ) {
        return productService.getByCategory(id)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
