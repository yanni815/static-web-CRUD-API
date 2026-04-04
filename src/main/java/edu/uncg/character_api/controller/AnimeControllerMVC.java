package edu.uncg.character_api.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import edu.uncg.character_api.model.AnimeCharacter;
import edu.uncg.character_api.repository.AnimeCharacterRepository;
import edu.uncg.character_api.service.AnimeCharacterService;

@Controller
@RequestMapping("/characters")
public class AnimeControllerMVC {
    private final AnimeCharacterRepository animeCharacterRepository;
    
    public AnimeControllerMVC(AnimeCharacterRepository animeCharacterRepository){
        this.animeCharacterRepository = animeCharacterRepository;
    }
    @Autowired
    private AnimeCharacterService animeCharacterService;

    @GetMapping
    public String getAllCharacters(Model model){
        model.addAttribute("characterList", animeCharacterService.getAllCharacters());
        return "character-list";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model){
        model.addAttribute("character", animeCharacterService.getCharacterById(id));
        return "character-details";
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "character-create";
    }


    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("character", animeCharacterService.getCharacterById(id));
        return "character-update";
    }

   

    @PostMapping
    public String saveCharacter(AnimeCharacter character){
        animeCharacterRepository.save(character);
        return "redirect:/characters";
    }

     @PostMapping("/{id}/delete")
    public String deleteCharacter(@PathVariable Long id) {
        animeCharacterService.deleteCharacter(id);
        return "redirect:/characters";
    }


@PostMapping("/save")
    public String saveCharacter(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String anime,
            @RequestParam String power,
            @RequestParam String description,
            @RequestParam(required = false) MultipartFile imageFile
    ) throws IOException {

        
        if (id != null) {
            // UPDATE
            AnimeCharacter character = animeCharacterService.getCharacterById(id);

            character.setName(name);
            character.setAnime(anime);
            character.setPower(power);
            character.setDescription(description);

            if (imageFile != null && !imageFile.isEmpty()) {
                String filename = imageFile.getOriginalFilename();
                Path uploadPath = Paths.get("/uploads/" + filename);
                Files.write(uploadPath, imageFile.getBytes());
                character.setImagePath("/uploads/" + filename);
            }
            
            animeCharacterRepository.save(character);
        } else {
            // CREATE
            animeCharacterService.createCharacter( name, anime, power, description, imageFile);
        }

       
        return "redirect:/characters";
    }

}