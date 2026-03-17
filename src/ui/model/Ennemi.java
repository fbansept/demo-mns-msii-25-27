package ui.model;

import java.awt.*;

    public class Ennemi extends Rectangle {

    protected int vie = 3;

    public Ennemi(int x, int y) {
        super(x, y, 30, 20,Color.GREEN);
    }
}
