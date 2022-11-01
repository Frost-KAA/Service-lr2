package com.example.lr1.entity

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import javax.persistence.*

/**
 * описание сущности "Актер"
 * */
@Entity
data class ActorEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idActor: Long = 0,
    var nameActor: String = "",
    var surnameActor: String = "",
    var birthdayActor: LocalDate = LocalDate.parse("1900-01-01"),

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [ CascadeType.PERSIST],
    )
    @JoinTable (
        name = "FILM_ACTOR",
        joinColumns = [JoinColumn(name = "idActor")],
        inverseJoinColumns = [JoinColumn(name="idFilm")]
    )
    var films: MutableList <FilmEntity> = mutableListOf()
)


