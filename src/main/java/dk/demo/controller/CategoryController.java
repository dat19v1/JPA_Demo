package dk.demo.controller;

import dk.demo.model.Category;
import dk.demo.model.Recipe;
import dk.demo.repository.CategoryRepository;
import dk.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/")
    public String index(){

        for (Category c: categoryRepository.findAll()) {
            System.out.println(c.getDescription());
        }

        return "index";
    }

    @GetMapping("/one")
    public String one(){

        System.out.println(categoryRepository.findById(Integer.toUnsignedLong(1)).get().getDescription());

        return "index";
    }


    @GetMapping("/catdesc")
    public String getCat(){
        System.out.println(categoryRepository.findByDescription("Mexican").get().getDescription());
        return "index";
    }


    @GetMapping("/recipe")
    public String getRecipe(){
        System.out.println(recipeRepository.findByCookTime(20).get().getNotes().getDescription());
        return "index";
    }

    @GetMapping("/category")
    public String insertCat(Model model){
        model.addAttribute(new Category());
        return "category";
    }
    @PostMapping("/category")
    public String insertCat(@ModelAttribute Category cat){

        categoryRepository.save(cat);
        return "redirect:/";
    }




}
