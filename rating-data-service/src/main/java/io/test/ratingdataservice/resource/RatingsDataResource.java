package io.test.ratingdataservice.resource;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.test.ratingdataservice.models.Rating;
import io.test.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId)
	{
		return new Rating(movieId, 4);
	}
	
	@GetMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable String userId)
	{

				List<Rating> ratings = Arrays.asList(
				new Rating("101", 4),
				new Rating("102", 3)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
