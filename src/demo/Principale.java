package demo;

import demo.model.Etudiant;
import demo.model.Utilisateur;

public class Principale {

    public static void main(String[] args) {

        Utilisateur utilisateur = new Utilisateur("bansept", "franck", 18);
        Utilisateur etudiant = new Etudiant("bansept", "franck", 18, 20);
        System.out.println(utilisateur.nomComplet());
        System.out.println(etudiant.nomComplet());

    }
}
