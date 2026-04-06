package edu.uncg.character_api.controller;

import edu.uncg.character_api.model.AnimeCharacter;
import edu.uncg.character_api.service.AnimeCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;


@RestController
@RequestMapping("/api/characters")
public class AnimeCharacterController {
    @Autowired
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
    public AnimeCharacter createCharacter(
        @RequestParam(required = false) Long id,
        @RequestParam String name,
        @RequestParam String anime,
        @RequestParam String power,
        @RequestParam String description,
        @RequestParam MultipartFile imageFile
) throws IOException {

    AnimeCharacter character = new AnimeCharacter();

character.setName(name);
character.setAnime(anime);
character.setPower(power);
character.setDescription(description);

// only set image if provided
if (imageFile != null && !imageFile.isEmpty()) {

    String filename = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();

    Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads");
    Files.createDirectories(uploadDir);

    Path filePath = uploadDir.resolve(filename);
    Files.write(filePath, imageFile.getBytes());

    character.setImageUrl("/uploads/" + filename);
}
  return service.createCharacter(character);
}


@PutMapping("/{id}")
public AnimeCharacter updateCharacter(@PathVariable Long id, AnimeCharacter character){
    return service.updateCharacter(id,character);
}

@DeleteMapping("/{id}")
public void deleteCharacter(@PathVariable Long id){
    service.deleteCharacter(id);
}

}

