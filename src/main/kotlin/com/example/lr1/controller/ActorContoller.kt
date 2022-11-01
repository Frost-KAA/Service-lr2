package com.example.lr1.controller

import com.example.lr1.entity.ActorEntity
import com.example.lr1.service.ActorService
import com.example.lr1.service.FilmService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


/**
 * контроллер актеров
 * */
@Controller
class ActorController(
    private val actorService: ActorService,
    private val filmService: FilmService
) {

    @GetMapping("/actors")
    fun getActors(model: Model):String{
        model["actors_list"] = actorService.getAll()
        return "actors"
    }

    @GetMapping("/actors/{idActor}")
    fun getActor(@PathVariable idActor: Long, model: Model): String {
        model["actor"] = actorService.getById(idActor)
        return "actor_info"
    }

    @GetMapping("/actors/actor_edit/{idActor}")
    fun editActorForm(@PathVariable idActor: Long, model: Model): String{
        model["actor"] = actorService.getById(idActor)
        model["films_list"] = filmService.getAll()
        return "actor_edit"
    }

    @PostMapping("/actors/actor_edit")
    fun saveActor(actor: ActorEntity): String{
        actorService.save(actor)
        return "redirect:/actors"
    }

    @GetMapping("/actors/actor_create")
    fun createActorForm( model: Model): String{
        model["actor"] = ActorEntity()
        model["films_list"] = filmService.getAll()
        return "actor_edit"
    }

    @PostMapping("/actors/actor_create")
    fun createActor(actor: ActorEntity): String{
        actorService.save(actor)
        return "redirect:/actors"
    }

    @GetMapping("/actors/actor_delete/{idActor}")
    fun deleteActor(@PathVariable idActor: Long): String {
        actorService.deleteById(idActor)
        return "redirect:/actors"
    }


}
