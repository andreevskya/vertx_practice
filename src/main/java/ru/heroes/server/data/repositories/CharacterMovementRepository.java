package ru.heroes.server.data.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.heroes.server.data.entities.CharacterMovementEntity;

import java.util.List;

/**
 * Репозиторий перемещений.
 */
@Repository
public interface CharacterMovementRepository extends PagingAndSortingRepository<CharacterMovementEntity, Long> {

    /**
     * Возвращает список перемещений персонажа.
     *
     * @param charId идентификатор персонажа.
     * @param page   пагинатор
     * @return список перемещений персонажа с указанным идентификатором или пустой список, если перемещений нет.
     */
    @Query("SELECT m FROM CharacterMovementEntity m WHERE m.character.id = :charId ORDER BY m.id ASC")
    List<CharacterMovementEntity> findByCharacter(@Param("charId") Long charId, Pageable page);
}
