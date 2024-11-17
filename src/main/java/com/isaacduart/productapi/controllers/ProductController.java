package com.isaacduart.productapi.controllers;

import com.isaacduart.productapi.application.DTO.ProductRecordCreateDTO;
import com.isaacduart.productapi.application.DTO.ProductRecordDTO;
import com.isaacduart.productapi.application.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductRecordDTO> saveProduct(@RequestBody @Valid ProductRecordCreateDTO productRecordDTO) {
        var createdProduct = productService.createProduct(productRecordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(createdProduct);
    }

    @PutMapping("/products")
    public ResponseEntity<ProductRecordDTO> updateProduct(@RequestBody @Valid ProductRecordDTO productRecordDTO) {

        var product = productService.getProduct(productRecordDTO.id());
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var createdProduct = productService.updateProduct(productRecordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(createdProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductRecordDTO> deleteProduct(@PathVariable(value = "id") Long id) {

        var product = productService.getProduct(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductRecordDTO> getProducts(@PathVariable(value = "id") Long id) {
        var product = productService.getProduct(id);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductRecordDTO>> getAllProducts() {
        var products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }


}
