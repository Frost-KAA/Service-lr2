package com.example.lr1.service

import com.example.lr1.entity.GenreEntity
import com.example.lr1.entity.ViewCount
import com.example.lr1.repository.GenreRepository
import com.example.lr1.repository.ViewRepository
import org.springframework.stereotype.Service

/**
 * реализация сервиса по работе с представлением
 * */
@Service
class ViewServiceImpl(private val viewRepository: ViewRepository): ViewService {

    override fun getAll(): MutableList<ViewCount> {
        return viewRepository.findAll()
    }

    override fun getById(id: Long): ViewCount {
        return viewRepository.findById(id).orElseThrow()
    }
}