package com.example.MovieSearch.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movies {
    Integer id;
    String resultType;
    String image;
    Integer title;
    String description;
}
