package org.example.SpringBootApplication.controllers;

import org.example.SpringBootApplication.dto.News;
import org.example.SpringBootApplication.services.NewsCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/news/")
public class NewsController {
    private final NewsCRUDService newsService;

    public NewsController(NewsCRUDService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("{id}")
    public ResponseEntity getNew(@PathVariable Long id) {
        if (newsService.getById(id) == null) {
            return new ResponseEntity<>("\"message\": \"Новость с ID " + id + " не найдена.\"", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newsService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public Collection getALLNews() {
        return newsService.getALL();
    }

    @PostMapping
    public ResponseEntity createNews(@RequestBody News news) {
        newsService.create(news);
        return new ResponseEntity(news, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateNews(@RequestBody News news) {
        newsService.update(news);
        return new ResponseEntity(news, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteNews(@PathVariable Long id) {
        if (newsService.getById(id) != null){
            newsService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("\"message\": \"Новость с ID " + id + " не найдена.\"", HttpStatus.NOT_FOUND);    }

    @ResponseStatus
    public ResponseEntity goodStatus() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseStatus
    public ResponseEntity badStatus() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
