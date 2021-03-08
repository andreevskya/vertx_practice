package ru.heroes.server.data.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Описывает дом. Это сущность, объединяющая в себе некоторый сет персонажей.
 */
@Entity
@Table(name = "houses")
public class HouseEntity implements Serializable {
    /**
     * Идентификатор дома.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название дома.
     */
    @Column
    private String name;

    /**
     * Конструктор класса. Создаёт новый экземпляр класса {@link HouseEntity}.
     */
    public HouseEntity() {
        //
    }

    /**
     * Возвращает идентификатор дома.
     *
     * @return идентификатор дома.
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор дома.
     *
     * @param id идентификатор дома.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает название дома.
     *
     * @return название дома.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название дома.
     *
     * @param name название дома.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HouseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
