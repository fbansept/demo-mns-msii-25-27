package ui.model;

import java.awt.*;

public class Projectile extends Rond {

    protected int vitesse;

    public Projectile(int x, int y) {
        super(x, y, 10, Color.BLUE);
        this.vitesse = -5;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void deplacement() {
        y += vitesse;
    }

    public boolean testColision(Ennemi ennemi) {
        return x > ennemi.getX()
                && y > ennemi.getY()
                && x < ennemi.getX() + ennemi.getLargeur()
                && y < ennemi.getY() + ennemi.getHauteur();


    }
}
