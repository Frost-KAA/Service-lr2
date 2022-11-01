package com.example.lr1.service

import com.example.lr1.entity.DirectorEntity
import com.example.lr1.entity.FilmEntity
import com.example.lr1.repository.DirectorRepository
import org.springframework.stereotype.Service

/**
 * реализация сервиса по работе с режиссерами
 * */
@Service
class DirectorServiceImpl(private val directorRepository: DirectorRepository): DirectorService {

    override fun getAll(): MutableList<DirectorEntity> {
        return directorRepository.findAll()
    }

    override fun getById(id: Long): DirectorEntity {
        return directorRepository.findById(id).orElseThrow()
    }

    override fun deleteById(id: Long){
        directorRepository.deleteById(id)
    }

    override fun save(director: DirectorEntity) {
        directorRepository.save(director)
    }
}