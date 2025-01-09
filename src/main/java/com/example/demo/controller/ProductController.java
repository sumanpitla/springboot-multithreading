package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/process/single-threaded")
    public String processSingleThreaded(@RequestBody List<String> productIds) {
        productService.processTransactionsSingleThreaded(productIds);
        return "Processed transactions in single-threaded mode.";
    }

    @PostMapping("/process/multi-threaded")
    public String processMultiThreaded(@RequestBody List<String> productIds) {
        productService.processTransactionsMultiThreaded(productIds);
        return "Processed transactions in multi-threaded mode.";
    }
}
