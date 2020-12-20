package pl.sylwar.Restauracja.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sylwar.Restauracja.model.Dish;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishDaoImpl implements DishDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DishDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createDish(Dish dish) {
        String sql = "INSERT INTO dishes VALUES(null,?,?,?,?,?) ";
        jdbcTemplate.update(sql,dish.getName(), dish.getDescription(),dish.isOrdered(),dish.getCategoryId(),dish.getPrice());

    }

    @Override
    public List<Dish> findAllDishes() {
        String sql = "SELECT * FROM dishes";

        List<Dish> dishes = jdbcTemplate.query(sql,(rs, rowNum) ->
        new Dish
                (rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getBoolean("ordered"),
                rs.getLong("category_id"),
                rs.getInt("price"))
                        );
        return dishes;
    }

    @Override
    public void updateGif(Dish dish) {
        if(dish.isOrdered() != null){
            String sql = "UPDATE dishes d SET d.ORDERED = " + dish.isOrdered() + " WHERE d.ID = ?";
            jdbcTemplate.update(sql , dish.getId());
        }if(dish.getCategoryId() !=null) {
            String sql = "UPDATE dishes d SET d.CATEGORY_ID = " + dish.getCategoryId() + " WHERE d.ID = ? ";
            jdbcTemplate.update(sql, dish.getId());
        }
    }

    @Override
    public Dish findDishByNameSql(String name) {
        String sql = "SELECT * FROM dishes d WHERE d.NAME = '" + name + "' LIMIT 1";

        Dish dishes = jdbcTemplate.queryForObject(sql,(rs, rowNum) ->
                new Dish(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getBoolean("ordered"),
                                rs.getLong("category_id"),
                                rs.getInt("price"))
        );
        return dishes;
    }



//    public void createDish(){
//        List<Dish> dishes = new ArrayList<>();
//        dishes.add(new Dish(1l,"Kotlet","Bardzo dobry kotlet schabowy",true,1l,26));
//        dishes.add(new Dish(2l,"Kotlet1","Bardzo dobry kotlet schabowy",false,2l,35));
//        dishes.add(new Dish(3l,"Kotlet2","Bardzo dobry kotlet schabowy",true,1l,26));
//        dishes.add(new Dish(4l,"Kotlet3","Bardzo dobry kotlet schabowy",false,2l,30));
//
//        for (Dish dish : dishes){
//            String sql = "INSERT INTO dishes VALUES(null,?,?,?,?,?) ";
//            jdbcTemplate.update(sql,dish.getName(), dish.getDescription(),dish.isOrdered(),dish.getCategoryId(),dish.getPrice());
//        }
//    }
}
