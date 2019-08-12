package ru.step.search.service.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.step.search.model.Movie
import ru.step.search.repository.MovieESRepository
import ru.step.search.service.MovieService
import java.util.*

@Service
class MovieServiceImpl(
        val movieESRepository: MovieESRepository
) : MovieService {
    override fun getAll(pageable: Pageable) = movieESRepository.findAll(pageable)

    override fun getById(id: UUID) = movieESRepository.findById(id)

    override fun search(search: String, pageable: Pageable) = movieESRepository.findAllByTitleIsLike(search, pageable)
}
