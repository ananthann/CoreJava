package com.example.MovieSearch.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    private String id;
    private String resultType;
    private String image;
    private String title;
    private String description;
}
