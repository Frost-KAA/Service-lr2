package com.example.lr1.entity

import javax.persistence.*

/**
 * описание сущности "Жанр"
 * */
@Entity
data class GenreEntity (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var idGenre: Long = 0,
        var nameGenre: String = "",
        var descGenre: String = "",
        @ManyToMany(
                fetch = FetchType.EAGER,
                cascade = [ CascadeType.PERSIST],
        )
        @JoinTable (
                name = "FILM_GENRE",
                joinColumns = [JoinColumn(name = "idGenre")],
                inverseJoinColumns = [JoinColumn(name="idFilm")]
        )
        var films: MutableList <FilmEntity> = mutableListOf()
)