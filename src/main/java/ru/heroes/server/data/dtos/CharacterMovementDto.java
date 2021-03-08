package ru.heroes.server.data.dtos;

import java.io.Serializable;

/**
 * Описывает перемещение персонажа.
 */
public class CharacterMovementDto implements Serializable {
    /**
     * Имя и фамилия персонажа.
     */
    private String hero;
    /**
     * Имя дома, которому персонаж принадлежит.
     */
    private String house;
    /**
     * Величина перемещения по оси X.
     */
    private float x;
    /**
     * Величина перемещения по оси Y.
     */
    private float y;

    /**
     * Конструктор класса. Создаёт новый экземпляр класса {@link CharacterMovementDto}
     */
    public CharacterMovementDto() {
        //
    }

    /**
     * Возвращает имя и фамилию персонажа.
     *
     * @return имя и фамилияперсонажа, разделенные пробелом.
     */
    public String getHero() {
        return hero;
    }

    /**
     * Устанавливает имя и фамилию персонажа.
     *
     * @param hero имя и фамилия персонажа, разделенные пробелом.
     */
    public void setHero(String hero) {
        this.hero = hero;
    }

    /**
     * Возвращает величину перемещения по оси X.
     *
     * @return величина перемещения по оси X.
     */
    public float getX() {
        return x;
    }

    /**
     * Устанавливает величину перемещения по оси X.
     *
     * @param x величина перемещения по оси X
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Возвращает величину перемещения по оси Y.
     *
     * @return велчина перемещения по оси Y.
     */
    public float getY() {
        return y;
    }

    /**
     * Устанавливает величину перемещения по оси Y.
     *
     * @param y величина перемещения по оси Y.
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Возвращает название дома, которому принадлежит перемещаемый персонаж.
     *
     * @return название дома, которому принадлежит перемещаемый персонаж.
     */
    public String getHouse() {
        return house;
    }

    /**
     * Устанавливает название дома, которому принадлежит перемещаемый персонаж.
     *
     * @param house название дома, которому принадлежит перемещаемый персонаж.
     */
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
