package com.marcotomasrodriguez.crudexample.services;

import com.marcotomasrodriguez.crudexample.dtos.CreateProductDto;
import com.marcotomasrodriguez.crudexample.dtos.UpdateProductDto;
import com.marcotomasrodriguez.crudexample.exceptions.NotFoundException;
import com.marcotomasrodriguez.crudexample.models.Product;
import com.marcotomasrodriguez.crudexample.repositories.ProductRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(@NonNull UUID id) {
        return productRepository.findById(id);
    }

    public Product createProduct(@NonNull CreateProductDto createProductDto) {
        Product product = new Product();

        product.setTitle(createProductDto.getTitle());
        product.setDescription(createProductDto.getTitle());
        product.setStock(createProductDto.getStock());
        product.setPrice(createProductDto.getPrice());

        return productRepository.save(product);
    }

    public Product updateProductById(@NonNull UUID id, @NonNull UpdateProductDto updateProductDto) {
        Product product = findProductById(id)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        product.setTitle(updateProductDto.getTitle());
        product.setDescription(updateProductDto.getTitle());
        product.setStock(updateProductDto.getStock());
        product.setPrice(updateProductDto.getPrice());

        return productRepository.save(product);
    }

    public Product deleteProductById(@NonNull UUID id) {
        Product product = findProductById(id)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        productRepository.delete(product);

        return product;
    }
}
