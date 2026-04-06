package edu.uncg.character_api.service;

import org.springframework.stereotype.Service;
import java.util.List;

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

    public AnimeCharacter createCharacter(AnimeCharacter character) {
        return repository.save(character);
    }

    public AnimeCharacter updateCharacter(Long id, AnimeCharacter updated) {
         AnimeCharacter existing = getCharacterById(id);

        existing.setName(updated.getName());
        existing.setAnime(updated.getAnime());
        existing.setPower(updated.getPower());
        existing.setDescription(updated.getDescription());
        
        return repository.save(existing);
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
}