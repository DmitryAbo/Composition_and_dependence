package ru.netology.repository;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor

public class Repository {

    private Movie[] movies = new Movie[0];
    private int numShowMovies = 10;

    public void save(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public void removeById(Movie movieDelete) {
        Movie[] tmp = new Movie[movies.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() != movieDelete.getId()) {
                tmp[copyToIndex] = movies[i];
                copyToIndex++;
            }
        }
        movies = tmp;
    }

    public Movie findById(int id) {
        Movie result = new Movie();
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return (movie);
            }
        }
        return null;
    }

    public Movie[] findAll() {
        Movie[] result = new Movie[movies.length];
        System.arraycopy(movies, 0, result, 0, movies.length);
        return result;
    }

    public void removeAll() {
        movies = new Movie[0];
    }

    public Movie[] findLast() {
        int resultNumMovies = movies.length > numShowMovies ? numShowMovies : movies.length;            //Определить величину результирующего массива фильмов в ленте
        Movie[] result = new Movie[resultNumMovies];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;

    }

    public Repository(int numShowMovies) {
        this.numShowMovies = numShowMovies;
    }
}
