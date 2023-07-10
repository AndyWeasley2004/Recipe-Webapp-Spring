package guru.springframework.recipeappspring.controllers;

import guru.springframework.recipeappspring.domain.Recipe;
import guru.springframework.recipeappspring.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new RecipeController(recipeService);
    }

    @Test
    void showById() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(5L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(recipeService.getById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/5"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));

    }
}