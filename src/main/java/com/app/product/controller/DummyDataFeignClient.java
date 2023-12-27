package com.app.product.controller;

import com.app.product.model.externalModel.DummyProductParent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dummyData", url = "https://dummyjson.com/products?limit=100")
public interface DummyDataFeignClient {
    @GetMapping
    ResponseEntity<DummyProductParent> listProducts();
}
