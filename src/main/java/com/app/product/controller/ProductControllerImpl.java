package com.app.product.controller;

import com.app.product.model.api.Product;
import com.app.product.model.api.ProductInfo;
import com.app.product.service.DummyDataMapper;
import com.app.product.service.ProductService;
import com.app.product.util.ProductModelMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products/api/v1")
public class ProductControllerImpl {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductModelMapper productModelMapper;

    @Autowired
    private DummyDataMapper dummyDataMapper;

    /**
     * Get Product by ID
     */
    @Operation(
            summary = "Get Product by ID",
            description = "Retrieve a product by its unique identifier."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable @NotNull String productId) {
        com.app.product.model.data.Product product = productService.getProductById(UUID.fromString(productId));
        return ResponseEntity.ok(productModelMapper.productEntityToDto(product));
    }

    /**
     * Get Products by Name
     */
    @Operation(
            summary = "Get Products by Name",
            description = "Retrieve a list of products based on their name."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(value = "/listProduct/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable @NotNull String productName) {
        List<com.app.product.model.data.Product> products = productService.getProductsByName(productName);
        List<Product> productsApi = new ArrayList<>();

        if (products == null) {
            return ResponseEntity.ok(productsApi);
        }

        for (com.app.product.model.data.Product product : products) {
            productsApi.add(productModelMapper.productEntityToDto(product));
        }
        return ResponseEntity.ok(productsApi);
    }

    /**
     * Add a Product
     */
    @Operation(
            summary = "Add a Product",
            description = "Add a new product to the system."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody @NotNull Product product, HttpServletRequest request) {
        // Set user ID from the authenticated user
        String userId = request.getHeader("userId");
        product.setUserId(UUID.fromString(userId));

        com.app.product.model.data.Product savedProduct = productService.addProduct(productModelMapper.productDtoToEntity(product));
        return ResponseEntity.ok(productModelMapper.productEntityToDto(savedProduct));
    }

    /**
     * Fetch Dummy Data for testing
     */
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/addDummyData")
    public ResponseEntity<?> addDummyData(HttpServletRequest request) {
        // Set user ID from the authenticated user
        String userId = request.getHeader("userId");
        dummyDataMapper.mapToNewTest(UUID.fromString(userId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Add Comment to Product
     */
    @Operation(
            summary = "Add Comment to Product",
            description = "Add a comment to a product based on its unique identifier."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/{productId}/comment")
    public ResponseEntity<Product> addComment(@PathVariable @NotNull String productId, @RequestBody @NotNull ProductInfo.Review comment) {
        com.app.product.model.data.Product updatedProduct = productService.addComment(productId, comment);
        return ResponseEntity.ok(productModelMapper.productEntityToDto(updatedProduct));
    }

    /**
     * Add Review to Product
     */
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/{productId}/review")
    public ResponseEntity<Product> addReview(@PathVariable @NotNull String productId, @RequestBody @NotNull ProductInfo.Review review) {
        com.app.product.model.data.Product updatedProduct = productService.addReview(productId, review);
        return ResponseEntity.ok(productModelMapper.productEntityToDto(updatedProduct));
    }

    /**
     * Delete Product by ID
     */
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<Void> deleteProductById(@PathVariable @NotNull String productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update Product by ID
     */
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> updateProductById(@PathVariable @NotNull String productId, @RequestBody @NotNull Product product) {
        com.app.product.model.data.Product updatedProduct = productService.updateProductById(productId, productModelMapper.productDtoToEntity(product));
        return ResponseEntity.ok(productModelMapper.productEntityToDto(updatedProduct));
    }
}
