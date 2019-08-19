package ru.step.search.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.step.search.model.Movie

interface MovieService {
    fun getAll(pageable: Pageable): Page<Movie>

    fun search(search: String, pageable: Pageable): Page<Movie>
}
