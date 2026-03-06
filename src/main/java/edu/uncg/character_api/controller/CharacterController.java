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

     @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

      @GetMapping("/search")
    public List <Character> searchCharacters(@RequestParam String name){
        return repository.findByNameContainingIgnoreCase(name);
    }


      @GetMapping("/category/{category}")
    public List <Character> getCharacterByCategory(@PathVariable String category){
        return repository.findByCategoryIgnoreCase(category);
    }
    @PostMapping
    public Character addCharacter(@RequestBody Character character){
         return repository.save(character);
    }

@PutMapping("/{id}")
public Character updateCharacter(@PathVariable Long id, @RequestBody Character character){
    character.setId(id);
    return repository.save(character);
}

@DeleteMapping("/{id}")
public void deleteCharacter(@PathVariable Long id){
    repository.deleteById(id);
}

}

