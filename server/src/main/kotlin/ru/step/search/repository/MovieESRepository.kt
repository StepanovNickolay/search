package ru.step.search.repository

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository
import ru.step.search.model.Movie
import java.util.*

@Repository
interface MovieESRepository: ElasticsearchRepository<Movie, UUID>