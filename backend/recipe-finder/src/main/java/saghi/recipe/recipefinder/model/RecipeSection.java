package saghi.recipe.recipefinder.model;

import java.util.List;

public class RecipeSection {
    private List<SectionComponent> components;

    public RecipeSection(List<SectionComponent> components) {
        this.components = components;
    }
    public RecipeSection( ) {
    }

    public List<SectionComponent> getComponents() {
        return components;
    }

    public void setComponents(List<SectionComponent> components) {
        this.components = components;
    }
}
