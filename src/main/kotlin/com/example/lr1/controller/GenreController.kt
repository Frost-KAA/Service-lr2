package com.example.lr1.controller

import com.example.lr1.entity.DirectorEntity
import com.example.lr1.entity.FilmEntity
import com.example.lr1.entity.GenreEntity
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
 * контроллер жанров
 * */
@Controller
class GenreController(
    private val genreService: GenreService,
    private val filmService: FilmService
) {

    @GetMapping("/genres")
    fun getGenres(model: Model):String{
        model["genres_list"] = genreService.getAll()
        return "genres"
    }

    @GetMapping("/genres/{idGenre}")
    fun getGenre(@PathVariable idGenre: Long, model: Model): String {
        model["genre"] = genreService.getById(idGenre)
        return "genre_info"
    }

    @GetMapping("/genres/genre_edit/{idGenre}")
    fun editGenreForm(@PathVariable idGenre: Long, model: Model): String{
        model["genre"] = genreService.getById(idGenre)
        model["films_list"] = filmService.getAll()
        return "genre_edit"
    }

    @PostMapping("/genres/genre_edit")
    fun saveGenre(genre: GenreEntity): String{
        genreService.save(genre)
        return "redirect:/genres"
    }

    @GetMapping("/genres/genre_create")
    fun createGenreForm( model: Model): String{
        model["genre"] = GenreEntity()
        model["films_list"] = filmService.getAll()
        return "genre_edit"
    }

    @PostMapping("/genres/genre_create")
    fun createGenre(genre: GenreEntity): String{
        genreService.save(genre)
        return "redirect:/genres"
    }

    @GetMapping("/genres/genre_delete/{idGenre}")
    fun deleteGenre(@PathVariable idGenre: Long): String {
        genreService.deleteById(idGenre)
        return "redirect:/genres"
    }


}
