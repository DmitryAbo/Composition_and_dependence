package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Movie {
    private int id;
    private String title;
    private String genre;
    private String srcImage;
    private int rating;
    private boolean isPremier;

}
