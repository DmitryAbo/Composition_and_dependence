package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PlayBillMangerTest {

    //@Mock
    private Repository repository = Mockito.mock(Repository.class);
    //@InjectMocks
    private PlayBillManager playBillManager = new PlayBillManager(repository);
    private Movie movie1 = new Movie(1, "Ярость", "Боевик", "https://yandex.ru/images/image1", 4, true);
    private Movie movie2 = new Movie(2, "Хоббит", "Фэнтези", "https://yandex.ru/images/image2", 8, false);
    private Movie movie3 = new Movie(3, "Человек Паук", "Фэнтези", "https://yandex.ru/images/image3", 8, true);
    private Movie movie4 = new Movie(4, "Мстители", "Фэнтези", "https://yandex.ru/images/image4", 9, false);
    private Movie movie5 = new Movie(5, "Гран Торино", "Драма", "https://yandex.ru/images/image5", 10, true);

    @Test
    public void shouldFindAllMovies() {
        Movie[] returned = new Movie[]{movie1, movie2, movie3, movie4, movie5};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie[]{movie1, movie2, movie3, movie4, movie5};
        Movie[] actual = playBillManager.findAll();
        assertArrayEquals(actual, expected);
    }
}
