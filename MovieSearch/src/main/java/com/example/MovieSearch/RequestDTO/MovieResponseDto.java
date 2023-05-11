package com.example.MovieSearch.RequestDTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private String id;
    private String title;
    private String year;
    private String poster;
}
