package ui.model;

import java.awt.*;

public abstract class Rond extends Sprite {

    protected int diametre;

    public Rond(int x, int y, int diametre, Color couleur) {
        super(x, y, couleur);
        this.diametre = diametre;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x, y, diametre, diametre);
    }
}
