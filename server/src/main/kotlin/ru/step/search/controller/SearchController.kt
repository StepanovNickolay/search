package ru.step.search.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.step.search.model.Movie
import ru.step.search.service.MovieService
import java.util.*

@RestController
@CrossOrigin
@RequestMapping(path = ["/v1/movies"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
@Api(tags = ["Контроллер фильмов"])
class SearchController(
        val movieService: MovieService
){
    @GetMapping
    @ApiOperation("Получить все")
    fun getAll(pageable: Pageable): Page<Movie> {
        return movieService.getAll(pageable)
    }

    @GetMapping("/{id}")
    @ApiOperation("Получить все")
    fun getById(@PathVariable id: UUID): Movie? {
        return movieService.getById(id).orElse(null)
    }
}
