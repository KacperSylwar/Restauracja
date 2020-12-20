package pl.sylwar.Restauracja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sylwar.Restauracja.model.Category;
import pl.sylwar.Restauracja.repository.CategoryDao;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAllCategoriess();
    }
}
