package practise.bookstore.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practise.bookstore.author.service.AuthorService;
import practise.models.author.Author;

@RestController
@RequestMapping(value = "/api/authors")
public class AuthorRestController {

    AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity <Iterable <Author>> findAll() {
        Iterable <Author> authors = authorService.findAll();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public Author find(@PathVariable Integer id) {
        return authorService.findById(id);
    }

    @PostMapping
    public ResponseEntity <Author> save(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.save(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Author> update(@PathVariable Integer id, @RequestBody Author author) {
        return ResponseEntity.ok(authorService.update(id, author));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        authorService.deleteById(id);
    }

}

