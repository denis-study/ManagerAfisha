package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    MovieItem first = new MovieItem(1, 1, "first", "comedy", 10);
    MovieItem second = new MovieItem(2, 2, "second", "cartoon", 11);
    MovieItem third = new MovieItem(3, 3, "third", "thriller", 12);
    MovieItem fourth = new MovieItem(4, 4, "fourth", "horror", 13);
    MovieItem fifth = new MovieItem(5, 5, "fifth", "drama", 14);
    MovieItem sixth = new MovieItem(6, 6, "sixth", "musical", 15);
    MovieItem seventh = new MovieItem(7, 7, "seventh", "science-fiction", 16);
    MovieItem eighth = new MovieItem(8, 8, "eighth", "biography", 17);
    MovieItem ninth = new MovieItem(9, 9, "ninth", "mystery", 18);
    MovieItem tenth = new MovieItem(10, 10, "tenth", "documentary", 19);

    @BeforeEach
    public void setUp () {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    public void shouldSave() {
        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.findAll();
        MovieItem []actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        MovieItem[]actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        int idToFind = 5;
        repository.findById(idToFind);
        MovieItem actual = repository.findById(idToFind);
        MovieItem expected = fifth;
        assertEquals(actual, expected);

    }
    @Test
    void shouldFindByIdIfIdDoesNotExist() {
        AfishaRepository repository = new AfishaRepository();
        int idToFind = 11;
        repository.findById(idToFind);
        MovieItem actual = repository.findById(idToFind);
        MovieItem expected = null;
        assertEquals(actual, expected);

    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = {};
        assertArrayEquals(actual, expected);
    }
}