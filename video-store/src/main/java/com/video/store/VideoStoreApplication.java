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

@SpringBootApplication
public class VideoStoreApplication {
	
//	private static final Logger log = LoggerFactory.getLogger(VideoStoreApplication.class);

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
                long inventory = (long) jsonObject.get("inventory");
                
                repository.save(new Movie(title, overview, releaseDate, inventory));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void seedCustomers(String path, CustomerRepository repository) {
		JSONParser parser = new JSONParser();
		
		try {
			 
            Object obj = parser.parse(new FileReader(path));
            JSONArray jsonArray = (JSONArray) obj;
            double accountCredit;
           
            for (int i = 0; i < jsonArray.size(); i++) {
            	JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            	
            	String name = (String) jsonObject.get("name");
                String registeredAt = (String) jsonObject.get("registered_at");
                String address = (String) jsonObject.get("address");
                String city = (String) jsonObject.get("city");
                String state = (String) jsonObject.get("state");
                String postalCode = (String) jsonObject.get("postal_code");
                String phone = (String) jsonObject.get("phone");
                
                if (jsonObject.get("account_credit").getClass().equals(Long.class)) {
                	accountCredit = (long) jsonObject.get("account_credit");
                	
                } else {
                	accountCredit = (double) jsonObject.get("account_credit");
                }
                
                Customer custy = new Customer(name, registeredAt, address, city, state, postalCode, phone);	
				custy.setAccountCredit(accountCredit);
                repository.save(custy);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Bean
	public CommandLineRunner seeder(MovieRepository movieRepository, CustomerRepository customerRepository) {
		
		return (args) -> {
			seedMovies("src/main/resources/movies.json", movieRepository);
			seedCustomers("src/main/resources/customers.json", customerRepository);
		};
	}
}
