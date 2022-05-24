package com.example.tema1;

public class Review {

 private String username;
 private String Review;

 public Review(String username, String Review){
     this.username = username;
     this.Review = Review;
 }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getUsername() {
        return username;
    }

    public String getReview() {
        return Review;
    }
}
