package edu.uncg.character_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnimeCharacter{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String anime;
    private String power;
    private String description;
    private String imageUrl;
   

    public AnimeCharacter() {}

    public AnimeCharacter(Long id, String name, String anime, String power, String description){
        this.id = id;
        this.name = name;
        this.anime = anime;
        this.power = power;
        this.description = description;
    }

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAnime() { return anime; }
    public void setAnime(String anime) { this.anime = anime; }

    public String getPower() { return power; }
    public void setPower(String power) { this.power = power; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

     public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl=imageUrl; }
}
