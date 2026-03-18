package ui.model;

import java.awt.*;

public class Vaisseau extends Rectangle {

    public Vaisseau(int x, int y) {
        super(x, y, 50, 30, Color.RED);
    }

    public void deplacement(int distance) {
        x += distance;

        if(x < 0) {
            x = 0;
        } else if (x > 750) {
            x = 750;
        }
    }
}
