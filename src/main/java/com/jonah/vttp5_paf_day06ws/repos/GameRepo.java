package com.jonah.vttp5_paf_day06ws.repos;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepo {
    @Autowired
    private MongoTemplate template;

    public void getAllGames(){
        Criteria criteria = Criteria.where("");
        Query query = Query.query(criteria);
        List<Document> results = template.find(query, Document.class, "games");
        System.out.println("READING THE FILE:" + results);
    }



    
}
