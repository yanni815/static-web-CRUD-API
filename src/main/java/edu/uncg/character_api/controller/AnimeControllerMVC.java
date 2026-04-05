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
     @Autowired
    private final AnimeCharacterRepository repository;
      private final AnimeCharacterService service;
    
    public AnimeControllerMVC(AnimeCharacterRepository repository, AnimeCharacterService service ){
        this.repository = repository;
        this.service = service;
    }
   
   

    @GetMapping
    public String getAllCharacters(Model model){
        model.addAttribute("characterList", service.getAllCharacters());
        return "character-list";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model){
        model.addAttribute("character", service.getCharacterById(id));
        return "character-details";
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "character-create";
    }


    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model){
       AnimeCharacter character = service.getCharacterById(id);

    if (character == null) {
        return "redirect:/characters"; // or error page
    }

    model.addAttribute("character", character);
    return "character-update";
}
       
        


     @PostMapping("/{id}/delete")
    public String deleteCharacter(@PathVariable Long id) {
        service.deleteCharacter(id);
        return "redirect:/characters";
    
    }

@PostMapping("/save")
public String saveCharacter(
        @RequestParam(required = false) Long id,
        @RequestParam String name,
        @RequestParam String anime,
        @RequestParam String power,
        @RequestParam String description,
        @RequestParam MultipartFile imageFile
) throws IOException {

    AnimeCharacter character;

    if (id != null) {
        character = service.getCharacterById(id);

    if(character == null){
        return "redirect:/characters";
        }
    } else {
        character = new AnimeCharacter();
    }

    character.setName(name);
    character.setAnime(anime);
    character.setPower(power);
    character.setDescription(description);

    // ONLY handle image if new file is uploaded
    if (imageFile != null && !imageFile.isEmpty()) {

        String filename = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();

        Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads");
        Files.createDirectories(uploadDir);

        Path filePath = uploadDir.resolve(filename);
        Files.write(filePath, imageFile.getBytes());

        character.setImageUrl("/uploads/" + filename);
    }

      if (id == null) {
            service.createCharacter(character);
        } else {
            service.updateCharacter(id, character);
        }
    return "redirect:/characters" ;
}

}
