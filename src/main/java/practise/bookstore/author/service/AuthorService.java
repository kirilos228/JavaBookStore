package practise.bookstore.author.service;

import practise.models.author.Author;

public interface AuthorService{

    Iterable <Author> findAll();

    Author findById(Integer id);

    Author save(Author author);

    Author update(Integer id, Author author);

    void deleteById(Integer id);

}
