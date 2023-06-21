package practise.bookstore.book.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practise.bookstore.book.service.BookService;
import practise.models.Book;

@RestController
@RequestMapping(value = "/api/books")
public class BookRestController {

    BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity <Iterable <Book>> findAll() {
        Iterable <Book> authors = bookService.findAll();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public Book find(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PostMapping
    public ResponseEntity <Book> save(@RequestBody Book author) {
        return ResponseEntity.ok(bookService.save(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Book> update(@PathVariable Integer id, @RequestBody Book author) {
        return ResponseEntity.ok(bookService.update(id, author));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.deleteById(id);
    }

}
