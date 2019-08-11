package ru.step.search.config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import ru.step.search.model.Movie
import ru.step.search.repository.MovieESRepository
import javax.annotation.PostConstruct

@Configuration
@EnableElasticsearchRepositories("ru.step.search.repository")
class ESConfig(
        val movieESRepository: MovieESRepository
) {
    @PostConstruct
    fun setUpESData() {
        movieESRepository.deleteAll()
        val testData = listOf("data/top-rated-movies-01.json", "data/top-rated-movies-02.json")
        testData.forEach { readFileAndSaveToES(it) }
    }


    private fun readFileAndSaveToES(fileName: String) {
        val jsonResource = ClassPathResource(fileName)
        val movies = jacksonObjectMapper().readValue<List<Movie>>(jsonResource.inputStream)
        movieESRepository.saveAll(movies)
    }
}