package com.jonah.vttp5_paf_day06ws.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day06ws.services.GameService;

@RestController
@RequestMapping("")
public class GameRestController {
    @Autowired
    GameService gameService;


    @GetMapping("/games")
    public void getSomeGames(@RequestParam(defaultValue = "25") int limit,@RequestParam(defaultValue = "0") int offset){
        gameService.getSomeGames(limit, offset);

        
    }
    
}


/* @GetMapping("/health")
    public ResponseEntity<String> checkProgram(){
        //if STATEMENT can connect to redis or open file or some critical function
        if(true){
            return ResponseEntity.ok("{}"); //successful
        }
        return ResponseEntity.status(400).body("{}"); //error

    } */