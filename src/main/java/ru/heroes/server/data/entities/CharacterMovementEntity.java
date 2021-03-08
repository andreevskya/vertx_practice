package ru.heroes.server.data.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Описывает единичное перемещение персонажа.
 */
@Entity
@Table(name = "character_movements")
public class CharacterMovementEntity implements Serializable {
    /**
     * Идентификатор перемещения.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Величина перемещения по оси X.
     */
    @Column
    private float x;

    /**
     * Величина перемещения по оси Y.
     */
    @Column
    private float y;

    /**
     * Какой-то непонятный параметр. Выпилить.
     */
    @Column
    private int velocity;

    /**
     * Величина задержки в миллисекундах перед следующим перемещением.
     */
    @Column
    private long delayMillis;

    /**
     * Перемещаемый персонаж.
     */
    @ManyToOne
    @JoinColumn(name = "character_id")
    private CharacterEntity character;

    /**
     * Конструктор класса. Создаёт новый экземпляр класса {@link CharacterMovementEntity}.
     */
    public CharacterMovementEntity() {
        //
    }

    /**
     * Возвращает идентификатор перемещения.
     *
     * @return идентификатор перемещения.
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор перемещения.
     *
     * @param id идентификатор перемещения.
     */
    public void setId(Long id) {
        this.id = id;
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
     * @param x величина перемещения по оси X.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Возвращает величину перемещения по оси Y.
     *
     * @return величина перемещения по оси Y.
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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Возвращает период паузы перед следующим перемещением.
     *
     * @return период паузы в миллисекундах перед следующим перемещением.
     */
    public long getDelayMillis() {
        return delayMillis;
    }

    /**
     * Устанавливает период паузы перед следующим перемещением.
     *
     * @param delayMillis период паузы в миллисекундах перед следующим перемещением.
     */
    public void setDelayMillis(long delayMillis) {
        this.delayMillis = delayMillis;
    }

    /**
     * Возвращает перемещаемого персонажа.
     *
     * @return перемещаемый персонаж.
     */
    public CharacterEntity getCharacter() {
        return character;
    }

    /**
     * Устанавливает перемещаемого персонажа.
     *
     * @param character перемещаемый персонаж.
     */
    public void setCharacter(CharacterEntity character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "CharacterMovementEntity{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", velocity=" + velocity +
                ", delayMillis=" + delayMillis +
                ", character=" + character +
                '}';
    }
}
