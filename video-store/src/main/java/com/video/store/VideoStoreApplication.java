package com.video.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoStoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(VideoStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VideoStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(MovieRepository repository) {
		return (args) -> {
			// save a couple of movies
			repository.save(new Movie("The Little Mermaid", "It's about a mermaid.", "04/03/2015", 7));
			repository.save(new Movie("Pan's Labyrinth", "Scary!", "01/16/1984", 3));
			repository.save(new Movie("WAT watwatwat", "WAT!", "12/12/2012", 3));

			// fetch all movies
			log.info("Movies found with findAll():");
			log.info("-------------------------------");
			for (Movie movie : repository.findAll()) {
				log.info(movie.toString());
			}
            log.info("");

			// fetch a single movie by ID
			Movie movie = repository.findOne(2L);
			log.info("Movie found with findOne(2L):");
			log.info("--------------------------------");
			log.info(movie.toString());
            log.info("");

			// fetch movies by title
			log.info("Movie found with findByTitle('The Little Mermaid'):");
			log.info("--------------------------------------------");
			for (Movie littleMermaid : repository.findByTitle("The Little Mermaid")) {
				log.info(littleMermaid.toString());
			}
            log.info("");
		};
	}
}
