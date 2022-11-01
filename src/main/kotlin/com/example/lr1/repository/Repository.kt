package com.example.lr1.repository

import com.example.lr1.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * описание репозиторией фильмов, жанров и режиссеров (паттерн Repository)
 * */
@Repository
interface FilmRepository: JpaRepository<FilmEntity, Long>

@Repository
interface GenreRepository: JpaRepository<GenreEntity, Long>

@Repository
interface DirectorRepository: JpaRepository<DirectorEntity, Long>

@Repository
interface ActorRepository: JpaRepository<ActorEntity, Long>

@Repository
interface ViewRepository: JpaRepository<ViewCount, Long>