package guru.springframework.recipeappspring.controllers;

import guru.springframework.recipeappspring.commands.RecipeCommand;
import guru.springframework.recipeappspring.exceptions.NotFoundException;
import guru.springframework.recipeappspring.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.getById(Long.valueOf(id)));

        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        log.debug("Form created");
        return "recipe/recipeForm";
    }

    @GetMapping({"recipe/{id}/update"})
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        log.debug("Updating recipe " + Long.valueOf(id));
        return "recipe/recipeForm";
    }

    @PostMapping("recipe/")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }


    @GetMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        recipeService.deleteById(Long.valueOf(id));
        log.debug("Deleting id: " + id);
        return "redirect:/";
    }

    // handle exception
    @ResponseStatus(HttpStatus.NOT_FOUND) // handler has higher precedence
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){
        log.error("Handle not found exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) // handler has higher precedence
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleBadNumberFormat(Exception exception){
        log.error("Handle Number Format Exception");
        log.error(exception.getMessage());
        String errorMessage = exception.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("numberFormatError");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("message", errorMessage);
        return modelAndView;
    }
}
