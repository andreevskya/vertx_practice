package ru.heroes.server;

import org.springframework.data.domain.PageRequest;
import ru.heroes.server.data.entities.CharacterEntity;
import ru.heroes.server.data.entities.CharacterMovementEntity;
import ru.heroes.server.data.repositories.CharacterMovementRepository;

import java.util.List;

/**
 * Предоставляет информацию о перемещениях персонажа.
 */
public class CharacterMovementProvider {
    /**
     * Персонаж, перемещения которого выдаёт данный провайдер.
     */
    private CharacterEntity character;
    /**
     * Репа перемещений.
     */
    private CharacterMovementRepository movementRepo;
    /**
     * Предыдущее перемещение (если было).
     */
    private CharacterMovementEntity prev;
    /**
     * Индекс текущего перемещения в выдаче БД.
     */
    private int index = 0;
    /**
     * Величина паузы перед следуюзим перемещением.
     */
    private long ticks = 0;

    /**
     * Конструктор класса. Создаёт новый экземпляр класса {@link CharacterMovementProvider}
     *
     * @param character    персонаж, перемещения которого предоставляет конструируемый экземпляр класса.
     * @param movementRepo репа перемещений.
     */
    public CharacterMovementProvider(CharacterEntity character, CharacterMovementRepository movementRepo) {
        this.character = character;
        this.movementRepo = movementRepo;
    }

    /**
     * Возвращает следующее перемещение персонажа.
     *
     * @return следующее перемещение персонажа или null, если такого нет.
     */
    public CharacterMovementEntity getMovement() {
        if (prev == null) {
            prev = getMovement(0);
            ticks = 0;
        } else {
            if (prev.getDelayMillis() > ticks) {
                ticks += ClientHandlingVerticle.TICK_DURATION_MS;
                return prev;
            }
            ticks = 0;
            ++index;
            prev = getMovement(index);
        }
        return prev;
    }

    private CharacterMovementEntity getMovement(int index) {
        List<CharacterMovementEntity> list = movementRepo.findByCharacter(character.getId(), PageRequest.of(index, 1));
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
