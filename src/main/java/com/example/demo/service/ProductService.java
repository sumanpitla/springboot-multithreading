package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Single-threaded transaction processing
    public void processTransactionsSingleThreaded(List<String> productIds) {
        long startTime = System.currentTimeMillis();

        for (String productId : productIds) {
            processTransaction(productId);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded execution time: " + (endTime - startTime) + "ms");
    }

    // Multi-threaded transaction processing
    public void processTransactionsMultiThreaded(List<String> productIds) {
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<Void>> futures = productIds.stream()
                .map(this::processTransactionAsync)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded execution time: " + (endTime - startTime) + "ms");
    }

    // Simulated transaction processing
    private void processTransaction(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getQuantity() > 0) {
            product.setQuantity(product.getQuantity() - 1); // Decrease quantity
            productRepository.save(product); // Save the update
            System.out.println("Processed transaction for product: " + product.getName());
        }
    }

    // Async version for parallel processing
    @Async
    public CompletableFuture<Void> processTransactionAsync(String productId) {
        processTransaction(productId);
        return CompletableFuture.completedFuture(null);
    }
}

