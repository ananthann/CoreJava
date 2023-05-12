package com.example.MovieSearch.Service;

import com.example.MovieSearch.Entit.Movies;
import com.example.MovieSearch.Repository.MovieRepo;
import com.example.MovieSearch.RequestDTO.MovieResponseDto;
import com.example.MovieSearch.responses.ImdbResponseMovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;

@Service
@CacheConfig(cacheNames = {"movieCache"})
public class MovieService {
    @Autowired
    private final MovieRepo movieRepo;
    @Autowired
    CacheManager cacheManager;


    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Cacheable(key = "#title")
    public List<com.example.MovieSearch.RequestDTO.MovieResponseDto> getMovie(String title) {
        Boolean checkNull = null;
        List<com.example.MovieSearch.RequestDTO.MovieResponseDto> movieResponseDtoList=new ArrayList<>();
        try {
             movieResponseDtoList = (List<com.example.MovieSearch.RequestDTO.MovieResponseDto>) cacheManager.getCache("movieCache")
                    .get(title).get();
            return movieResponseDtoList;
        } catch (NullPointerException e) {
            checkNull = true;
        }
        if (checkNull.equals(true)) {
            String apiKey = "k_g8224jch";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("User-Agent", "Application");
            HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
            String uri = "https://imdb-api.com/en/API/SearchMovie/" + apiKey + "/" + title;
            ImdbResponseMovieDto movieDto = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, ImdbResponseMovieDto.class).getBody();
            System.out.println("Movie1" + movieDto);
            List<Movies> moviesList = new ArrayList<>();
            movieResponseDtoList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                com.example.MovieSearch.RequestDTO.MovieResponseDto movieResponseDto = new com.example.MovieSearch.RequestDTO.MovieResponseDto();
                movieResponseDto.setId(movieDto.getResults().get(i).getId());
                movieResponseDto.setTitle(movieDto.getResults().get(i).getTitle());
                movieResponseDto.setPoster(movieDto.getResults().get(i).getImage());
                movieResponseDto.setYear(movieDto.getResults().get(i).getDescription().substring(0, 4));
                movieResponseDtoList.add(movieResponseDto);
            }
//            String id = "tt1375666";
//            String uri2 = "https://imdb-api.com/n/API/Title/" + apiKey + "/" + id;
//            cacheManager.getCache("movieCache");
            return movieResponseDtoList;
        }
        return movieResponseDtoList;
    }


    public void saveMovie(String title) {
        List<MovieResponseDto> movieResponseDtos = (List<MovieResponseDto>) cacheManager.getCache("movieCache")
                .get(title).get();
        movieResponseDtos.forEach((element)->{
            Movies movies1 = new Movies();
            movies1.setMovieId(element.getId());
            movies1.setKeyword(title);
            movies1.setTitle(element.getTitle());
            movies1.setPoster(element.getPoster());
            movies1.setYear(element.getYear());
            movieRepo.save(movies1);
        });
    }
    public void deleteMovieSet(String title) {
            cacheManager.getCache("movieCache").evictIfPresent(title);
            movieRepo.deleteAllByKeyword(title);
    }

    public List<Movies> getSavedResults() {
        return movieRepo.findAll();
    }

    @Transactional
    public void deleteSpecificMovie(String id) {
        cacheManager.getCache("movieCache").evictIfPresent(movieRepo.findById(id).get().getTitle());
        movieRepo.deleteById(id);
    }
}
