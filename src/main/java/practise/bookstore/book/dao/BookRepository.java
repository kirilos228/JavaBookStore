package practise.bookstore.book.dao;

import org.springframework.data.repository.CrudRepository;
import practise.models.Book;

public interface BookRepository extends CrudRepository <Book, Integer> {

}
