package learn.java.canilroomviewmodel.model;

import androidx.annotation.Nullable;


public class Dog {

    Weight weight;
    Height height;
    private Float id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String life_span;
    @Nullable
    private String description;
    @Nullable
    private String temperament;
    @Nullable
    private String origin;
    @Nullable
    private String country_code;
    @Nullable
    private String history;

    @Nullable
    public String getHistory() {
        return history;
    }

    public void setHistory(@Nullable String history) {
        this.history = history;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(@Nullable String country_code) {
        this.country_code = country_code;
    }

    public Weight getWeight() {
        return weight;
    }
    public Height getHeight() {
        return height;
    }
    public float getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBred_for() {
        return bred_for;
    }
    public String getBreed_group() {
        return breed_group;
    }
    public String getLife_span() {
        return life_span;
    }
    public String getTemperament() {
        return temperament;
    }
    public String getOrigin() {
        return origin;
    }

    public void setWeight(Weight weightObject) {
        this.weight = weightObject;
    }
    public void setHeight(Height heightObject) {
        this.height = heightObject;
    }
    public void setId(float id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBred_for(String bred_for) {
        this.bred_for = bred_for;
    }
    public void setBreed_group(String breed_group) {
        this.breed_group = breed_group;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
class Height {
    private String imperial;
    private String metric;


    // Getter Methods

    public String getImperial() {
        return imperial;
    }

    public String getMetric() {
        return metric;
    }

    // Setter Methods

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}
class Weight {
    private String imperial;
    private String metric;


    // Getter Methods

    public String getImperial() {
        return imperial;
    }

    public String getMetric() {
        return metric;
    }

    // Setter Methods

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}