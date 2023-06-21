package practise.bookstore.author.service;

import org.springframework.stereotype.Service;
import practise.bookstore.author.dao.AuthorRepository;
import practise.models.author.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable <Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Integer id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Integer id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }
}
