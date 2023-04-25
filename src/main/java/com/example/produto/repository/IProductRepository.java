package com.example.produto.repository;

import com.example.produto.domain.ProductDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<ProductDomain> findAllProducts();
    ProductDomain productById(Integer id);
    void save(ProductDomain productDomain);
    void updateProduct(ProductDomain productDomain);
    void deleteProduct(Integer id);
}
