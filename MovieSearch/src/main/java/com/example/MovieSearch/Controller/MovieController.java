package com.example.MovieSearch.Controller;

import com.example.MovieSearch.Entity.Movies;
import com.example.MovieSearch.RequestDTO.MovieRequestDto;
import com.example.MovieSearch.ResponseDTO.MovieResponseDto;
import com.example.MovieSearch.Service.MovieService;
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
    @GetMapping(value = "/getMovie")
    public ResponseEntity<String> getMovie(@RequestParam String title){
        String apiKey="k_g8224jch";
        MovieResponseDto movieResponseDto = null;
        System.out.println("running");
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("User-Agent","Application");
        HttpEntity<String >httpEntity=new HttpEntity<>(httpHeaders);
        String uri="https://imdb-api.com/en/API/SearchMovie/"+apiKey+"/"+title;



        String response= String.valueOf(restTemplate.exchange(uri, HttpMethod.GET,httpEntity, Object.class).getBody());
        String id= (restTemplate.exchange(uri, HttpMethod.GET,httpEntity, Object.class).getBody());
        String uri2="https://imdb-api.com/n/API/Title/"+apiKey+"/"+id;
        System.out.println(response);
//        try{
//            movieService.getMovie(String.valueOf(response),title);
//        }
//        catch (JsonProcessingException e){
//            System.out.println("error");
//        }
        return ResponseEntity.ok().body("movieResponseDto.toString()");
    }
}
