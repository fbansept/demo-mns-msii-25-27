package ui;

import ui.model.Ennemi;
import ui.model.Projectile;
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
    protected List<Projectile> projectiles;

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
        projectiles = new ArrayList<>();

        //ajouter des ennemis a la liste (boucle imbriqué pour les générer
        //sous forme de bloc de 10 x 4 ennemis)
        for(int indexLigne = 0; indexLigne < 4 ; indexLigne ++ ) {
            for(int indexColonne= 0; indexColonne < 10 ; indexColonne ++ ) {
                Ennemi ennemi = new Ennemi(indexColonne * 40 + 20, indexLigne * 30);
                ennemis.add(ennemi);
            }
        }

        int iterationDepuisDernierTir = 0;

        while (true) {

            Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

            //Toute l'app ici
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, 800, 600);

            vaisseau.dessiner(dessin);

            for(Ennemi ennemi : ennemis) {
                ennemi.dessiner(dessin);
            }

            for(Projectile projectile : projectiles) {
                projectile.dessiner(dessin);
            }

            //effectuer un mouvement a gauche et a droite
            //si le vaisseau n'a pas dépasser l'écran
            if(qPresssed) {
                vaisseau.deplacement(-5);
            } else if(dPresssed) {
                vaisseau.deplacement(5);
            }

            if(spacePresssed && iterationDepuisDernierTir > 30) {
                iterationDepuisDernierTir = 0;
                projectiles.add(new Projectile(vaisseau.getX() + vaisseau.getLargeur() /2, vaisseau.getY()));
            }

            List<Projectile> projectilesAsupprimer = new ArrayList<>();
            List<Ennemi> ennemisAsupprimer = new ArrayList<>();

            for(Projectile projectile : projectiles) {
                projectile.deplacement();
                for(Ennemi ennemi : ennemis) {
                    if(projectile.testColision(ennemi)) {

                        //si l'ennemi n'a plus de vie
                        if(!ennemi.diminuerVie()) {
                            ennemisAsupprimer.add(ennemi);
                        }
                        projectilesAsupprimer.add(projectile);
                        //Note : projectiles.remove(projectile); impossible durant le parcours de la liste
                    }
                }
            }

            //on enleve de la liste les projectile a supprimer
            for(Projectile projectile : projectilesAsupprimer) {
                projectiles.remove(projectile);
            }
            //on enleve de la liste les ennemi a supprimer
            for(Ennemi ennemi : ennemisAsupprimer) {
                ennemis.remove(ennemi);
            }

            //----

            dessin.dispose();
            this.getBufferStrategy().show();

            Thread.sleep(1000 / 60);
            iteration ++;
            iterationDepuisDernierTir ++;
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
