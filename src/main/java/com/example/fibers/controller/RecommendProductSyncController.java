package com.example.fibers.controller;

import com.example.fibers.models.Product;
import com.example.fibers.services.ProductRecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommended-products")
public class RecommendProductSyncController {
    private final ProductRecommendationService productRecommendationService;

    public RecommendProductSyncController(ProductRecommendationService productRecommendationService) {
        this.productRecommendationService = productRecommendationService;
    }

    @GetMapping("/customer/{customerId}")
    public List<Product> recommendedProducts(@PathVariable("customerId") String customerId) throws InterruptedException {
        return productRecommendationService.recommendProducts(customerId);
    }
}
