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
        return repository.findAll();
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character){
        return repository.save(character);
    }

    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable Long id){

    
        return repository.findById(id).orElse(null);
}

@DeleteMapping("/{id}")
public void deleteCharacter(@PathVariable Long id){
    repository.deleteById(id);
}

}

