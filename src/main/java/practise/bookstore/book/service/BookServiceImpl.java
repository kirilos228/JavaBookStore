package practise.bookstore.book.service;

import org.springframework.stereotype.Service;
import practise.bookstore.book.dao.BookRepository;
import practise.models.Book;

import java.time.LocalDateTime;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable <Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book save(Book book) {
        book.setUpdatedBy("Kirill");
        book.setUpdatedDate(LocalDateTime.now());
        book.setCreatedBy("Kirill");
        book.setCreatedDate(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public Book update(Integer id, Book book) {
        Book book_from_db = bookRepository.findById(id).get();
        book.setId(id);
        book.setUpdatedBy("Kirill");
        book.setUpdatedDate(LocalDateTime.now());
        book.setCreatedBy(book_from_db.getCreatedBy());
        book.setCreatedDate(book.getCreatedDate());
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

}
