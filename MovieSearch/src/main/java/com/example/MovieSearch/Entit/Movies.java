package com.example.MovieSearch.Entit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movies {
    @Id
    private String movieId;
    private String title;
    private String keyword;
    private String year;
    private String poster;
}
