package ru.netology;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Repository {

    private Movie[] movies = new Movie[0];
    private int numShowMovies = 5;

    public void save(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public void removeById(Movie moviedelete) {
        Movie[] tmp = new Movie[movies.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() != moviedelete.getId()) {
                tmp[copyToIndex] = movies[i];
                copyToIndex++;
            }
        }
        movies = tmp;
    }

    public Movie findById(int id) {
        Movie result = new Movie();
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() == id) {
                result = movies[i];
                break;
            } else {
                result = null;
            }
        }
        return (result);
    }

    public Movie[] findAll() {
        Movie[] result = new Movie[movies.length];
        System.arraycopy(movies, 0, result, 0, movies.length);
        return result;
    }

    public void removeAll() {
        movies = null;
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
