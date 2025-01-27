package com.jonah.vttp5_paf_day06ws.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day06ws.models.Review;
import com.jonah.vttp5_paf_day06ws.models.ReviewUpdate;
import com.jonah.vttp5_paf_day06ws.services.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewRestController {
    @Autowired
    ReviewService reviewService;


    @PostMapping("")
    public void newReview(@RequestBody MultiValueMap<String,String> map){
        System.out.println("\nRECEIVED: " + map.getFirst("name") + map.getFirst("comment") + map.getFirst("gameId"));
        Review review = new Review();
        review.setComment(map.getFirst("comment"));
        review.setGameId(Integer.parseInt(map.getFirst("gameId")));
        review.setRating(Integer.parseInt(map.getFirst("rating")));
        review.setUserName(map.getFirst("name"));

        reviewService.addReviewToDatabase(review);

    }

    @PutMapping("/{review_id}")
    public void updateReview(@PathVariable("review_id") String reviewId, @RequestBody String entity){
        System.out.println("REVIEW ID IS:" + reviewId + "\n CONTENT RECEIEVED: \n" + entity);
        //ReviewUpdate reviewUpdate = reviewService.stringJsonToReviewUpdateModel(entity);
        reviewService.addReviewUpdate(reviewId, entity);

    }


    
}
