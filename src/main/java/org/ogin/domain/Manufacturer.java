package org.ogin.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ogin
 */
@Entity
@Table(name = "Manufacturer")
public class Manufacturer implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    public Manufacturer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
