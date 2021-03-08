package ru.heroes.server.data.dtos.builders;

import ru.heroes.server.data.dtos.CharacterMovementDto;
import ru.heroes.server.data.entities.CharacterMovementEntity;

/**
 * Конструктор dtoшки из сущности {@link CharacterMovementEntity}.
 */
public class CharacterMovementDtoBuilder {

    /**
     * Из переданного экземпляра {@link CharacterMovementEntity} создаёт новый экземпляр {@link CharacterMovementDto}
     *
     * @param entity сущность, из которой dtoшку нужно создать.
     * @return новый экземпляр dtoшки.
     */
    public static CharacterMovementDto create(CharacterMovementEntity entity) {
        CharacterMovementDto dto = new CharacterMovementDto();
        dto.setHero(entity.getCharacter().getFirstName() + " " + entity.getCharacter().getLastName());
        dto.setHouse(entity.getCharacter().getHouse().getName());
        dto.setX(entity.getX());
        dto.setY(entity.getY());
        return dto;
    }
}
