package edu.uncg.character_api.controller;

import edu.uncg.character_api.model.Character;
import edu.uncg.character_api.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service){
        this.service = service;
    }

    @GetMapping
    public List<Character> getAllCharacters(){
        return service.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id){
        return service.getCharacterById(id);
    }

      @GetMapping("/search")
    public List <Character> searchCharacters(@RequestParam String name){
        return service.searchbyName(name);
    }


    @GetMapping("/characters/category/{category}")
    public List <Character> getCharacterByCategory(@PathVariable String anime){
        return service.getbyAnime(anime);
    }
    @PostMapping
    public Character addCharacter(@RequestBody Character character){
         return service.createCharacter(character);
    }

@PutMapping("/{id}")
public Character updateCharacter(@PathVariable Long id, @RequestBody Character character){
    character.setId(id);
    return service.updateCharacter(id,character);
}

@DeleteMapping("/{id}")
public void deleteCharacter(@PathVariable Long id){
    service.deleteCharacter(id);
}

}

