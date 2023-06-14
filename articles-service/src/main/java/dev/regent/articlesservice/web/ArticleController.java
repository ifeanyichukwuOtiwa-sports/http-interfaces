package dev.regent.articlesservice.web;

import dev.regent.articles.model.api.Article;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private static final List<Article> articles = new ArrayList<>();

    @PostConstruct
    private void init() {
        final Article article = new Article(1, "Hello, World", "This is my first blog post");
        articles.add(article);
    }

    @GetMapping
    public List<Article> findAll() {
        return articles;
    }

    @GetMapping("/{id}")
    public Optional<Article> findById(@PathVariable final Integer id) {
        return articles.stream().filter(article -> article.id().equals(id)).findFirst();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Article article) {
        articles.add(article);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable final Integer id, @RequestBody final Article article) {
        final Optional<Article> currentArticle = articles.stream().filter(a -> a.id().equals(id)).findFirst();
        currentArticle.ifPresent(a -> articles.set(articles.indexOf(a), article));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Integer id) {
        articles.removeIf(a -> a.id().equals(id));
    }
}
