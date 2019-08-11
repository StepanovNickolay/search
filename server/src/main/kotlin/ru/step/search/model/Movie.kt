package ru.step.search.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.util.*

@Document(indexName = "movie")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Movie(
        @Id
        val id: UUID = UUID.randomUUID(),

        val title: String = "",

        val year: Int? = null,

        val genres: List<String> = listOf(),

        val ratings: List<Int> = listOf(),

        val poster: String? = null,

        val duration: String = "",

        val releaseDate: String = "",

        val storyLine: String = "",

        val actors: List<String> = listOf(),

        val imdbRating: Double? = null,

        val posterUrl: String? = null
)

enum class Genre {
    Horror,
    Mystery,
    Crime,
    Drama
}