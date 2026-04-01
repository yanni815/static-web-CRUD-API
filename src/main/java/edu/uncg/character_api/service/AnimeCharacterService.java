package edu.uncg.character_api.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import edu.uncg.character_api.model.AnimeCharacter;
import edu.uncg.character_api.repository.AnimeCharacterRepository;



@Service
public class AnimeCharacterService {

    private final AnimeCharacterRepository repository;

    public AnimeCharacterService(AnimeCharacterRepository repository) {
        this.repository = repository;
    }

    public List<AnimeCharacter> getAllCharacters() {
        return repository.findAll();
    }

    public AnimeCharacter getCharacterById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AnimeCharacter updateCharacter(Long id, AnimeCharacter character) {
        character.setId(id);
        return repository.save(character);
    }

    public void deleteCharacter(Long id) {
        repository.deleteById(id);
    }

    public List <AnimeCharacter> searchbyCategory(String anime){
        return repository.findByAnime(anime);

    }

    public List <AnimeCharacter> searchbyName(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

public AnimeCharacter createCharacter(
        String name,
        String anime,
        String power,
        String description,
        MultipartFile image
) {
    String filename = null;
    
    if (image != null && !image.isEmpty()) {
        try {
            String uploadDir = System.getProperty("user.home") + "/uploads/";;

            filename = System.currentTimeMillis() + "_" + image.getOriginalFilename();

           File saveFile = new File(uploadDir + filename);
            image.transferTo(saveFile);

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }

    AnimeCharacter character = new AnimeCharacter();
    character.setName(name);
    character.setAnime(anime);
    character.setPower(power);
    character.setDescription(description);
    character.setImageUrl("/images/" + filename);

    return repository.save(character);
}
}