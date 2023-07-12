package guru.springframework.recipeappspring.controllers;

import guru.springframework.recipeappspring.commands.RecipeCommand;
import guru.springframework.recipeappspring.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.getById(Long.valueOf(id)));
        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        System.out.println("Form created");
        return "recipe/recipeForm";
    }

    @PostMapping("recipe/show")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        System.out.println("redirect:/recipe/" + savedCommand.getId() + "/show");
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @RequestMapping({"/recipe/{id}/update"})
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeForm";
    }
}
