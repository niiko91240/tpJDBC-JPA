package org.epsic1.tpJPA;

import org.epsic1.tpJPA.Animal;

import javax.persistence.*;

@Entity
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
