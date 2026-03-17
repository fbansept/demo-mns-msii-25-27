package demo.model;

public class Utilisateur {

    private String nom;
    protected String prenom;
    protected int age;
    protected boolean majeur;

    public Utilisateur(String nom) {
        this.nom = nom;
        this.prenom = "Inconnu";
        this.age = 18;
        this.majeur = true;
    }

    public Utilisateur(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.setAge(age);
    }

    public String nomComplet() {
        return nom + " " + prenom ;
    }

    public String getNom() {
        return nom.toUpperCase();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.majeur = age >= 18;
    }

    public boolean isMajeur() {
        return majeur;
    }


}
