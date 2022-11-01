package com.example.lr1.entity

import javax.persistence.*

/**
 * описание сущности "Фильм"
 * */
@Entity
data class FilmEntity (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var idFilm: Long = 0,
        var nameFilm: String = "",
        var descFilm: String = "",
        var yearFilm: Int = 0,
        var runtimeFilm: Int = 0,
        var scoreFilm: Float = 0f,

        @ManyToMany
        @JoinTable (
                name = "FILM_GENRE",
                joinColumns = [JoinColumn(name = "idFilm")],
                inverseJoinColumns = [JoinColumn(name="idGenre")]
                )
        var genres: MutableList <GenreEntity> = mutableListOf(),

        @ManyToMany
        @JoinTable (
                name = "FILM_ACTOR",
                joinColumns = [JoinColumn(name = "idFilm")],
                inverseJoinColumns = [JoinColumn(name="idActor")]
        )

        var actors: MutableList <ActorEntity> = mutableListOf(),

        @ManyToOne(
                targetEntity = DirectorEntity::class,
                cascade = [ CascadeType.PERSIST],
                fetch = FetchType.LAZY
        )
        var directorFilm: DirectorEntity = DirectorEntity()
){
        @Override
        override fun toString(): String {
                return this::class.simpleName + "(nameFilm = $nameFilm)"
        }
}