package pl.sylwar.Restauracja.repository;

import pl.sylwar.Restauracja.model.Category;

import java.util.List;

public interface CategoryDao {
    void createCategory(Category category);
    List<Category> findAllCategoriess();
    void updateCategory(Long id);
    void deleteCategory(Long id);
}
