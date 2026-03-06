package edu.uncg.character_api.controller;

import edu.uncg.character_api.model.AnimeCharacter;
import edu.uncg.character_api.service.AnimeCharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/characters")
public class AnimeCharacterController {

    private final AnimeCharacterService service;

    public AnimeCharacterController(AnimeCharacterService service){
        this.service = service;
    }

    @GetMapping
    public List<AnimeCharacter> getAllCharacters(){
        return service.getAllCharacters();
    }

    @GetMapping("/{id}")
    public AnimeCharacter getCharacterById(@PathVariable Long id){
        return service.getCharacterById(id);
    }

      @GetMapping("/search")
    public List <AnimeCharacter> searchCharacters(@RequestParam String name){
        return service.searchbyName(name);
    }


    @GetMapping("/category/{category}")
    public List <AnimeCharacter> getCharacterByCategory(@PathVariable String anime){
        return service.getbyAnime(anime);
    }
    @PostMapping
    public AnimeCharacter addCharacter(@RequestBody AnimeCharacter character){
         return service.createCharacter(character);
    }

@PutMapping("/{id}")
public AnimeCharacter updateCharacter(@PathVariable Long id, @RequestBody AnimeCharacter character){
    character.setId(id);
    return service.updateCharacter(id,character);
}

@DeleteMapping("/{id}")
public void deleteCharacter(@PathVariable Long id){
    service.deleteCharacter(id);
}

}

