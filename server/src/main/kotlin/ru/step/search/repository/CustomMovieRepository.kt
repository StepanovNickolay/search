package ru.step.search.repository

import org.elasticsearch.index.query.MultiMatchQueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.stereotype.Component

interface CustomMovieRepository{
    fun <T> fullTextSearch(fields: List<String>, value: String, result: Class<T>, pageable: Pageable, fuzziness: Int = 2, slop: Int = 2): Page<T>
}

@Component
class MovieESRepositoryImpl(
        val elasticsearchTemplate: ElasticsearchTemplate
): CustomMovieRepository {
    override fun <T> fullTextSearch(fields: List<String>, value: String, result: Class<T>, pageable: Pageable, fuzziness: Int, slop: Int): Page<T> {
        val query = NativeSearchQueryBuilder()
                .withQuery(
                        QueryBuilders.multiMatchQuery(value)
                                .fields(
                                        fields.associateWith { 1.0f }
                                )
                                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
                                .fuzziness(fuzziness)
                                .slop(slop)

                )
                .withPageable(pageable)
                .build()
        return elasticsearchTemplate.queryForPage(query, result)
    }

}
