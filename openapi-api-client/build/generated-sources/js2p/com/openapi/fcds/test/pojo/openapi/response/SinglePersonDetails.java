
package com.openapi.fcds.test.pojo.openapi.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Root Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "height",
    "mass",
    "hair_color",
    "skin_color",
    "eye_color",
    "birth_year",
    "gender",
    "homeworld",
    "films",
    "species",
    "vehicles",
    "starships",
    "created",
    "edited",
    "url"
})
public class SinglePersonDetails {

    /**
     * The name Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * The height Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("height")
    private String height;
    /**
     * The mass Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("mass")
    private String mass;
    /**
     * The hair_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("hair_color")
    private String hairColor;
    /**
     * The skin_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("skin_color")
    private String skinColor;
    /**
     * The eye_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("eye_color")
    private String eyeColor;
    /**
     * The birth_year Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("birth_year")
    private String birthYear;
    /**
     * The gender Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("gender")
    private String gender;
    /**
     * The homeworld Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("homeworld")
    private String homeworld;
    /**
     * The films Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("films")
    private List<String> films = new ArrayList<String>();
    /**
     * The species Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("species")
    private List<Object> species = new ArrayList<Object>();
    /**
     * The vehicles Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("vehicles")
    private List<String> vehicles = new ArrayList<String>();
    /**
     * The starships Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("starships")
    private List<String> starships = new ArrayList<String>();
    /**
     * The created Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("created")
    private String created;
    /**
     * The edited Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("edited")
    private String edited;
    /**
     * The url Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The name Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public SinglePersonDetails withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * The height Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    /**
     * The height Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    public SinglePersonDetails withHeight(String height) {
        this.height = height;
        return this;
    }

    /**
     * The mass Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("mass")
    public String getMass() {
        return mass;
    }

    /**
     * The mass Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("mass")
    public void setMass(String mass) {
        this.mass = mass;
    }

    public SinglePersonDetails withMass(String mass) {
        this.mass = mass;
        return this;
    }

    /**
     * The hair_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("hair_color")
    public String getHairColor() {
        return hairColor;
    }

    /**
     * The hair_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("hair_color")
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public SinglePersonDetails withHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    /**
     * The skin_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("skin_color")
    public String getSkinColor() {
        return skinColor;
    }

    /**
     * The skin_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("skin_color")
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public SinglePersonDetails withSkinColor(String skinColor) {
        this.skinColor = skinColor;
        return this;
    }

    /**
     * The eye_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("eye_color")
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * The eye_color Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("eye_color")
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public SinglePersonDetails withEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    /**
     * The birth_year Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("birth_year")
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * The birth_year Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("birth_year")
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public SinglePersonDetails withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    /**
     * The gender Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    /**
     * The gender Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public SinglePersonDetails withGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * The homeworld Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("homeworld")
    public String getHomeworld() {
        return homeworld;
    }

    /**
     * The homeworld Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("homeworld")
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public SinglePersonDetails withHomeworld(String homeworld) {
        this.homeworld = homeworld;
        return this;
    }

    /**
     * The films Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("films")
    public List<String> getFilms() {
        return films;
    }

    /**
     * The films Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("films")
    public void setFilms(List<String> films) {
        this.films = films;
    }

    public SinglePersonDetails withFilms(List<String> films) {
        this.films = films;
        return this;
    }

    /**
     * The species Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("species")
    public List<Object> getSpecies() {
        return species;
    }

    /**
     * The species Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("species")
    public void setSpecies(List<Object> species) {
        this.species = species;
    }

    public SinglePersonDetails withSpecies(List<Object> species) {
        this.species = species;
        return this;
    }

    /**
     * The vehicles Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("vehicles")
    public List<String> getVehicles() {
        return vehicles;
    }

    /**
     * The vehicles Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("vehicles")
    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public SinglePersonDetails withVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    /**
     * The starships Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("starships")
    public List<String> getStarships() {
        return starships;
    }

    /**
     * The starships Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("starships")
    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public SinglePersonDetails withStarships(List<String> starships) {
        this.starships = starships;
        return this;
    }

    /**
     * The created Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    /**
     * The created Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    public SinglePersonDetails withCreated(String created) {
        this.created = created;
        return this;
    }

    /**
     * The edited Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    /**
     * The edited Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("edited")
    public void setEdited(String edited) {
        this.edited = edited;
    }

    public SinglePersonDetails withEdited(String edited) {
        this.edited = edited;
        return this;
    }

    /**
     * The url Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * The url Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public SinglePersonDetails withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SinglePersonDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
