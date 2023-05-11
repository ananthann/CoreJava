package com.example.MovieSearch.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImdbResponseMovieDto {
    private String searchType;
    private String expression;
    private List<Results> results;
}
