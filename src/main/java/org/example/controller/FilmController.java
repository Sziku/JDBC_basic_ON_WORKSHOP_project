package org.example.controller;

import org.example.service.FilmService;

public class FilmController {
    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    public void listAllFilms(){
        service.getAllFilms().forEach(System.out::println);
    }
}
