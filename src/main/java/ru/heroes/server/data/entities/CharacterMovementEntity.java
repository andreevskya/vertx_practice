package ru.heroes.server.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "character_movements")
public class CharacterMovementEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private float x;

    @Column
    private float y;

    @Column
    private int velocity;

    @Column
    private long delayMillis;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private CharacterEntity character;

    public CharacterMovementEntity() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public long getDelayMillis() {
        return delayMillis;
    }

    public void setDelayMillis(long delayMillis) {
        this.delayMillis = delayMillis;
    }

    public CharacterEntity getCharacter() {
        return character;
    }

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
