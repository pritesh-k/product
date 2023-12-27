package com.app.product.model.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Product {

    @JsonIgnore
    private UUID id;
    private String title;
    private String description;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("category")
    private String category;
    @JsonIgnore
    @JsonProperty("createdDate")
    private ZonedDateTime createdDate = null;

    @JsonIgnore
    @JsonProperty("updatedDate")
    private ZonedDateTime updatedDate = null;
    private double price;

    private double discountPercentage;

    private String brand;

    private Integer stock;

    private double rating;

    private String thumbnail;

    private List<String> images;


    private Integer dummyId;

    @JsonIgnore
    private UUID userId; // User ID who added the product

    public Product() {
    }

    public Product(UUID id, String title, String description, String tag, String category, ZonedDateTime createdDate, ZonedDateTime updatedDate, double price, double discountPercentage, String brand, Integer stock, double rating, String thumbnail, List<String> images, UUID userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tag = tag;
        this.category = category;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.brand = brand;
        this.stock = stock;
        this.rating = rating;
        this.thumbnail = thumbnail;
        this.images = images;
        this.userId = userId;
    }


// Getters and Setters...


    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Integer getDummyId() {
        return dummyId;
    }

    public void setDummyId(Integer dummyId) {
        this.dummyId = dummyId;
    }

    // toString method...


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", category='" + category + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", rating=" + rating +
                ", thumbnail='" + thumbnail + '\'' +
                ", images=" + images +
                ", dummyId=" + dummyId +
                ", userId=" + userId +
                '}';
    }
}