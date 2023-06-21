package practise.bookstore.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practise.bookstore.category.service.CategoryService;
import practise.models.Category;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryRestController{

    CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity <Iterable <Category>> findAll() {
        Iterable <Category> authors = categoryService.findAll();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public Category find(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity <Category> save(@RequestBody Category author) {
        return ResponseEntity.ok(categoryService.save(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Category> update(@PathVariable Integer id, @RequestBody Category author) {
        return ResponseEntity.ok(categoryService.update(id, author));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
    }

}
