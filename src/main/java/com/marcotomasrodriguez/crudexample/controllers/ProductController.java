package com.marcotomasrodriguez.crudexample.controllers;

import com.marcotomasrodriguez.crudexample.dtos.CreateProductDto;
import com.marcotomasrodriguez.crudexample.dtos.UpdateProductDto;
import com.marcotomasrodriguez.crudexample.exceptions.NotFoundException;
import com.marcotomasrodriguez.crudexample.models.Product;
import com.marcotomasrodriguez.crudexample.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable UUID id) {
        return productService.findProductById(id)
                .orElseThrow(() -> new NotFoundException("Product not found."));
    }

    @PostMapping
    public Product patchProductById(@Valid @RequestBody CreateProductDto createProductDto) {
        return productService.createProduct(createProductDto);
    }

    @PatchMapping("{id}")
    public Product patchProductById(@PathVariable UUID id, @Valid @RequestBody UpdateProductDto updateProductDto) {
        return productService.updateProductById(id, updateProductDto);
    }

    @DeleteMapping("{id}")
    public Product deleteProductById(@PathVariable UUID id) {
        return productService.deleteProductById(id);
    }
}
