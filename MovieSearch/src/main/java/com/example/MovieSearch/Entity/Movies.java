package com.example.MovieSearch.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    @Id
    @GeneratedValue
    Integer movieId;
    String title;
    Integer year;
    String directorName;
    String imagePath;

}
