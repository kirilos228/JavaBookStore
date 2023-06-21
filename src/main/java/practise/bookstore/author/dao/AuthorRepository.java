package practise.bookstore.author.dao;

import org.springframework.data.repository.CrudRepository;
import practise.models.author.Author;

public interface AuthorRepository extends CrudRepository <Author, Integer> {
}
