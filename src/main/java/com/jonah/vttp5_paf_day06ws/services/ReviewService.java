package com.jonah.vttp5_paf_day06ws.services;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day06ws.models.Review;
import com.jonah.vttp5_paf_day06ws.models.ReviewUpdate;
import com.jonah.vttp5_paf_day06ws.repos.ReviewRepo;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    public void addReviewToDatabase(Review review){
        reviewRepo.insertComment(review);
    }

    public ReviewUpdate stringJsonToReviewUpdateModel(String stringJson){
        JsonReader jsonReader = Json.createReader(new StringReader(stringJson));
        JsonObject j = jsonReader.readObject();
        ReviewUpdate ru = new ReviewUpdate();

        try {
            ru.setComment(j.getString("comment"));
            ru.setRating(j.getInt("rating"));
            ru.setTimestamp(System.currentTimeMillis());
        
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("MISSING CONTENT");
        }
        return ru;

    }

    public void addReviewUpdate (String reviewId, String jsonStringUpdate){
    reviewRepo.addReviewUpdate(reviewId, jsonStringUpdate);
    }

    
    
}
