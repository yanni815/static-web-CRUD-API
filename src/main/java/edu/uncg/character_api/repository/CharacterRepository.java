package edu.uncg.character_api.repository;

import edu.uncg.character_api.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CharacterRepository extends JpaRepository<Character, Long> {


}

