package practise.bookstore.category.service;

import org.springframework.stereotype.Service;
import practise.bookstore.category.dao.CategoryRepository;
import practise.models.Category;

import java.time.LocalDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable <Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category save(Category category) {
        category.setCreatedBy("Kirill");
        category.setCreatedDate(LocalDateTime.now());
        category.setUpdatedBy("Kirill");
        category.setUpdatedDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Integer id, Category category) {
        Category category_from_db = categoryRepository.findById(id).get();
        category.setId(id);
        category.setUpdatedBy("Kirill");
        category.setUpdatedDate(LocalDateTime.now());
        category.setCreatedDate(category_from_db.getCreatedDate());
        category.setCreatedBy(category_from_db.getCreatedBy());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

}
