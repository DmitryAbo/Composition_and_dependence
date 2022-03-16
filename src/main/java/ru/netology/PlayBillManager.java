package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


