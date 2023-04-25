package com.example.produto.infraestrutura.persistence;

import com.example.produto.domain.ProductDomain;
import com.example.produto.repository.IProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private IRepositoryProduct repositoryProduct;

    public ProductRepositoryImpl(IRepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }

    @Override
    public List<ProductDomain> findAllProducts() {
        return repositoryProduct.findAll().stream().map(product -> {
            return new ProductDomain(null, product.getName(), product.getDescription(), product.getPrice());
        }).collect(Collectors.toList());
    }

    @Override
    public ProductDomain productById(Integer id) {
        return repositoryProduct.findById(id).map(product -> {
            return new ProductDomain(product.getId(), product.getName(), product.getDescription(), product.getPrice());
        }).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
    }

    @Override
    public void save(ProductDomain productDomain) {
        Product product = new Product(productDomain.name(), productDomain.description(), productDomain.price());
        repositoryProduct.save(product);
    }

    @Override
    public void updateProduct(ProductDomain productDomain) {
        repositoryProduct.findById(productDomain.id()).ifPresent(productUpdate -> {
            productUpdate.setName(productDomain.name());
            productUpdate.setDescription(productDomain.description());
            productUpdate.setPrice(productDomain.price());
            repositoryProduct.save(productUpdate);
        });
    }

    @Override
    public void deleteProduct(Integer id) {
        repositoryProduct.deleteById(id);
    }
}
