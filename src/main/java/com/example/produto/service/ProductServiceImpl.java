package com.example.produto.service;

import com.example.produto.domain.IProductService;
import com.example.produto.domain.ProductDomain;
import com.example.produto.erros.ProductNotFoundException;
import com.example.produto.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDomain> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public ProductDomain getProductById(Integer id) throws ProductNotFoundException {
        return productRepository.productById(id);
    }

    @Override
    public void addProduct(ProductDomain productDomain) {
        productRepository.save(productDomain);
    }

    @Override
    public void updateProduct(ProductDomain productDomain) {
        productRepository.updateProduct(productDomain);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }
}
