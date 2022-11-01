package com.example.lr1.entity

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import javax.persistence.*

/**
 * описание сущности "Режиссер"
 * */
@Entity
data class DirectorEntity (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var idDirector: Long = 0,
        var nameDirector: String = "",
        var surnameDirector: String = "",
        var birthdayDirector: LocalDate = LocalDate.parse("1900-01-01"),
        var careerDirector: LocalDate = LocalDate.parse("1900-01-01"),

        @OneToMany(
                targetEntity = FilmEntity::class,
                cascade = [ CascadeType.ALL],
                fetch = FetchType.LAZY,
                mappedBy="directorFilm"
        )
        var films: MutableList <FilmEntity> = mutableListOf()
){
        @Override
        override fun toString(): String {
                return this::class.simpleName + "(nameDirector = $nameDirector)"
        }
}


