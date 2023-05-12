package com.example.MovieSearch.Repository;

import com.example.MovieSearch.Entit.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MovieRepo extends JpaRepository<Movies,String> {
    @Transactional
    void deleteAllByKeyword(String titl);
}
