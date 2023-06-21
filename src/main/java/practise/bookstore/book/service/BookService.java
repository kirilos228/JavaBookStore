package practise.bookstore.book.service;


import practise.models.Book;

public interface BookService{

    Iterable <Book> findAll();

    Book findById(Integer id);

    Book save(Book author);

    Book update(Integer id, Book author);

    void deleteById(Integer id);

}
