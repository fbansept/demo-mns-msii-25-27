package ui;

import ui.model.Ennemi;
import ui.model.Vaisseau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;
import java.util.List;

public class Jeu extends Canvas implements KeyListener {

    protected JFrame fenetre = new JFrame("Space Invaders");

    protected Vaisseau vaisseau;
    protected List<Ennemi> ennemis;

    protected boolean qPresssed = false;
    protected boolean dPresssed = false;
    protected boolean spacePresssed = false;

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

        this.fenetre.addKeyListener(this);

        this.createBufferStrategy(2);

        this.demarrer();
    }

    public void demarrer () throws InterruptedException {

        int iteration = 0;
        vaisseau = new Vaisseau(400, 500);
        ennemis = new ArrayList<>();

        //TODO : ajouter des ennemis a la liste (boucle imbriqué pour les geénérer
        // sous forme de bloc de 10 x 4 ennemis)

        while (true) {

            Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

            //Toute l'app ici
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, 800, 600);

            vaisseau.dessiner(dessin);

            //TODO : effectuer un mouvement a gauche et a droite
            // si le vaisseau n'a pas dépasser l'écran

            //TODO : créer la classe Rond et la classe Projectile qui en hérite

            //TODO : créer un projectile lorsque l'on appuie sur espace

            //TODO : si un ennemi est en collision avec un projectile :
            // - on supprime ce projectile
            // - l'ennemi perd une vie et change de couleur


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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Q) {
            qPresssed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            dPresssed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            spacePresssed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Q) {
            qPresssed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            dPresssed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            spacePresssed = false;
        }
    }
}
