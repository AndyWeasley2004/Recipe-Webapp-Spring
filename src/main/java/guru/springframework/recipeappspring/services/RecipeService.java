package guru.springframework.recipeappspring.services;

import guru.springframework.recipeappspring.commands.RecipeCommand;
import guru.springframework.recipeappspring.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    public Recipe getById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    RecipeCommand findCommandById(Long id);

    void deleteById(Long id);
}
