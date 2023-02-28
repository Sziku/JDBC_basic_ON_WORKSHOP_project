package org.example.service;

import org.example.model.Film;
import org.example.repository.FilmDao;

import java.util.List;

public class FilmService {
    private final FilmDao repository;


    public FilmService(FilmDao repository) {
        this.repository = repository;
    }

    public List<Film> getAllFilms() {
        return repository.getAllFilms();
    }
}
