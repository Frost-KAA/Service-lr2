package com.example.lr1.service

import com.example.lr1.entity.ActorEntity
import com.example.lr1.entity.GenreEntity

/**
 * описание сервиса по работе с актерами
 * */
interface ActorService {
    fun getAll(): MutableList<ActorEntity>

    fun getById(id: Long): ActorEntity

    fun deleteById(id: Long)

    fun save(actor: ActorEntity)
}