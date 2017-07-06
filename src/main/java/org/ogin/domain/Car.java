package org.ogin.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ogin
 */
@Entity
@Table(name="Car")
public class Car implements Serializable{
    @Id
    @Column(name="id")
    private int id;
    @Column(name = "vin")
    private String vin;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Model model;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
