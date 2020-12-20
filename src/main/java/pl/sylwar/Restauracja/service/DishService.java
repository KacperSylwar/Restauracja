package pl.sylwar.Restauracja.service;

import pl.sylwar.Restauracja.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getDishes();
    List<Dish> findDish(String name);
    Dish findDishByName(String name);
    void toggleOrdered(Dish dish);
    List<Dish> findOrdered();
    void changeDescription(Dish dish);

    void changeCategory(Dish dish);
    Integer fullPrice();
    List<Dish> findDishInOrdered(String name);
}
