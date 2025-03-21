package io.test.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.test.moviecatalogservice.models.CatalogItem;
import io.test.moviecatalogservice.models.Movie;
import io.test.moviecatalogservice.models.Rating;
import io.test.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId)
	{

		
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
		return ratings.getUserRating().stream().map(rating->
		{
			//For each movie ID, call movie info service and get details.
			//Synchronous
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			
			//Asynchronous
			//Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();

			//Put them all together
			return new CatalogItem(movie.getName(), "Description", rating.getRating());
		})
				.collect(Collectors.toList());
		
		//Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
		
		
	}

}
