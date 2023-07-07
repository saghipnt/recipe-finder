package saghi.recipe.recipefinder.tasty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import saghi.recipe.recipefinder.model.Recipe;
import saghi.recipe.recipefinder.model.RecipeList;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ApiClient {
    @Autowired
    RestTemplate restTemplate;
    private static final String apiKey="6619068984mshb46edb4fc36da10p1a1b3bjsnd19683e85c63";
    private static final String apiHost="tasty.p.rapidapi.com";
    private static final String API_URL = "https://tasty.p.rapidapi.com/recipes";


    public RecipeList searchRecipes(String query) {
        String searchUrl = UriComponentsBuilder.fromUriString(API_URL + "/list?from=0&size=20&q=" + query).toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "tasty.p.rapidapi.com");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(searchUrl));
        RecipeList recipes = restTemplate.exchange(requestEntity, RecipeList.class).getBody();

        return recipes;
    }

    public Recipe getRecipeById(String recipeId) {
        String recipeUrl = UriComponentsBuilder.fromUriString(API_URL + "/get-more-info?id=" + recipeId).toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", apiHost);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(recipeUrl));
        Recipe recipes = restTemplate.exchange(requestEntity, Recipe.class).getBody();

        return recipes;
    }


}
