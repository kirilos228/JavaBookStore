package practise.bookstore.category.service;

import practise.models.Category;

public interface CategoryService {

    Iterable <Category> findAll();

    Category findById(Integer id);

    Category save(Category author);

    Category update(Integer id, Category author);

    void deleteById(Integer id);

}
