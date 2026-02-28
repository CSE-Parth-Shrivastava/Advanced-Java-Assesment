package com.Springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Springdemo.model.MovieModel;
import com.Springdemo.service.MovieService;

@Controller
@RequestMapping("/api")
public class MovieController {

	@Autowired
	MovieService movieService;
	@GetMapping("/movie")
	public String getAllMovies(Model model) {
		List<MovieModel> movie= movieService.getAllMovie();
		model.addAttribute("movies",movie);
		return "movie";
	}
	
	@GetMapping("/addMovie")
	public String getAddMoviePage(Model model) {
		model.addAttribute("movie", new MovieModel());
		return "addMovie";
	}
	
	@PostMapping("/addMovie")
	public String addMovies(@ModelAttribute("movie") MovieModel movieModel) {
		movieService.createMovie(movieModel);
		return "redirect:/api/movie";
	}
	
	
	@GetMapping("/editMovie/{id}")
	public String getUpdatePage(@PathVariable Long id ,Model model) {
		MovieModel old=movieService.getMovieById(id);
		model.addAttribute("movie",old);
		return "editMovie";
		
	}
	@PostMapping("editMovie/{id}")
	public String getUpdates(@PathVariable Long id, @ModelAttribute("movie") MovieModel movieModel) {
		movieService.updateMovie(id, movieModel);
		return "redirect:/api/movie";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "redirect:/api/movie";
	}
}
