/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formes;

import Partie.Forme;

/**
 * Cette classe permet de construire une Forme GrandL
 * @author Mattéo Miguelez
 */
public class GrandL extends Forme{
    
    /**
     * Constructeur de la classe GrandL
     * @param numero le numéro de la forme souhaitée, de 1 à 4, pour les 4 GrandL possibles
     */
    public GrandL(int numero){
        // initialisation des lignes et colonnes
        setNb_ligne(3); setNb_colonne(3);
        
        //initialisation du tableau
        cases = new boolean[getNb_ligne()][getNb_colonne()];
        for (int i = 0; i < getNb_ligne(); i++) {
            for (int j = 0; j < getNb_colonne(); j++){
                setCase(i, j, true);
            }
        }
        
        switch (numero){
            case 1:
                setNom("GrandL_haut_gauche");
                for (int i = 1; i <3; i++)
                    for (int j = 1; j < 3; j++)
                        setCase(i, j, false);
                setCo_x(0); setCo_y(0);
                break;
            case 2:
                setNom("GrandL_haut_droit");
                for (int i = 0; i < 2; i++)
                    for (int j = 1; j < 3; j++)
                        setCase(i, j, false);
                setCo_x(0); setCo_y(0);
                break;
            case 3:
                setNom("GrandL_bas_gauche");
                for (int i = 1; i < 3; i++)
                    for (int j = 0; j < 2; j++)
                        setCase(i, j, false);
                setCo_x(0); setCo_y(0);
                break;
            case 4:
                setNom("GrandL_bas_droit");
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        setCase(i, j, false);
                setCo_x(0); setCo_y(2);
                break;
        }
        
        // initialisation de la variable nb_cases_remplies
        setNb_cases_remplies(5);
    }
    
}
