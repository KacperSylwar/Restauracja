package pl.sylwar.Restauracja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sylwar.Restauracja.model.Dish;
import pl.sylwar.Restauracja.repository.DishDao;
//import pl.sylwar.Restauracja.repository.DishDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService{

    private DishDao dishDao;

    @Autowired
    public DishServiceImpl(DishDao dishDao){
        this.dishDao = dishDao;
    }

    @Override
    public List<Dish> getDishes() {
        return dishDao.findAllDishes();
    }

    @Override
    public List<Dish> findDish(String name) {
        return getDishes().stream().filter(dish -> dish.getPrice() !=null ? dish.getPrice().equals(name) : dish.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Dish findDishByName(String name) {
        return dishDao.findDishByNameSql(name);
    }

    @Override
    public void toggleOrdered(Dish dish) {
        dish.setOrdered(!dish.isOrdered());

        dish.setCategoryId(null);

        dishDao.updateGif(dish);

    }

    @Override
    public List<Dish> findOrdered() {
        return getDishes().stream().filter(Dish::isOrdered).collect(Collectors.toList());
    }

    @Override
    public void changeDescription(Dish dish) {
            dish.setOrdered(null);
            dish.setCategoryId(null);

            dishDao.updateGif(dish);
    }

    @Override
    public void changeCategory(Dish dish) {
        dish.setOrdered(null);
        dish.setDescription(null);
        dishDao.updateGif(dish);
    }

    @Override
    public Integer fullPrice() {
        List<Dish> ordered = findOrdered();
        Integer wynik=0;
        for (Dish dish : ordered) {
            wynik += dish.getPrice();
        }
        return wynik+10;
    }

    @Override
    public List<Dish> findDishInOrdered(String name) {
        return null;
    }

//    @Override
//    public List<Dish> findDishInOrdered(String name) {
//        return getDishes().stream().filter(dish -> (dish.getName().equals(name) ||  dish.getPrice().equals(name))&&(dish.findDishInOrdered()==true)).collect(Collectors.toList());
//    }

}

