package org.epsic1.tpJPA;
import org.epsic1.tpJPA.Address;
import org.epsic1.tpJPA.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="petStore")
public class PetStore {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false, unique = false)
    private String name;

    @Column(name = "managerName", length = 50, nullable = false, unique = false)
    private String managerName;

    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "ID_PS", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PD", referencedColumnName = "ID")
    )
    private Set<Product> products;





    public PetStore(){

    }

    public void addProducts(Product product){
        this.products.add(product);
        product.getPetStores().add(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
