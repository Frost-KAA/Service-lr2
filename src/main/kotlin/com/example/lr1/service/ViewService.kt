package com.example.lr1.service

import com.example.lr1.entity.GenreEntity
import com.example.lr1.entity.ViewCount
import javax.swing.text.View

/**
 * описание сервиса по работе с представлением
 * */
interface ViewService {
    fun getAll(): MutableList<ViewCount>

    fun getById(id: Long): ViewCount
}