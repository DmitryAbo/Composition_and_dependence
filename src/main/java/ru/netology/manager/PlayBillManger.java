package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor

public class PlayBillManger {
    private Movie[] movies = new Movie[0];
    private int numShowMovies = 10;

    public PlayBillManger(int numShowMovies) {
        this.numShowMovies = numShowMovies;
    }

    public void addMovie(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        Movie[] result = new Movie[movies.length];
        System.arraycopy(movies, 0, result, 0, movies.length);
        return result;
    }

    public Movie[] findLast() {
        int resultNumMovies = movies.length > numShowMovies ? numShowMovies : movies.length;            //Определить величину результирующего массива фильмов в ленте
        Movie[] result = new Movie[resultNumMovies];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;

    }

}


