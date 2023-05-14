package com.example.exam;

public class Enfant {

    private int id;
    private String nom;
    private String prenom;
    private String pays;
    private String ville;
    private String codePostal;
    private int age;
    private String cadeau;
    private int nivDeSagesse;

    public Enfant(int id, String nom, String prenom, String pays, String ville, String codePostal, int age, String cadeau, int nivDeSagesse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.ville = ville;
        this.codePostal = codePostal;
        this.age = age;
        this.cadeau = cadeau;
        this.nivDeSagesse = nivDeSagesse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCadeau() {
        return cadeau;
    }

    public void setCadeau(String cadeau) {
        this.cadeau = cadeau;
    }

    public int getNivDeSagesse() {
        return nivDeSagesse;
    }

    public void setNivDeSagesse(int nivDeSagesse) {
        this.nivDeSagesse = nivDeSagesse;
    }
}
