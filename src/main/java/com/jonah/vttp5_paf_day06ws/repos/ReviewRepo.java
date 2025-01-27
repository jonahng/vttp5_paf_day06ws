package com.jonah.vttp5_paf_day06ws.repos;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day06ws.models.Review;
import com.mongodb.client.result.UpdateResult;

@Repository
public class ReviewRepo {
    @Autowired
    MongoTemplate template;

    public String getGameNameFromGameId(int gameId){
        Criteria criteria = Criteria.where("gid").is(gameId);
        Query query = Query.query(criteria);
        List<Document> results = template.find(query, Document.class, "games");
        String gameName = "";
        for(Document d : results){
            gameName = d.getString("name");
        }
        return gameName;


    }


    public void insertComment(Review review){
        Document toInsert = new Document();
        //toInsert.put(null, toInsert)
        toInsert.put("user", review.getUserName());
        toInsert.put("rating", review.getRating());
        toInsert.put("comment", review.getComment());
        toInsert.put("ID", review.getGameId());
        toInsert.put("posted", System.currentTimeMillis());
        toInsert.put("name", getGameNameFromGameId(review.getGameId()));
        System.out.println("the document to insert is:" + toInsert.toJson());
        Document afterInsert = template.insert(toInsert, "comments");
        ObjectId id = afterInsert.getObjectId("_id");
        System.out.println("the id for your inserted comment is:" + id);
    }

    public void addReviewUpdate(String reviewId, String jsonInputString){
        Document update = Document.parse(jsonInputString);
        update.append("posted", System.currentTimeMillis());
        System.out.println("\nReviewRepo, THE UPDATE IS:" + update.toJson());


        Criteria criteria = Criteria.where("_id").is(reviewId);
        Query query =Query.query(criteria);
        Update updateOps = new Update().push("edited", update);

        UpdateResult updateResult = template.updateFirst(query, updateOps, Document.class, "comments");
    }

    
}
