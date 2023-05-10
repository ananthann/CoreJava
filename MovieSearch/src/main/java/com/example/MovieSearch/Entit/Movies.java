package com.example.MovieSearch.Entit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movies {
    @Id
    @GeneratedValue
    private String searchType;
    private String expression;
    private String resultType;
    private String image;
    private Integer title;
    private String description;
    private static Map<String,Movies> searchListMap=new HashMap<>();
}
