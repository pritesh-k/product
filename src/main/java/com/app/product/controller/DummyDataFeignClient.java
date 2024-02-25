package com.app.product.controller;

import com.app.product.model.externalModel.DummyProductParent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign client interface for communicating with the Dummy Data API.
 */
@FeignClient(name = "dummyData", url = "https://dummyjson.com/products?limit=100")
public interface DummyDataFeignClient {

    /**
     * Retrieve a list of dummy products from the Dummy Data API.
     *
     * @return ResponseEntity containing the DummyProductParent representing the list of dummy products.
     */
    @GetMapping
    ResponseEntity<DummyProductParent> listProducts();
}
