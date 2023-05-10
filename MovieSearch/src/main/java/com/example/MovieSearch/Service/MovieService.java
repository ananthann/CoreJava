package com.example.MovieSearch.Service;

import com.example.MovieSearch.Entit.Movies;
import com.example.MovieSearch.Repository.MovieRepo;
import com.example.MovieSearch.responses.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MovieService {
    private final MovieRepo movieRepo;
    @Autowired
    CacheManager cacheManager;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public void getMovie(String title) {
        String apiKey="k_g8224jch";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("User-Agent","Application");
        HttpEntity<String > httpEntity=new HttpEntity<>(httpHeaders);
        String uri="https://imdb-api.com/en/API/SearchMovie/"+apiKey+"/"+title;
        Movie movie1=restTemplate.exchange(uri, HttpMethod.GET,httpEntity, Movie.class).getBody();
        System.out.println("Movie1"+movie1);
        String id="tt1375666";
        String uri2="https://imdb-api.com/n/API/Title/"+apiKey+"/"+id;
        cacheManager.getCache("movieCache");
        }


}
