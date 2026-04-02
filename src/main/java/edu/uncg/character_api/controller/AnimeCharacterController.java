package edu.uncg.character_api.controller;

import edu.uncg.character_api.model.AnimeCharacter;
import edu.uncg.character_api.service.AnimeCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@RestController
@RequestMapping("/api/characters")
public class AnimeCharacterController {
    @Autowired
    private AnimeCharacterService animeCharacterService;
    
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


    @GetMapping("/category/{anime}")
    public List <AnimeCharacter> searchByCategory(@PathVariable String anime){
        return service.searchbyCategory(anime);
    }
    @PostMapping
    public String createCharacter(
        @RequestParam String name,
        @RequestParam String anime,
        @RequestParam String power,
        @RequestParam String description,
        @RequestParam MultipartFile imageFile
) {
    animeCharacterService.createCharacter(name, anime, power, description, imageFile);
    return "redirect:/characters";
}
    
    

@PostMapping("/{id}")
public AnimeCharacter updateCharacter(@PathVariable Long id, AnimeCharacter character){
    character.setId(id);
    return service.updateCharacter(id,character);
}

@DeleteMapping("/{id}")
public void deleteCharacter(@PathVariable Long id){
    service.deleteCharacter(id);
}

}

