package ru.heroes.server.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.heroes.server.data.entities.CharacterEntity;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    //
}
