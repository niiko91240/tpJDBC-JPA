package org.epsic1.tp4;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 50, nullable = false, unique = false)
    private String nom;

    @Column(name = "prenom", length = 50, nullable = false, unique = false)
    private String prenom;

    @Column(name = "dateNaissance", length = 50, nullable = false, unique = false)
    private Date dateNaissance;

    @ManyToOne
    @JoinColumn(name="id_banque") private
    Banque banque;

    @ManyToMany
    @JoinTable(name="compte_client",
            joinColumns= @JoinColumn(name="id_compte", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_client", referencedColumnName="id")
    )
    private Set<Compte> comptes;


    @OneToOne
    private Adresse adresse;






    public Client(){

    }





    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

}
