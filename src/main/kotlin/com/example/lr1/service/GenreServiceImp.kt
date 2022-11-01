package com.example.lr1.service
import com.example.lr1.entity.FilmEntity
import com.example.lr1.entity.GenreEntity
import com.example.lr1.repository.GenreRepository
import com.example.lr1.service.GenreService
import org.springframework.stereotype.Service

/**
 * реализация сервиса по работе с режиссерами
 * */
@Service
class GenreServiceImpl(private val genreRepository: GenreRepository): GenreService {

    override fun getAll(): MutableList<GenreEntity> {
        return genreRepository.findAll()
    }

    override fun getById(id: Long): GenreEntity {
        return genreRepository.findById(id).orElseThrow()
    }

    override fun deleteById(id: Long){
        genreRepository.deleteById(id)
    }

    override fun save(genre: GenreEntity) {
        genreRepository.save(genre)
    }
}