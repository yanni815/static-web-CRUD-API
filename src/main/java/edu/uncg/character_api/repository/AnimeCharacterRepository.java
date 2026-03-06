package edu.uncg.character_api.repository;

import edu.uncg.character_api.model.AnimeCharacter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnimeCharacterRepository  extends JpaRepository<AnimeCharacter, Long>{  
    List <AnimeCharacter> findByNameContainingIgnoreCase(String name); 
     List <AnimeCharacter> findByAnime(String anime);
}


