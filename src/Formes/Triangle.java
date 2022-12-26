/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formes;

import Partie.Forme;

/**
 * Cette classe permet de construire une Forme Triangle
 * @author Mattéo Miguelez
 */

public class Triangle extends Forme {
    
    /**
     * Constructeur de la classe Triangle
     * @param numero le numéro de la forme souhaitée, de 1 à 4, pour les 4 Triangles possibles
     */
    public Triangle(int numero){
        // initialisation des lignes et colonnes
        setNb_ligne(2); setNb_colonne(2);
        
        //initialisation du tableau
        cases = new boolean[getNb_ligne()][getNb_colonne()];
        for (int i = 0; i < getNb_ligne(); i++) {
            for (int j = 0; j < getNb_colonne(); j++){
                setCase(i, j, true);
            }
        }
        
        switch (numero) {
                case 1:
                    setNom("Triangle_haut_gauche");
                    setCase(1, 0, false);
                    setCo_x(0); setCo_y(0);
                    break;
                case 2:
                    setNom("Triangle_haut_droit");
                    setCase(0, 0, false);
                    setCo_x(0); setCo_y(1);
                    break;
                case 3:
                    setNom("Triangle_bas_gauche");
                    setCase(1, 1, false);
                    setCo_x(0); setCo_y(0);
                    break;
                case 4:
                    setNom("Triangle_bas_droit");
                    setCase(0, 1, false);
                    setCo_x(0); setCo_y(0);
                    break;
        }
        
        // initialisation de la variable nb_cases_remplies
        setNb_cases_remplies(3);
    }
    
}
