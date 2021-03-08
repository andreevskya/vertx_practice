package ru.heroes.server.data.dtos.builders;

import org.junit.jupiter.api.Test;
import ru.heroes.server.data.dtos.CharacterMovementDto;
import ru.heroes.server.data.entities.CharacterEntity;
import ru.heroes.server.data.entities.CharacterMovementEntity;
import ru.heroes.server.data.entities.HouseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterMovementDtoBuilderTest {

    @Test
    public void testCreate() {
        CharacterMovementEntity entity = new CharacterMovementEntity();
        entity.setX(10.5f);
        entity.setY(20.01f);
        entity.setCharacter(new CharacterEntity());
        entity.getCharacter().setFirstName("F");
        entity.getCharacter().setLastName("L");
        entity.getCharacter().setHouse(new HouseEntity());
        entity.getCharacter().getHouse().setName("of the rising sun");

        CharacterMovementDto dtp = CharacterMovementDtoBuilder.create(entity);

        assertEquals(entity.getX(), dtp.getX());
        assertEquals(entity.getY(), dtp.getY());
        assertEquals(entity.getCharacter().getFirstName() + " " + entity.getCharacter().getLastName(), dtp.getHero());
        assertEquals(entity.getCharacter().getHouse().getName(), dtp.getHouse());
    }
}