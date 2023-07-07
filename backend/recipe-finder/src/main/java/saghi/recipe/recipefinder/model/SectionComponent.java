package saghi.recipe.recipefinder.model;

public class SectionComponent {
    private long id;
    private String raw_text;

    public SectionComponent(long id, String rawText) {
        this.id = id;
        raw_text = rawText;
    }

    public SectionComponent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRaw_text() {
        return raw_text;
    }

    public void setRaw_text(String raw_text) {
        this.raw_text = raw_text;
    }
}
