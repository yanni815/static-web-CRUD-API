package edu.uncg.character_api.service;

import org.springframework.stereotype.Service;
import java.util.List;

import edu.uncg.character_api.model.Character;
import edu.uncg.character_api.repository.CharacterRepository;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> getAllCharacters() {
        return repository.findAll();
    }

    public Character getCharacterById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Character createCharacter(Character character) {
        return repository.save(character);
    }

    public Character updateCharacter(Long id, Character character) {
        character.setId(id);
        return repository.save(character);
    }

    public void deleteCharacter(Long id) {
        repository.deleteById(id);
    }

    public List <Character> getbyAnime(String anime){
        return repository.findByAnime(anime);

    }

    public List <Character> searchbyName(String name){
        return repository.findByNameContainingIgnoreCase(name);
}

}