package com.Springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springdemo.model.MovieModel;
import com.Springdemo.repo.MovieRepo;

@Service
public class MovieService {

	@Autowired
	MovieRepo movieRepo;
	
	public List<MovieModel> getAllMovie() {
		return movieRepo.findAll();
	}
	
	public void createMovie(MovieModel movieModel) {
		movieRepo.save(movieModel);
	}
	
	public MovieModel getMovieById(Long id) {
		return movieRepo.findById(id).orElseThrow();
	}
	
	public void updateMovie(Long id, MovieModel movieModel) {
		MovieModel movie=movieRepo.findById(id).orElseThrow();
		movie.setDirector(movieModel.getDirector());
		movie.setGenre(movieModel.getGenre());
		movie.setRating(movieModel.getRating());
		movie.setReleaseYear(movieModel.getReleaseYear());
		movie.setTitle(movieModel.getTitle());
		createMovie(movie);
	}
	
	public void deleteMovie(Long id) {
		movieRepo.deleteById(id);
	}
}
