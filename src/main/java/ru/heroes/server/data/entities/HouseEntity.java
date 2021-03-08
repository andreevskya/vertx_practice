package ru.heroes.server.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="houses")
public class HouseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public HouseEntity() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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
