package ru.heroes.server.data.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Описывает персонажа.
 */
@Entity
@Table(name = "characters")
public class CharacterEntity implements Serializable {
    /**
     * Идентификатор персонажа.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Имя персонажа.
     */
    @Column
    private String firstName;

    /**
     * Фамилия персонажа.
     */
    @Column
    private String lastName;

    /**
     * Дом, которому принадлежит персонаж.
     */
    @ManyToOne
    @JoinColumn(name = "house_id")
    private HouseEntity house;

    /**
     * Конструктор класса. Создаёт новый экземпляр класса {@link CharacterEntity}.
     */
    public CharacterEntity() {
        //
    }

    /**
     * Возвращает идентификатор персонажа.
     *
     * @return идентификатор персонажа.
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор персонажа.
     *
     * @param id идентификатор персонажа.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает имя персонажа.
     *
     * @return имя персонажа.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Устанавливает имя персонажа.
     *
     * @param firstName имя персонажа.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Возвращает фамилию персонажа.
     *
     * @return фамилия персонажа.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Устанавливает фамилию персонажа.
     *
     * @param lastName фамилия персонажа.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Возвращает дом, которому принадлежит персонаж.
     *
     * @return дом, которому принадлежит персонаж.
     */
    public HouseEntity getHouse() {
        return house;
    }

    /**
     * Устанавливает дом, которому принадлежит персонаж.
     *
     * @param house дом, которому принадлежит персонаж.
     */
    public void setHouse(HouseEntity house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", house=" + house +
                '}';
    }
}
