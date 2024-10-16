package com.capstone.controller;

import com.capstone.model.Product;
import com.capstone.repository.ProductRepository;
import com.capstone.service.ProductService;
import com.capstone.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/{id}/optimistic")
    public Result<Object> updateStockOptimistic(@PathVariable Long id, @RequestParam int quantity) {

        productService.updateStockWithOptimisticLock(id, quantity);

        return Result.success("successfully updated");

    }

    @PostMapping("/{id}/pessimistic")
    public Result<Object> updateStockPessimistic(@PathVariable Long id, @RequestParam int quantity) {

        productService.updateStockWithPessimisticLock(id, quantity);

        return Result.success("successfully updated");
    }

    @PostMapping("/create")
    public Result<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);

        return Result.success("Product created");
    }

    // 浏览商品列表
    @GetMapping
    public Result<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return Result.success(products);
    }

    // 根据商品 ID 浏览商品详情
    @GetMapping("/{id}")
    public Result<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return Result.success(product);
    }

}
