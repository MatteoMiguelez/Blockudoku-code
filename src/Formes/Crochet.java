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
public class Crochet extends Forme{
    
    /**
     * Constructeur de la classe Crochet
     * @param numero le numéro de la forme souhaitée, de 1 à 4, pour les 4 Crochets possibles
     */
    public Crochet(int numero){        
        switch (numero){
            case 1:
                setNb_ligne(2); setNb_colonne(3);
                setNom("Crochet_gauche");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(1, 1, false);
                break;
            case 2:
                setNb_ligne(2); setNb_colonne(3);
                setNom("Crochet_droit");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(0, 1, false);
                break;
            case 3:
                setNb_ligne(3); setNb_colonne(2);
                setNom("Crochet_haut");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(1, 1, false);
                break;
            case 4:
                setNb_ligne(3); setNb_colonne(2);
                setNom("Crochet_bas");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(1, 0, false);
                break;
        }
        
        //initialisation des coordonnées du début de la forme
        // Ici, ce sera 0 0
        setCo_x(0); setCo_y(0);
        
        // initialisation de la variable nb_cases_remplies
        setNb_cases_remplies(5);
    }
}
