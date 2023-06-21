package practise.bookstore.author.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import practise.models.author.Author;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void testCreateAuthor() {
        Author author = new Author();
        author.setFirstName("Lev");
        author.setLastName("Tolstoi");
        author.setDateOfBirth(LocalDate.of(1828, Month.SEPTEMBER, 9));
        author.setGender("Male");
        Author savedAuthor = authorRepository.save(author);
        assertThat(savedAuthor.getId()).isNotNull();
    }

    @Test
    void testFindAuthorByID() {
        Optional <Author> optional = authorRepository.findById(1);
        assertThat(optional).isPresent();
    }

    @Test
    void testUpdateAuthorByID() {
        Optional <Author> optional = authorRepository.findById(1);
        assertThat(optional).isPresent();
        Author author = optional.get();
        author.setGender("Female");
        assertThat(author.getGender()).isEqualTo("Female");
    }

    @Test
    void testDeleteAuthorByID() {
        Integer author_id = 2;
        authorRepository.deleteById(author_id);
        Optional <Author> byId = authorRepository.findById(author_id);
        assertThat(byId).isNotPresent();
    }


}