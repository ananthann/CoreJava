package com.example.MovieSearch.Service;

import com.example.MovieSearch.Entity.Movies;
//import com.example.MovieSearch.Repository.MovieRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
//    private final MovieRepo movieRepo;
//
//    public MovieService(MovieRepo movieRepo) {
//        this.movieRepo = movieRepo;
//    }
    public void getMovie(String response, String title) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode=objectMapper.readTree(String.valueOf(response));
        for (int i=0;i<3;i++) {
            String movieTitle = jsonNode.get("results").get(i).get("title").asText();
            int movieYear = jsonNode.get("results").get(i).get("year").asInt();
            String director = jsonNode.get("results").get(i).get("directorName").asText();
            String imgPath = jsonNode.get("results").get(i).get("imagePath").asText();
            Movies movies = new Movies();
//            movieRepo.save(movies);

        }
    }
}
