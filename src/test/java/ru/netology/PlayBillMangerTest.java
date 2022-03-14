package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayBillMangerTest {
    Movie movie1 = new Movie(1, "Ярость", "Боевик", "https://yandex.ru/images/image1", 4, true);
    Movie movie2 = new Movie(2, "Хоббит", "Фэнтези", "https://yandex.ru/images/image2", 8, false);
    Movie movie3 = new Movie(3, "Человек Паук", "Фэнтези", "https://yandex.ru/images/image3", 8, true);
    Movie movie4 = new Movie(4, "Мстители", "Фэнтези", "https://yandex.ru/images/image4", 9, false);
    Movie movie5 = new Movie(5, "Гран Торино", "Драма", "https://yandex.ru/images/image5", 10, true);
    Movie movie6 = new Movie(6, "Пацаны", "Комедия", "https://yandex.ru/images/image6", 8, true);
    Movie movie7 = new Movie(7, "Липучка", "Комедия", "https://yandex.ru/images/image7", 7, true);
    Movie movie8 = new Movie(8, "Малавита", "Триллер", "https://yandex.ru/images/image8", 6, false);
    Movie movie9 = new Movie(9, "Судья", "Драма", "https://yandex.ru/images/image9", 9, false);
    Movie movie10 = new Movie(10, "Зодиак", "Документальное", "https://yandex.ru/images/image10", 4, true);
    Movie movie11 = new Movie(11, "Старикам тут не место", "Боевик", "https://yandex.ru/images/image11", 7, false);
    Movie movie12 = new Movie(12, "Дурак", "Драма", "https://yandex.ru/images/image12", 10, false);
    Movie movie13 = new Movie(13, "Географ глобус пропил", "Драма", "https://yandex.ru/images/image13", 10, true);
    Movie movie14 = new Movie(14, "Чужой", "Боевик", "https://yandex.ru/images/image14", 5, true);
    Movie movie15 = new Movie(15, "Промитей", "Боевик", "https://yandex.ru/images/image15", 7, false);

    @Test
    void shouldAddOneMovie() {
        PlayBillManger playBillManger = new PlayBillManger();
        playBillManger.addMovie(movie1);
        Movie[] actual = playBillManger.findAll();
        Movie[] expected = new Movie[]{movie1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldAddSeveralMovie() {
        Movie[] expected = new Movie[]{movie1, movie2, movie3};
        PlayBillManger playBillManger = new PlayBillManger();
        playBillManger.addMovie(movie1);
        playBillManger.addMovie(movie2);
        playBillManger.addMovie(movie3);
        Movie[] actual = playBillManger.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindLastMoviesLessNumShow() {
        Movie[] expected = new Movie[]{movie4, movie3, movie2, movie1};
        PlayBillManger playBillManger = new PlayBillManger(5);
        playBillManger.addMovie(movie1);
        playBillManger.addMovie(movie2);
        playBillManger.addMovie(movie3);
        playBillManger.addMovie(movie4);
        Movie[] actual = playBillManger.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesMoreNumShow() {
        Movie[] expected = new Movie[]{movie6, movie5, movie4, movie3, movie2};
        PlayBillManger playBillManger = new PlayBillManger(5);
        playBillManger.addMovie(movie1);
        playBillManger.addMovie(movie2);
        playBillManger.addMovie(movie3);
        playBillManger.addMovie(movie4);
        playBillManger.addMovie(movie5);
        playBillManger.addMovie(movie6);
        Movie[] actual = playBillManger.findLast();
        assertArrayEquals(expected, actual);
    }

}