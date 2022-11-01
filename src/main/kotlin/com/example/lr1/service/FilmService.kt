package com.example.lr1.service

import com.example.lr1.entity.FilmEntity

/**
 * описание сервиса по работе с фильмами
 * */
interface FilmService {
    fun getAll(): MutableList<FilmEntity>

    fun getById(id: Long): FilmEntity

    fun deleteById(id: Long)

    fun save(film: FilmEntity)
}