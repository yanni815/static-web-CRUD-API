package edu.uncg.character_api.repository;

import edu.uncg.character_api.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository{
    private List<Character> characters = new ArrayList<>();

    public List<Character> getAllCharacters(){
        return characters;
    }

    public void addCharacter(Character character){
        characters.add(character);
    }

    public Character getCharacterById(Long id){
        for (Character c : characters){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public void updateCharacter(Long id, Character updatedCharacter){
        for(int i = 0; i < characters.size(); i++){
            if(characters.get(i).get(i).getId().equals(id)){
                characters.set(i, updatedCharacter);
                return;
            }
        }
    }

    public void deleteCharacter(Long id){
        characters.removeIf(c -> c.getId().equals(id));
    }


}

