/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formes;

import Partie.Forme;

/**
 * Cette classe permet de construire une Forme Rectangle
 * @author Mattéo Miguelez
 */
public class Rectangle extends Forme{
    
    /**
     * Constructeur de la classe Rectangle
     * @param lig le nombre de ligne(s) souhaitée(s)
     * @param col le nombre de colonne(s) souhaitée(s)
     */
    public Rectangle(int lig, int col){
        // initialisation des lignes et colonnes
        setNb_ligne(lig); setNb_colonne(col);
        
        // Set le nom de la Forme Rectangle
        if (getNb_ligne() == 1 && getNb_colonne() > 1) setNom("Colonne" + col);
        else if (getNb_ligne() > 1 && getNb_colonne() == 1) setNom("Ligne" + lig);
        else if (getNb_ligne() == 2 && getNb_colonne() == 2) setNom("Carre");
        else setNom("Case");
        
        //initialisation du tableau
        cases = new boolean[getNb_ligne()][getNb_colonne()];
        for (int i = 0; i < getNb_ligne(); i++) {
            for (int j = 0; j < getNb_colonne(); j++){
                setCase(i, j, true);
            }
        }
        
        //initialisation des coordonnées du début de la forme
        // Ici, ce sera 0 0
        setCo_x(0); setCo_y(0);
        
        // initialisation de la variable nb_cases_remplies
        setNb_cases_remplis();
    }
}
