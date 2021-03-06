package dk.demo.repository;

import dk.demo.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByCookTime(Integer cooktime);

}
