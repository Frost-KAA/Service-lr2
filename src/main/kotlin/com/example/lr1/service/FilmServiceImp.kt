package com.example.lr1.service

import com.example.lr1.entity.FilmEntity
import com.example.lr1.repository.FilmRepository
import org.springframework.stereotype.Service

/**
 * реализация сервиса по работе с фильмами
 * */
@Service
class FilmServiceImpl(private val filmRepository: FilmRepository): FilmService {
    override fun getAll(): MutableList<FilmEntity> {
        return filmRepository.findAll()
    }

    override fun getById(id: Long): FilmEntity {
        return filmRepository.findById(id).orElseThrow()
    }

    override fun deleteById(id: Long){
       filmRepository.deleteById(id)
    }

    override fun save(film: FilmEntity) {
        filmRepository.save(film)
    }
}