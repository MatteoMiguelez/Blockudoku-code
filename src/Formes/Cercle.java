/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formes;

import Partie.Forme;

/**
 * Cette classe permet de construire une Forme Crochet
 * @author Mattéo Miguelez
 */
public class Cercle extends Forme{
    
    /**
     * Constructeur de la classe Cercle
     */
    public Cercle(){
        // initialisation des lignes et colonnes
        setNb_ligne(3); setNb_colonne(3);
        
        // Set le nom de la Forme Rectangle
        setNom("Cercle");
        
        //initialisation du tableau
        cases = new boolean[getNb_ligne()][getNb_colonne()];
        for (int i = 0; i < getNb_ligne(); i++) {
            for (int j = 0; j < getNb_colonne(); j++){
                setCase(i, j, true);
            }
        }
        setCase(0, 0, false); setCase(0, 2, false); setCase(2, 0, false); setCase(2, 2, false);
        
        //initialisation des coordonnées du début de la forme
        // Ici, ce sera 0 0
        setCo_x(0); setCo_y(1);
        
        // initialisation de la variable nb_cases_remplies
        setNb_cases_remplies(5);
    }
}
