package com.example.lr1.controller

import com.example.lr1.entity.FilmEntity
import com.example.lr1.service.ActorService
import com.example.lr1.service.DirectorService
import com.example.lr1.service.FilmService
import com.example.lr1.service.GenreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

/**
 * контроллер фильмов
 * */
@Controller
class FilmController(
    private val filmService: FilmService,
    private val genreService: GenreService,
    private val directorService: DirectorService,
    private val actorService: ActorService,
) {

    @GetMapping("/")
    fun getDefault(model: Model):String{
        return getFilms(model)
    }

    @GetMapping("/films")
    fun getFilms(model: Model):String{
        model["films_list"] = filmService.getAll()
        return "films"
    }

    @GetMapping("/films/{idFilm}")
    fun getFilm(@PathVariable idFilm: Long, model: Model): String {
        model["film"] = filmService.getById(idFilm)
        return "film_info"
    }

    @GetMapping("films/film_create")
    fun createFilmForm(model: Model): String{
        model["film"] = FilmEntity()
        model["genres_list"] = genreService.getAll()
        model["directors_list"] = directorService.getAll()
        model["actors_list"] = actorService.getAll()
        return "film_edit"
    }

    @PostMapping("/films/film_create")
    fun createFilm(film: FilmEntity): String{
        filmService.save(film)
        return "redirect:/films"
    }

    @GetMapping("/films/film_edit/{idFilm}")
    fun editFilmForm(@PathVariable idFilm: Long, model: Model): String{
        model["film"] = filmService.getById(idFilm)
        model["genres_list"] = genreService.getAll()
        model["directors_list"] = directorService.getAll()
        model["actors_list"] = actorService.getAll()
        return "film_edit"
    }

    @PostMapping("/films/film_edit")
    fun saveFilm(film: FilmEntity): String{
        filmService.save(film)
        return "redirect:/films"
    }

    @GetMapping("/films/film_delete/{idFilm}")
    fun deleteFilm(@PathVariable idFilm: Long, model: Model): String {
        filmService.deleteById(idFilm)
        model["films_list"] = filmService.getAll()
        return "redirect:/films"
    }

}