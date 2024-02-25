package com.app.product.controller;

import com.app.product.model.api.Product;
import com.app.product.model.api.ProductInfo;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProductController {

    ResponseEntity<Product> getProductById(@NotNull String productId);

    ResponseEntity<List<Product>> getProductsByName(@NotNull String productName);

    ResponseEntity<Product> addProduct(@NotNull Product product, HttpServletRequest request);

    ResponseEntity<?> addDummyData(HttpServletRequest request);

    ResponseEntity<Product> addComment(@NotNull String productId, @NotNull ProductInfo.Review comment);

    ResponseEntity<Product> addReview(@NotNull String productId, @NotNull ProductInfo.Review review);

    ResponseEntity<Void> deleteProductById(@NotNull String productId);

    ResponseEntity<Product> updateProductById(@NotNull String productId, @NotNull Product product);
}
