package com.video.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

@SpringBootApplication
public class VideoStoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(VideoStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VideoStoreApplication.class, args);
	}
	
	public static void seedMovies(String path, MovieRepository repository) {
		JSONParser parser = new JSONParser();
		
		try {
			 
            Object obj = parser.parse(new FileReader(path));
 
            JSONArray jsonArray = (JSONArray) obj;
 
            for (int i = 0; i < jsonArray.size(); i++) {
            	JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            	
            	String title = (String) jsonObject.get("title");
                String overview = (String) jsonObject.get("overview");
                String releaseDate = (String) jsonObject.get("release_date");
                Long inventory = (Long) jsonObject.get("inventory");
                
                repository.save(new Movie(title, overview, releaseDate, inventory));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Bean
	public CommandLineRunner seeder(MovieRepository repository) {
		
		return (args) -> {
			seedMovies("src/main/resources/movies.json", repository);
		};
	}
}
