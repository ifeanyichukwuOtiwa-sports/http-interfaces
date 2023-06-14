package dev.regent.contentservice.web;

import dev.regent.articles.model.api.Article;
import dev.regent.contentservice.service.ArticleClientApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contents")
@RequiredArgsConstructor
public class ContentController {
    private final ArticleClientApi articleClientApi;

    @GetMapping("/articles")
    public List<Article> findAll() {
        return articleClientApi.findAll();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> findById(@PathVariable final Integer id) {
        return articleClientApi.findOne(id);
    }

    @PostMapping("/articles")
    public void create(@RequestBody final Article article) {
        articleClientApi.create(article);
    }

    @PutMapping("/articles/{id}")
    public void update(@RequestBody final Article article, final Integer id) {
        articleClientApi.update(article, id);
    }

    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable final Integer id) {
        articleClientApi.delete(id);
    }
}
