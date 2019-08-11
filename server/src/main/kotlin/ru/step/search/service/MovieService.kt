package ru.step.search.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.step.search.model.Movie
import java.util.*

interface MovieService {
    fun getAll(pageable: Pageable): Page<Movie>

    fun getById(id: UUID): Optional<Movie>
}