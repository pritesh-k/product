package com.app.product.service;

import com.app.product.controller.DummyDataFeignClient;
import com.app.product.model.data.Product;
import com.app.product.model.externalModel.DummyProduct;
import com.app.product.model.externalModel.DummyProductParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Service class for mapping data from Dummy Data API to Product entities and saving them to MongoDB.
 */
@Service
public class DummyDataMapper {

    @Autowired
    DummyDataFeignClient feignClient;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Map data from Dummy Data API to new Product entities and save them to MongoDB.
     *
     * @param userId The user ID associated with the new products.
     */
    public void mapToNewTest(UUID userId) {

        // Retrieve dummy product data from the Dummy Data API
        ResponseEntity<DummyProductParent> responseEntity = feignClient.listProducts();

        // Extract the list of dummy products from the API response
        List<DummyProduct> list = Objects.requireNonNull(responseEntity.getBody()).getDummyProducts();

        // Map each dummy product to a new Product entity and save to MongoDB
        for (DummyProduct dummyProduct : list) {
            Product newTest = new Product();
            newTest.setTitle(dummyProduct.getTitle());
            newTest.setDescription(dummyProduct.getDescription());
            newTest.setPrice(dummyProduct.getPrice());
            newTest.setDiscountPercentage(dummyProduct.getDiscountPercentage());
            newTest.setRating(dummyProduct.getRating());
            newTest.setStock(dummyProduct.getStock());
            newTest.setBrand(dummyProduct.getBrand());
            newTest.setCategory(dummyProduct.getCategory());
            newTest.setThumbnail(dummyProduct.getThumbnail());
            newTest.setImages(dummyProduct.getImages());

            // Assuming the following properties are not available in DummyProduct and need to be set in Product
            newTest.setId(UUID.randomUUID());
            newTest.setTag(null);
            newTest.setCreatedDate(ZonedDateTime.now(ZoneOffset.UTC));
            newTest.setUpdatedDate(ZonedDateTime.now(ZoneOffset.UTC));
            newTest.setUserId(userId);
            newTest.setDummyId(dummyProduct.getId());

            // Save the new Product entity to MongoDB
            mongoTemplate.save(newTest);
        }
    }
}