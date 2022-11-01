package com.example.lr1.service

import com.example.lr1.entity.DirectorEntity
import com.example.lr1.entity.GenreEntity

/**
 * описание сервиса по работе с жанрами
 * */
interface GenreService {
    fun getAll(): MutableList<GenreEntity>

    fun getById(id: Long): GenreEntity

    fun deleteById(id: Long)

    fun save(genre: GenreEntity)
}