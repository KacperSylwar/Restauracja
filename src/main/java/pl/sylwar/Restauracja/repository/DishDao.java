package pl.sylwar.Restauracja.repository;

import pl.sylwar.Restauracja.model.Dish;

import java.util.List;

public interface DishDao {
    void createDish(Dish dish);
    List<Dish> findAllDishes();
    void updateGif(Dish dish);

   Dish findDishByNameSql(String name);
}
