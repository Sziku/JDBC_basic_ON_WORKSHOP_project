package org.example.repository;

import org.example.model.Film;

import java.util.List;

public interface FilmDao {
    List<Film> getAllFilms();
}
