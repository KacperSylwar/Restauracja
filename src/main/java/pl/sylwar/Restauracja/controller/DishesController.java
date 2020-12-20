package pl.sylwar.Restauracja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sylwar.Restauracja.model.Category;
import pl.sylwar.Restauracja.model.Dish;
import pl.sylwar.Restauracja.service.CategoryService;
import pl.sylwar.Restauracja.service.DishService;

import java.util.List;

@Controller
public class DishesController {

    private DishService dishService;
    private CategoryService categoryService;

    @Autowired
    public DishesController(DishService dishService, CategoryService categoryService) {
        this.dishService = dishService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String q){
        if(q == null){
            model.addAttribute("dishes", dishService.getDishes());
        }else{
            model.addAttribute("dishes",dishService.findDishByName(q));
        }
        return "home";
    }

    @GetMapping("/dish/{name}")
    public String getDish(Model model, @PathVariable String name){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("editedDish", dishService.findDishByName(name));
        return "dish-details";
    }


    @PostMapping ("/dish/{name}")
    public String changeDescription(@ModelAttribute Dish editedDish){
        dishService.changeDescription(editedDish);
        return "redirect:/dish/{name}";
    }

    @PostMapping("/dish/{name}/updateCategory")
    public String changeCategory(@ModelAttribute Dish editedDish){
        dishService.changeCategory(editedDish);
        return "redirect:/dish/{name}";
    }

    @GetMapping("/ordered")
    public String getOrdered(Model model) {
        model.addAttribute("orderedDishes", dishService.findOrdered());
        model.addAttribute("fullPrice",dishService.fullPrice());
        return "ordered";
    }

    @GetMapping("/dish/{name}/ordered")
    public String toggleOrder(@PathVariable String name, @RequestParam(required = false, defaultValue = "") String r) {
        Dish dish = dishService.findDishByName(name);
        dishService.toggleOrdered(dish);
        if (r.equals("details")) {
            return "redirect:/dish/{name}";
        } else if (r.equals("ordered")) {
            return "redirect:/ordered";
        } else {
            return "redirect:/";
        }
    }


}
