package ui;

import ui.model.Sprite;
import ui.model.Vaisseau;

import javax.swing.*;
import java.awt.*;

public class Jeu extends Canvas {

    protected JFrame fenetre = new JFrame("Space Invaders");
    protected Vaisseau vaisseau;

    public Jeu () throws InterruptedException {

        this.setSize(800, 600);
        this.setBounds(0, 0, 800, 600);

        this.fenetre.pack();
        this.fenetre.setSize(800, 600);

        JPanel panneau = new JPanel();
        panneau.add(this);
        this.fenetre.setContentPane(panneau);

        this.fenetre.requestFocus();
        this.setFocusable(false);

        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetre.setIgnoreRepaint(true);
        this.fenetre.setResizable(false);
        this.fenetre.setVisible(true);

        this.createBufferStrategy(2);

        this.demarrer();
    }

    public void demarrer () throws InterruptedException {

        int iteration = 0;
        vaisseau = new Vaisseau(400, 500);

        while (true) {

            Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

            //Toute l'app ici
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, 800, 600);

            dessin.setColor(vaisseau.getCouleur());
            dessin.fillRect(
                    vaisseau.getX(),
                    vaisseau.getY(),
                    vaisseau.getLargeur(),
                    vaisseau.getHauteur());

            //----

            dessin.dispose();
            this.getBufferStrategy().show();

            Thread.sleep(1000 / 60);
            iteration ++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Jeu();
    }

}
