package com.example.MovieSearch.Service;

import com.example.MovieSearch.Entity.Movies;
import com.example.MovieSearch.Repository.MovieRepo;
import com.example.MovieSearch.RequestDTO.MovieRequestDto;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

//    public void addMovie(MovieRequestDto movieRequestDto){
//        Movies movies=new Movies();
//        movies.setMovieId(movieRequestDto.getMovieId());
//        movies.setYear(movieRequestDto.getYear());
//        movies.setTitle(movieRequestDto.getTitle());
//        movies.setDirectorName(movieRequestDto.getDirectorName());
//        movies.setImagePath(movieRequestDto.getImagePath());
//        movieRepo.save(movies);
//    }
    public void getMovie(String name){

    }
}
