package com.jonah.vttp5_paf_day06ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day06ws.models.Review;
import com.jonah.vttp5_paf_day06ws.repos.ReviewRepo;

@Service
public class ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    public void addReviewToDatabase(Review review){
        reviewRepo.insertComment(review);
    }
    
}
