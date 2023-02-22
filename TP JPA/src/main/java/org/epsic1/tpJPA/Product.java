package org.epsic1.tpJPA;

import org.epsic1.tpJPA.PetStore;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", length = 50, nullable = false, unique = false)
    private String code;

    @Column(name = "label", length = 50, nullable = false, unique = false)
    private String label;

    @Column(name = "price", length = 50, nullable = false, unique = false)
    private double price;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Set<PetStore> petStores;

    {
        petStores = new HashSet<>();
    }




    public Product(){

    }

    public void addPetStores(PetStore petStore){
        this.petStores.add(petStore);
        //petStore.getProducts().add(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }
}
