package com.example.MovieSearch.Controller;

import com.example.MovieSearch.RequestDTO.MovieRequestDto;
import com.example.MovieSearch.ResponseDTO.MovieResponseDto;
import com.example.MovieSearch.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/v1")
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
    @GetMapping(path = "/getMovie")
    public ResponseEntity<String> getMovie(@RequestBody MovieRequestDto movieRequestDto)
    {
        RestTemplate restTemplate=new RestTemplate();
        String exp=movieRequestDto.getTitle();
        String uri="https://imdb-api.com/en/API/SearchMovie/k_g8224jch/{exp}";
        String result=restTemplate.getForObject(uri, String.class);
        return ResponseEntity.ok().body(result);
    }
}
