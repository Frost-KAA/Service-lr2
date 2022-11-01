package com.example.lr1.controller

import com.example.lr1.service.ActorService
import com.example.lr1.service.FilmService
import com.example.lr1.service.ViewService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

/**
 * контроллер представления
 * */
@Controller
class ViewController(
    private val viewService: ViewService,
) {

    @GetMapping("/view")
    fun getActors(model: Model): String {
        model["view_list"] = viewService.getAll()
        return "view"
    }
}