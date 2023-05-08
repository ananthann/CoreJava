package com.example.MovieSearch.RequestDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieRequestDto {
    String title;
}
