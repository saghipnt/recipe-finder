package saghi.recipe.recipefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import saghi.recipe.recipefinder.model.Recipe;
import saghi.recipe.recipefinder.model.RecipeList;
import saghi.recipe.recipefinder.model.RecipeService;
import saghi.recipe.recipefinder.model.SearchDTO;


@RestController
@RequestMapping("/api/recipes")
public class Controller {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/search")
    public RecipeList searchRecipes(@ModelAttribute SearchDTO searchDTO) {
        return recipeService.searchRecipe(searchDTO);
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable("id") String id) {
        return recipeService.getRecipeById(id);
    }

}
