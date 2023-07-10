package guru.springframework.recipeappspring.services;

import guru.springframework.recipeappspring.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    public Recipe getById(Long id);
}
