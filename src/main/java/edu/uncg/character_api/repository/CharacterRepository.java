package edu.uncg.character_api.repository;

import edu.uncg.character_api.model.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CharacterRepository  extends JpaRepository<Character, Long>{  
    List <Character> findByNameContainingIgnoreCase(String name); 
    List <Character> findByCategoryIgnoreCase(String category);
}
