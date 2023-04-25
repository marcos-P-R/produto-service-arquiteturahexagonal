package com.example.produto.infraestrutura.web;

import com.example.produto.domain.ProductDomain;
import com.example.produto.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class ProductController {
    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<ProductDomain> getAllProduct() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<Map<String, String>> addProduct(@RequestBody ProductDomain product){
        try {
            productService.addProduct(product);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of("Msg", "OK"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
