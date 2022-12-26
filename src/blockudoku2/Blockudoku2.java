/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blockudoku2;

import Interface.*;
import Partie.*;

/**
 * Classe Main qui permet de lancer le jeu
 * @author Mattéo Miguelez
 */
public class Blockudoku2 {

    /**
     * Fonction principale
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VueJeu fenetre = new VueJeu(new Jeu());
        fenetre.setVisible(true);
        fenetre.setLocationRelativeTo(null);
    }
}
