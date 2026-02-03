package com.hsbc.controller;

import com.hsbc.entity.Product;
import com.hsbc.entity.Student;
import com.hsbc.exception.InvalidIdException;
import com.hsbc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> products=productService.findProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);

    }
   @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) throws InvalidIdException {
        Product product = productService.findProduct(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(product);
    }
}
