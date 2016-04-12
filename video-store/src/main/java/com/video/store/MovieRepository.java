package com.video.store;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends CrudRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long> {

	List<Movie> findByTitle(@Param("title") String title);
	
}
