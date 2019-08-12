package ru.step.search.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository
import ru.step.search.model.Movie
import java.util.*

@Repository
interface MovieESRepository: ElasticsearchRepository<Movie, UUID>{
    fun findAllByTitleIsLike(title: String, pageable: Pageable): Page<Movie>
}
