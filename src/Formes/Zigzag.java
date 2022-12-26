/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formes;

import Partie.Forme;

/**
 * Cette classe permet de créer une Forme ZigZag
 * @author Mattéo Miguelez
 */
public class Zigzag extends Forme{
    
    /**
     * Constructeur de la classe Zigzag
     * @param numero le numero de la forme souhaitée, de 1 à 4, pour les 4 Zigzags possibles
     */
    public Zigzag(int numero){        
        switch (numero){
            case 1:
                setNb_ligne(3); setNb_colonne(2);
                setNom("Zigzag_h_1");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(0, 1, false); setCase(2, 0, false);
                setCo_x(0); setCo_y(0);
                break;
            case 2:
                setNb_ligne(3); setNb_colonne(2);
                setNom("Zigzag_h_2");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(0, 0, false); setCase(2, 1, false);
                setCo_x(0); setCo_y(1);
                break;
            case 3:
                setNb_ligne(2); setNb_colonne(3);
                setNom("Zigzag_v_1");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(1, 0, false); setCase(0, 2, false);
                setCo_x(0); setCo_y(0);
                break;
            case 4:
                setNb_ligne(2); setNb_colonne(3);
                setNom("Zigzag_v_2");
                cases = new boolean[getNb_ligne()][getNb_colonne()];
                for (int i = 0; i < getNb_ligne(); i++)
                    for (int j = 0; j < getNb_colonne(); j++)
                        setCase(i, j, true);
                setCase(0, 0, false); setCase(1, 2, false);
                setCo_x(0); setCo_y(1);
                break;
        }
        
        // initialisation de la variable nb_cases_remplies
        setNb_cases_remplies(4);
    }
}
