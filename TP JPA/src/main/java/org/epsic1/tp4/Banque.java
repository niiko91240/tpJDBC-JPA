package org.epsic1.tp4;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="banque")
public class Banque {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 50, nullable = false, unique = false)
    private String nom;

    @OneToMany(mappedBy="banque")
    private Set<Client> clients;


    public Banque(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
