package demo.model;

public class Etudiant extends Utilisateur {

    private int noteGlobale;

    public Etudiant(String nom, String prenom, int age, int noteGlobale) {
        super(nom, prenom, age);
        this.noteGlobale = noteGlobale;
    }

    @Override
    public String nomComplet() {
        return "Etd." + this.getNom();
    }
}
