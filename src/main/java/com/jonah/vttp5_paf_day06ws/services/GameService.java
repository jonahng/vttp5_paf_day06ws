package com.jonah.vttp5_paf_day06ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day06ws.repos.GameRepo;

@Service
public class GameService {
    @Autowired
    GameRepo gameRepo;


    public void getSomeGames(int limit, int offset){
        gameRepo.getSomeGames(limit, offset);
    }
}
