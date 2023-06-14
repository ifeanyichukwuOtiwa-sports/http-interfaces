package dev.regent.contentservice.service;

import dev.regent.articles.model.api.Article;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;
import java.util.Optional;

public interface ArticleClientApi {

    @GetExchange("/articles")
    List<Article> findAll();

    @GetExchange("/articles/{id}")
    Optional<Article> findOne(@PathVariable final Integer id);

    @PostExchange("/articles")
    void create(@RequestBody final Article article);

    @PutExchange("/articles/{id}")
    void update(@RequestBody final Article article, @PathVariable final Integer id);

    @DeleteExchange("/articles/{id}")
    void delete(@PathVariable final Integer id);
}
