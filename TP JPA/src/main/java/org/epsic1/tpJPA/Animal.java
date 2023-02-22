package org.epsic1.tpJPA;
import org.epsic1.tpJPA.PetStore;
import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="animal")
public class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "birth", length = 50, nullable = false, unique = false)
    private Date birth;

    @Column(name = "couleur", length = 50, nullable = false, unique = false)
    private String couleur;

    @ManyToOne
    private PetStore petStore;


    public Animal(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
