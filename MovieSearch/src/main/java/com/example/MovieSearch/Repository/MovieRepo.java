package com.example.MovieSearch.Repository;

import com.example.MovieSearch.Entit.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movies,String> {

    void deleteAllByKeyword(String title);
}
