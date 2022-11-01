package com.example.lr1.controller

import com.example.lr1.entity.DirectorEntity
import com.example.lr1.entity.FilmEntity
import com.example.lr1.service.DirectorService
import com.example.lr1.service.FilmService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


/**
 * контроллер режиссеров
 * */
@Controller
class DirectorController(
    private val directorService: DirectorService,
    private val filmService: FilmService
) {

    @GetMapping("/directors")
    fun getDirectors(model: Model):String{
        model["directors_list"] = directorService.getAll()
        return "directors"
    }

    @GetMapping("/directors/{idDirector}")
    fun getDirector(@PathVariable idDirector: Long, model: Model): String {
        model["director"] = directorService.getById(idDirector)
//        model["dir_films"] = directorService.getFilmList(idDirector)
        return "director_info"
    }

    @GetMapping("/directors/director_edit/{idDirector}")
    fun editDirectorForm(@PathVariable idDirector: Long, model: Model): String{
        model["director"] = directorService.getById(idDirector)
        model["films_list"] = filmService.getAll()
        return "director_edit"
    }

    @PostMapping("/directors/director_edit")
    fun saveDirector(director: DirectorEntity): String{
        directorService.save(director)
        return "redirect:/directors"
    }

    @GetMapping("/directors/director_create")
    fun createDirectorForm( model: Model): String{
        model["director"] = DirectorEntity()
        model["films_list"] = filmService.getAll()
        return "director_edit"
    }

    @PostMapping("/directors/director_create")
    fun createDirector(director: DirectorEntity): String{
        directorService.save(director)
        return "redirect:/directors"
    }

    @GetMapping("/directors/director_delete/{idDirector}")
    fun deleteDirector(@PathVariable idDirector: Long): String {
        directorService.deleteById(idDirector)
        return "redirect:/directors"
    }


}
