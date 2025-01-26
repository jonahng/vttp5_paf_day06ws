package com.jonah.vttp5_paf_day06ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jonah.vttp5_paf_day06ws.repos.GameRepo;

@SpringBootApplication
public class Vttp5PafDay06wsApplication implements CommandLineRunner {
	@Autowired
	private GameRepo gameRepo;

	public static void main(String[] args) {
		SpringApplication.run(Vttp5PafDay06wsApplication.class, args);
	}

	@Override
	public void run(String... args){
		//gameRepo.getAllGames();

	}

}
