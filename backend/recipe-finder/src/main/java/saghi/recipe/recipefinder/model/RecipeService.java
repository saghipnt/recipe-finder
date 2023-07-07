package saghi.recipe.recipefinder.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saghi.recipe.recipefinder.tasty.ApiClient;

@Service
public class RecipeService {


    @Autowired
    ApiClient apiClient;


    public RecipeList searchRecipe(SearchDTO searchDTO) {
        return apiClient.searchRecipes(searchDTO.query());
    }

    public Recipe getRecipeById(String id) {
        return apiClient.getRecipeById(id);
    }
}
