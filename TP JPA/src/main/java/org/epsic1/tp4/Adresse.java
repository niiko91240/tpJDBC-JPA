package org.epsic1.tp4;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", length = 50, nullable = false, unique = false)
    private int numero;

    @Column(name = "rue", length = 50, nullable = false, unique = false)
    private String rue;

    @Column(name = "codePostal", length = 50, nullable = false, unique = false)
    private int codePostal;

    @Column(name = "ville", length = 50, nullable = false, unique = false)
    private String ville;

    @ManyToOne
    @JoinColumn(name="id_banque") private
    Banque banque;

    @ManyToMany
    @JoinTable(name="compte_client",
            joinColumns= @JoinColumn(name="id_compte", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_client", referencedColumnName="id")
    )
    private Set<Compte> comptes;






    public Adresse(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

}
