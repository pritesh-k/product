package com.app.product.model.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class ProductInfo {

    @JsonProperty("specifications")
    private Map<String, String> specifications;

    @JsonProperty("reviews")
    private List<Review> reviews;

    // Constructors
    public ProductInfo() {
        // Initialize lists or perform any necessary setup
    }

    public ProductInfo(Map<String, String> specifications, List<Review> reviews) {
        this.specifications = specifications;
        this.reviews = reviews;
    }

    // Getters and Setters...

    // Inner class representing a product review
    public static class Review {
        @JsonIgnore
        @JsonProperty("userId")
        private String userId;

        @JsonProperty("comment")
        private String comment;

        @JsonProperty("rating")
        private double rating;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

    public Map<String, String> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
