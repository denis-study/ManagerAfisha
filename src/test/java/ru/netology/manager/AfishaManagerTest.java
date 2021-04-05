package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)


public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;

    @InjectMocks
    AfishaManager manager;

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
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        MovieItem[] returned = new MovieItem[] {second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        MovieItem[] expected = new MovieItem[]{third, second};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        MovieItem[] returned = new MovieItem[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        MovieItem[] expected = new MovieItem[]{third, second, first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

}