package guru.springframework.recipeappspring.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {
    Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();
    }
    @Test
    void getId() {
        Long idTest = 4L;
        category.setId(idTest);

        assertEquals(idTest, category.getId());
    }

    @Test
    void getDescription() {
        String des = "Hello, it's a test";
        category.setDescription(des);
        assertEquals(des, category.getDescription());
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
    }
}