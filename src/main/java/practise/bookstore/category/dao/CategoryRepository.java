package practise.bookstore.category.dao;

import org.springframework.data.repository.CrudRepository;
import practise.models.Category;

public interface CategoryRepository extends CrudRepository <Category, Integer> {


}

