/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formes;

import Partie.Forme;

/**
 * Cette classe permet de construire une Forme Diagonale
 * @author Mattéo Miguelez
 */
public class Diagonale extends Forme{
    
    /**
     * Constructeur de la classe Diagonale
     * @param numero le numéro de la forme souhaitée, de 1 à 4, pour les 4 Diagonales possibles
     */
    public Diagonale(int numero){
        switch (numero){
            case 1:
                setNb_ligne(2); setNb_colonne(2);
                setNom("Diagonale2_gauche");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                setCase(0, 0, true); setCase(1, 1, true);
                setCase(0, 1, false); setCase(1, 0, false);
                setCo_x(0); setCo_y(0);
                break;
            case 2:
                setNb_ligne(2); setNb_colonne(2);
                setNom("Diagonale2_droite");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                setCase(0, 0, false); setCase(1, 1, false);
                setCase(0, 1, true); setCase(1, 0, true);
                setCo_x(0); setCo_y(1);
                break;
            case 3:
                setNb_ligne(3); setNb_colonne(3);
                setNom("Diagonale3_gauche");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, false);
                setCase(0, 0, true); setCase(1, 1, true); setCase(2, 2, true);
                setCo_x(0); setCo_y(0);
                break;
            case 4:
                setNb_ligne(3); setNb_colonne(3);
                setNom("Diagonale3_droite");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, false);
                setCase(0, 2, true); setCase(1, 1, true); setCase(2, 0, true);
                setCo_x(0); setCo_y(2);
                break;
        }
        
        // initialisation de la variable nb_cases_remplies
        setNb_cases_remplis();
    }
    
}
