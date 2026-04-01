package edu.uncg.character_api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import org.springframework.web.service.registry.ImportHttpServices.Container;
import java.io.File;

import edu.uncg.character_api.model.AnimeCharacter;
import edu.uncg.character_api.service.AnimeCharacterService;

@Controller
@RequestMapping("/characters")
public class AnimeControllerMVC {
    @Autowired
    private AnimeCharacterService animeCharacterService;

    @GetMapping
    public String getAllCharacters(Model model){
        model.addAttribute("characters", animeCharacterService.getAllCharacters());
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

    @PostMapping
    public String createCharacter(AnimeCharacter character){
        animeCharacterService.createCharacter(character);
        return "redirect:/characters";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("character", animeCharacterService.getCharacterById(id));
        return "character-update";
    }

    @PostMapping("/{id}")
    public String updateCharacter(@PathVariable Long id, AnimeCharacter character) {
        animeCharacterService.updateCharacter(id, character);
        return "redirect:/characters/" + id;
    }

     @PostMapping("/{id}/delete")
    public String deleteCharacter(@PathVariable Long id) {
        animeCharacterService.deleteCharacter(id);
        return "redirect:/characters";
    }

@PostMapping
public String createCharacter(
        @RequestParam("name") String name,
        @RequestParam("anime") String anime,
        @RequestParam("power")String power,
        @RequestParam("description") String description,
        @RequestParam("image") MultipartFile imageFile
) throws IOException {

    String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();

    String uploadDir = "src/main/resources/static/uploads/";

    File saveFile = new File(uploadDir + fileName);
    imageFile.transferTo(saveFile);

    AnimeCharacter character = new AnimeCharacter();
    character.setName(name);
    character.setAnime(anime);
    character.setPower(power);
    character.setDescription(description);
    character.setimageUrl("/images/" + fileName);

    animeCharacterService.createCharacter(character);

    return "redirect:/characters";
}

}