package ru.heroes.server;

import org.springframework.data.domain.PageRequest;
import ru.heroes.server.data.entities.CharacterEntity;
import ru.heroes.server.data.entities.CharacterMovementEntity;
import ru.heroes.server.data.repositories.CharacterMovementRepository;

import java.util.List;

public class CharacterMovementProvider {
    private CharacterEntity character;
    private CharacterMovementRepository movementRepo;
    private CharacterMovementEntity prev;
    private int index = 0;
    private long ticks = 0;

    public CharacterMovementProvider(CharacterEntity character, CharacterMovementRepository movementRepo) {
        this.character = character;
        this.movementRepo = movementRepo;
    }

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
