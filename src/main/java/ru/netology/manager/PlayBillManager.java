package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.Repository;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PlayBillManager {

    private Repository repo = new Repository();

    public void addMovie(Movie movie) {
        repo.save(movie);
    }

    public Movie[] findAll() {
        return (repo.findAll());
    }

    public Movie[] findLast() {
        return (repo.findLast());
    }

}


