package guru.springframework.recipeappspring.repositories;

import guru.springframework.recipeappspring.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
