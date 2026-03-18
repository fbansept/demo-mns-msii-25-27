package ui.model;

import java.awt.*;

public class Ennemi extends Rectangle {

    protected static Color COULEUR_3_VIE = new Color(34, 76, 0);
    protected static Color COULEUR_2_VIE = new Color(62, 114, 19);
    protected static Color COULEUR_1_VIE = new Color(138, 189, 95);

    private int vie = 3;

    public Ennemi(int x, int y) {
        super(x, y, 30, 20, COULEUR_3_VIE);
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
        this.couleur = vie == 3
                ? COULEUR_3_VIE
                : (vie == 2 ? COULEUR_2_VIE : COULEUR_1_VIE);
    }

    public boolean diminuerVie() {
        this.setVie(vie - 1);
        return vie > 0;
    }
}
