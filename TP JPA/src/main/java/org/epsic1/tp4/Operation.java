package org.epsic1.tp4;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="operation")
public class Operation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", length = 50, nullable = false, unique = false)
    private Date date;

    @Column(name = "montant", length = 50, nullable = false, unique = false)
    private double montant;

    @Column(name = "motif", length = 50, nullable = false, unique = false)
    private String motif;

    @ManyToOne
    @JoinColumn(name="id_compte") private
    Compte compte;


    public Operation(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }


}
