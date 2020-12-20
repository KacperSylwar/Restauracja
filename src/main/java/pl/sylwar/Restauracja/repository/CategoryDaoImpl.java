package pl.sylwar.Restauracja.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sylwar.Restauracja.model.Category;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createCategory(Category category) {

    }

    @Override
    public List<Category> findAllCategoriess() {
        String sql = "SELECT * FROM restaurant.category";

        List<Category> categories = jdbcTemplate.query(sql,(rs, rowNum)->
                new Category(rs.getLong("id"),
                        rs.getString("name")));
        return categories;
    }

    @Override
    public void updateCategory(Long id) {

    }

    @Override
    public void deleteCategory(Long id) {

    }

//    public void createCategory(){
//        List<Category> categories = new ArrayList<>();
//        categories.add(new Category(1l,"Przystawki"));
//        categories.add(new Category(2l,"Zupy"));
//
//        for(Category category:categories){
//            String sql ="INSERT INTO category VALUES(null ,?)";
//            jdbcTemplate.update(sql, category.getId() , category.getName());
//        }
//    }
}
