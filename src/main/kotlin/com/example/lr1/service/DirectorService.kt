package com.example.lr1.service

import com.example.lr1.entity.DirectorEntity
import com.example.lr1.entity.FilmEntity

/**
 * описание сервиса по работе с режиссерами
 * */
interface DirectorService {
    fun getAll(): MutableList<DirectorEntity>

    fun getById(id: Long): DirectorEntity

    fun deleteById(id: Long)

    fun save(director: DirectorEntity)

}