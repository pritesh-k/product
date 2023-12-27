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

@Service
public class DummyDataMapper {

    @Autowired
    DummyDataFeignClient feignClient;

    @Autowired
    MongoTemplate mongoTemplate;

    public void mapToNewTest(UUID userId) {


        ResponseEntity<DummyProductParent> responseEntity = feignClient.listProducts();

        List<DummyProduct> list = responseEntity.getBody().getDummyProducts();

        for (DummyProduct dummyProduct : list){
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

            newTest.setId(UUID.randomUUID()); // Assuming id is not available in Product
            newTest.setTag(null); // Assuming tag is not available in Product
            newTest.setCreatedDate(ZonedDateTime.now(ZoneOffset.UTC)); // Assuming createdDate is not available in Product
            newTest.setUpdatedDate(ZonedDateTime.now(ZoneOffset.UTC)); // Assuming updatedDate is not available in Product
            newTest.setUserId(userId); // Assuming userId is not available in Product
            newTest.setDummyId(dummyProduct.getId());

            mongoTemplate.save(newTest);
        }
    }

}
