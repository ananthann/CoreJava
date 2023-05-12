package com.example.MovieSearch.Controller;

import com.example.MovieSearch.Entit.Movies;
import com.example.MovieSearch.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v2")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    private  MovieService movieService;

    @GetMapping(value = "/searchMovie")
    public ResponseEntity<List<com.example.MovieSearch.RequestDTO.MovieResponseDto>> getMovie(@RequestParam String title){
        return ResponseEntity.ok().body(movieService.getMovie(title));
    }
    @PostMapping(value = "/saveMovie")
    public ResponseEntity<String> saveMovie(@RequestParam String title){
        movieService.saveMovie(title);
        return ResponseEntity.ok().body("Movie successfully saved");
    }
    @DeleteMapping(value = "deleteMovie")
    public ResponseEntity<String> deleteMovieSet(@RequestParam String title){
        movieService.deleteMovieSet(title);
        return ResponseEntity.ok().body("Successfully deleted");
    }
    @GetMapping
    public ResponseEntity<List<Movies>> getSavedMovies(){
        return ResponseEntity.ok().body(movieService.getSavedResults());
    }
    @DeleteMapping
    public ResponseEntity<String> deleteSpecificMovie(@RequestParam String id){
        movieService.deleteSpecificMovie(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }
}
