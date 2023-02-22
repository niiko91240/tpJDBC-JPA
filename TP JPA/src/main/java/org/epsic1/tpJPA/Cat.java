package org.epsic1.tpJPA;

import org.epsic1.tpJPA.Animal;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Cat extends Animal {
    private String chipId;

    public Cat() {
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
