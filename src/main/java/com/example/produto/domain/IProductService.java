package com.example.produto.domain;

import com.example.produto.erros.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<ProductDomain> getAllProducts();
    ProductDomain getProductById(Integer id) throws ProductNotFoundException;
    void addProduct(ProductDomain productDomain);
    void updateProduct(ProductDomain productDomain);
    void deleteProduct(Integer id);
}
