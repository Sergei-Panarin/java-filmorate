package ru.yandex.practicum.filmorate.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmStorage filmStorage;
    private final FilmService filmService;

    @GetMapping("/films")
    public Collection<Film> findAll() {
        return filmStorage.findAll();
    }

    @PostMapping("/films")
    public Film create(@RequestBody Film film) {
        return filmStorage.create(film);
    }

    @PutMapping("/films")
    public Film update(@RequestBody Film film) {
        return filmStorage.update(film);
    }

    @GetMapping("/films/{id}")
    public Film findFilmById(@PathVariable Integer id) {
        return filmService.getFilmById(id);
    }

    @PutMapping("/films/{id}/like/{userId}")
    public void addLike(@PathVariable Integer id, Integer userId) {
        filmService.addLike(id, userId);
    }

    @DeleteMapping("/films/{id}/like/{userId}")
    public void deleteLike(@PathVariable Integer id, Integer userId) {
        filmService.deleteLike(id, userId);
    }

    @GetMapping("/films/popular?count={count}")
    public void getTopFilm(@RequestParam(defaultValue = "10", required = false) int count) {
        filmService.getTopFilm(count);
    }
}
