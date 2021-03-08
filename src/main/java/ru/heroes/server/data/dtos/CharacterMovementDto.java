package ru.heroes.server.data.dtos;

import java.io.Serializable;

public class CharacterMovementDto implements Serializable {
    private String hero;
    private String house;
    private float x;
    private float y;

    public CharacterMovementDto() {
        //
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "CharacterMovementDto{" +
                "hero='" + hero + '\'' +
                ", house='" + house + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
