package com.example.MovieSearch.Controller;

import com.example.MovieSearch.Entit.Movies;
import com.example.MovieSearch.RequestDTO.MovieRequestDto;
import com.example.MovieSearch.ResponseDTO.MovieResponseDto;
import com.example.MovieSearch.Service.MovieService;
import com.example.MovieSearch.responses.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path = "/api/v2")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/addMovie")
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody MovieRequestDto movieRequestDto){
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/searchMovie")
    public ResponseEntity<String> getMovie(@RequestParam String title){
        movieService.getMovie(title);
        return ResponseEntity.ok().body("movieResponseDto.toString()");
    }
}
