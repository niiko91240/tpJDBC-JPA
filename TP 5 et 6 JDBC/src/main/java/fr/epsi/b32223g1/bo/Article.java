package fr.epsi.b32223g1.bo;

public class Article {

    private int id;
    private String name;
    private Double prix;
    private Fournisseur fournisseur;

    public Article() {
    }

    public Article( int id, String name, Fournisseur fournisseur, Double prix) {
        this.id = id;
        this.name = name;
        this.fournisseur = fournisseur;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}
