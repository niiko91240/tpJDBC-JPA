package org.epsic1.tp4;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="compte")
@DiscriminatorColumn(name = "type")
public class Compte {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", length = 50, nullable = false, unique = false)
    private String numero;

    @Column(name = "solde", length = 50, nullable = false, unique = false)
    private double solde;

    @ManyToMany(mappedBy="comptes")
    private Set<Client> clients;

    @OneToMany(mappedBy="compte")
    private Set<Operation> operations;


    public Compte(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }


}
