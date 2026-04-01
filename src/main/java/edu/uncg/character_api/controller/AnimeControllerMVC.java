package edu.uncg.character_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.service.registry.ImportHttpServices.Container;

import edu.uncg.character_api.service.AnimeCharacterService;

@Controller
@RequestMapping("/anime")
public class AnimeControllerMVC {
    @Autowired
    private AnimeCharacterService animeCharacterService;

    @GetMapping
    public String getAllAnime(Model model){
        model.addAttribute("animeList", animeCharacterService.getAllCharacters());
        return "anime-list";
    }

    @GetMapping("/{id}")
    public String getAnimeById(@PathVariable Long id, Model model){
        model.addAttribute("anime", animeCharacterService.getCharacterById(id));
        return "anime-details";
    }
}
