package edu.uncg.character_api.controller;

import edu.uncg.character_api.model.Character;
import edu.uncg.character_api.repository.CharacterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository repository;

    public CharacterController(CharacterRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Character> getAllCharacters(){
        return repository.getAllCharacters();
    }

     @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id){
        return repository.getCharacterById(id);
    }

    @PostMapping
    public void addCharacter(@RequestBody Character character){
        repository.addCharacter(character);
    }

@PutMapping("/{id}")
public void updateCharacter(@PathVariable Long id, @RequestBody Character character){
    repository.updateCharacter(id, character);
}

@DeleteMapping("/{id}")
public void deleteCharacter(@PathVariable Long id){
    repository.deleteCharacter(id);
}

}

