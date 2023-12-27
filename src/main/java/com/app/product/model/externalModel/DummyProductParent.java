package com.app.product.model.externalModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DummyProductParent {
    @JsonProperty("products")
    private List<DummyProduct> products;

    public DummyProductParent() {
    }

    public DummyProductParent(List<DummyProduct> dummyProducts) {
        this.products = dummyProducts;
    }

    public List<DummyProduct> getDummyProducts() {
        return products;
    }

    public void setDummyProducts(List<DummyProduct> dummyProducts) {
        this.products = dummyProducts;
    }
}
