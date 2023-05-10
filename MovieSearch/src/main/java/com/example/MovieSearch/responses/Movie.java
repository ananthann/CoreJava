package com.example.MovieSearch.responses;

import com.example.MovieSearch.Entit.Movies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String searchType;
    private String expression;
    private List<Results> results;
}
