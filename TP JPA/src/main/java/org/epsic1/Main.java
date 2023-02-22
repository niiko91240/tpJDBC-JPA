package org.epsic1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

import org.epsic1.tpJPA.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-tpJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction(); transaction.begin();


        Address address1 = new Address();
        address1.setNumber("175");
        address1.setStreet("Avenue Louis de Broglie");
        address1.setCity("Nantes");
        address1.setZipCode("44300");

        Fish fish1 = new Fish();
        fish1.setBirth(new Date(2022,02,02));
        fish1.setCouleur("Bleu");
        fish1.setLivingEnv(FishLivEnv.FRESH_WATER);

        Cat cat1 = new Cat();
        cat1.setBirth(new Date(2022,05,06));
        cat1.setCouleur("Noir");
        cat1.setChipId("5");

        Product product1 = new Product();
        product1.setCode("25");
        product1.setLabel("Brosse");
        product1.setPrice(29.99);
        product1.setType(ProdType.CLEANING);

        PetStore petStore1 = new PetStore();
        petStore1.setName("Animalerie de Poudlard");
        petStore1.setManagerName("Harry Potter");
        petStore1.setAddress(address1);

        Set<PetStore> petStores = new HashSet<PetStore>();
        petStores.add(petStore1);
        product1.setPetStores(petStores);

        Set<Product> products = new HashSet<Product>();
        products.add(product1);
        petStore1.setProducts(products);

        cat1.setPetStore(petStore1);
        fish1.setPetStore(petStore1);

        em.persist(cat1);
        em.persist(fish1);
        em.persist(product1);
        transaction.commit();
        em.close();
        emf.close();
    }
}