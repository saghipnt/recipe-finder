package saghi.recipe.recipefinder.model;


import java.util.List;

public class Recipe {
    private String id;
    private String name;

    private String thumbnail_url;

    private List<RecipeSection> sections;

    private String description;

    public Recipe(String id, String name, String thumbnail_url, List<RecipeSection> sections, String description) {
        this.id = id;
        this.name = name;
        this.thumbnail_url = thumbnail_url;
        this.sections = sections;
        this.description = description;
    }

    public Recipe() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RecipeSection> getSections() {
        return sections;
    }

    public void setSections(List<RecipeSection> sections) {
        this.sections = sections;
    }
}
