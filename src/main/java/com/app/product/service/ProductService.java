package com.app.product.service;

import com.app.product.model.api.ProductInfo;
import com.app.product.model.data.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product getProductById(UUID productId);
    List<Product> getProductsByName(String productName);
    Product addProduct(Product product);
    Product addComment(String productId, ProductInfo.Review comment);
    Product addReview(String productId, ProductInfo.Review review);
    void deleteProductById(String productId);
    Product updateProductById(String productId, Product product);
}
