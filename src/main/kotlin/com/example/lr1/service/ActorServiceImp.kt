package com.example.lr1.service

import com.example.lr1.entity.ActorEntity
import com.example.lr1.entity.GenreEntity
import com.example.lr1.repository.ActorRepository
import com.example.lr1.repository.GenreRepository
import org.springframework.stereotype.Service

/**
 * реализация сервиса по работе с актерами
 * */
@Service
class ActorServiceImpl(private val actorRepository: ActorRepository): ActorService {

    override fun getAll(): MutableList<ActorEntity> {
        return actorRepository.findAll()
    }

    override fun getById(id: Long): ActorEntity {
        return actorRepository.findById(id).orElseThrow()
    }

    override fun deleteById(id: Long){
        actorRepository.deleteById(id)
    }

    override fun save(actor: ActorEntity) {
        actorRepository.save(actor)
    }
}