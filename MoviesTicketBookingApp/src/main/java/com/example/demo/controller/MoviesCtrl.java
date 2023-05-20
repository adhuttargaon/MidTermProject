package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movies;
import com.example.demo.repository.MoviesRepo;
//shows data on browser
@RestController
public class MoviesCtrl {
	@Autowired
	MoviesRepo movieRepo;
	@GetMapping("/movies")
	public List<Movies> getAllMovies(){
		return movieRepo.findAll();
				
	}
	@GetMapping("/movies/{id}")
	public Movies getMovieByid(@PathVariable("id")int id) {
		return movieRepo.findById(id).get();
	}
	@PostMapping("/movies")
	public String addMovie(@RequestBody Movies movie)
	{
		movieRepo.save(movie);
		return "Object is saved!";
	}
	
	@PutMapping("/movies/{id}")
	public String updateMovie(@RequestBody Movies movie) {
		Movies movie1 = (Movies)movieRepo.findById(movie.getMovie_id()).get();
				if(movie1.getMovie_id()==movie.getMovie_id()) {
					movie1.setMovie_title(movie.getMovie_title());
					movie1.setGenre(movie.getGenre());
					movie1.setDirector(movie.getDirector());
					movie1.setDuration(movie.getDuration());
					movie1.setRating(movie.getRating());
					movieRepo.save(movie1);
					

}
				return "record updated";
	}
				@DeleteMapping("/movies/{id}")
				public String deleteMovieById(@PathVariable("id")int id) {
					Movies movie1 = movieRepo.findById(id).get();
					if(movie1.getMovie_id()==id) {
						movieRepo.delete(movie1);
						
					}
					return "Record Deleted!";
				}
}
				
