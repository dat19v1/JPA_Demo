package dk.demo.controller;

import dk.demo.model.Category;
import dk.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

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
        return
    }

}
