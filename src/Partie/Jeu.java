/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Partie;

import Formes.*;
import java.util.ArrayList;

/** 
 * Cette classe permet de créer une partie
 * @author Mattéo Miguelez
 */
public class Jeu {
    protected static int taille = 9; // taille de la grille (ne change pas)
    public boolean[][] grille; // grille du jeu
    public ArrayList<Forme> liste_toutes_formes; // liste avec toutes les formes
    public ArrayList<Forme> liste3formes; // liste avec les 3 formes du tour
    public boolean[] etat3formes; // liste avec les 3 états des formes du tour
    public int score; // score du joueur
    public int serie; // serie de destruction, 0 si aucune destruction au tour précédent
    
    /**
     * Constructeur par défaut de la classe Jeu
     */
    public Jeu(){
        liste_toutes_formes = new ArrayList<>();
        liste3formes = new ArrayList<>();
        etat3formes = new boolean[3];
        for (int i = 0; i < 3; i++) etat3formes[i] = true;
        score = 0;
        serie = 0;
        initGrille();
        initListe_toutes_formes();
        ajoutFormes();
    }
    
    /**
     * Accesseur de la variable taille
     * @return la variable taille
     */
    public int getTaille(){
        return taille;
    }
    
    /**
     * Construit une grille de taille*taille où les cases sont vides
     */
    public final void initGrille(){
        grille = new boolean[getTaille()][getTaille()];
        for (int i = 0; i < getTaille(); i++) {
            for (int j = 0; j < getTaille(); j++){
                grille[i][j] = false;
            }
        }
    }
    
    /**
     * Renvoie true si la Case est remplie, false sinon
     * @param lig la ligne séléctionnée
     * @param col la colonne séléctionnée
     * @return valeur de grille[lig][col]
     */
    public boolean getEtatCase(int lig, int col){
        return grille[lig][col];
    }
    
    /**
     * Fixe la valeur val dans la grille en position lig, col
     * @param lig la ligne souhaitée
     * @param col la colonne souhaitée
     * @param val la valeur souhaitée
     */
    public void setEtatCase(int lig, int col, boolean val){
        grille[lig][col] = val;
    }
    
    /**
     * Initialise la liste_toutes_formes en ajoutant toutes les formes possibles
     */
    public final void initListe_toutes_formes(){
        //Colonnes et Lignes
        for (int i = 2; i < 6; i++) {
            liste_toutes_formes.add(new Rectangle(1, i));
            liste_toutes_formes.add(new Rectangle(i, 1));
        }
        
        // Carré et Case
        liste_toutes_formes.add(new Rectangle(2,2)); liste_toutes_formes.add(new Rectangle(1,1));
        
        for (int i = 1; i < 5; i++) liste_toutes_formes.add(new Triangle(i));
        for (int i = 1; i < 5; i++) liste_toutes_formes.add(new GrandL(i));
        for (int i = 1; i < 5; i++) liste_toutes_formes.add(new Crochet(i));
        for (int i = 1; i < 5; i++) liste_toutes_formes.add(new Pyramide(i));
        for (int i = 1; i < 9; i++) liste_toutes_formes.add(new PetitL(i));
        for (int i = 1; i < 5; i++) liste_toutes_formes.add(new Zigzag(i));
        for (int i = 1; i < 5; i++) liste_toutes_formes.add(new Diagonale(i));
        liste_toutes_formes.add(new Cercle());
    }
    
    /**
     * Calcul un nombre aléatoire en fonction de la taille de la liste de toutes les Formes
     * @return une Forme aléatoire de la liste liste_toutes_formes
     */
    public Forme randomForme(){
        int rand = (int)(Math.random()*liste_toutes_formes.size());
        return liste_toutes_formes.get(rand);
    }
    
    /**
     * Ajoute les 3 formes aléatoires à liste3formes
     */
    public void ajoutFormes(){
        supprimerFormes();
        liste3formes.add(randomForme());
        liste3formes.add(randomForme());
        liste3formes.add(randomForme());
    }
    
    /**
     * Supprime les 3 formes de la liste3formes
     */
    public void supprimerFormes(){
        liste3formes.clear();
    }
    
    /**
     * Vérifie la grille de jeu et la clear si besoin
     */
    public void Verif_clear_all(){
        int cpt = 0;    
        ArrayList<Integer> val_col = new ArrayList<>(); // stock les valeurs pr les colonnes
        ArrayList<Integer> val_lig = new ArrayList<>(); // stock les valeurs pr les lignes
        // stock les valeurs des carrés remplis dans les deux listes (i = val_1, j = val_2)
        ArrayList<Integer> val_1 = new ArrayList<>();
        ArrayList<Integer> val_2 = new ArrayList<>();
        
        
        // Verifie si les lignes colonnes et carré sont complets
        // et ajoute les valeurs dans les listes correspondantes
        for (int i = 0; i < getTaille(); i++){
            if (VerifColonne(i)){
                cpt++;
                val_col.add(i);
            }
            if (VerifLigne(i)){
                cpt++;
                val_lig.add(i);
            }
        }
        
        // Verifie si les carrés sont complets et ajoute les valeurs
        // dans les listes correspondantes
        for (int i = 0; i< getTaille(); i+= 3){
            for (int j =0; j < getTaille(); j+= 3){
                if (VerifCarre(i, j)){
                    cpt++;
                    val_1.add(i); val_2.add(j);
                    // Ajout des valeurs dans les ArrayList correspondantes pour la suppression
                }
            }
        }
        
        // Suppression des valeurs à partir des listes initialisés au dessus
        for (int i = 0; i < val_col.size(); i++) VideColonne(val_col.get(i));
        for (int i =0; i < val_lig.size(); i++) VideLigne(val_lig.get(i));
        for (int i = 0; i < val_1.size(); i++){ VideCarre(val_1.get(i), val_2.get(i));}
        
        // A chaque ligne/colonne/carre remplis, on ajoute cpt*9+ cpt points au score
        if (cpt!= 0) serie++;
        else serie = 0;
        
        int temp = 0;
        
        for (int i = 0; i < cpt; i++){
            temp += 16 - i;
        } 
        if (serie > 1) {
            temp += 8 + serie*2;
        }
        
        score += temp;
    }
    
    /**
     * Vérifie si la ligne est complètement remplie ou non
     * @param lig la ligne examinée
     * @return true si la ligne est complète, false sinon
     */
    public boolean VerifLigne(int lig){
        for (int i = 0; i < taille; i++)
            if (getEtatCase(lig, i) == false) return false;
        return true;
    }  
    
    /**
     * Vérifie si la colonne est complètement remplie ou non
     * @param col la colonne examinée
     * @return true si la colonne est complète, false sinon
     */
    public boolean VerifColonne(int col){
        for (int i = 0; i < taille; i++) 
            if (getEtatCase(i, col) == false) 
                return false;
        return true;
    }
    
    /**
     * Vérifie si l'ensemble de 3*3 où se trouve lig, col est remplie ou non
     * On prendra la case en haut à gauche pour faire le test
     * @param lig la ligne 
     * @param col la colonne
     * @return true si l'ensemble de 3*3 est complet, false sinon
     */
    public boolean VerifCarre(int lig, int col){
        for (int i = lig; i < lig+getTaille()/3; i++)
            for (int j = col; j < col+getTaille()/3; j++)
                if (getEtatCase(i, j) == false) return false;
        return true;
    }
    
    /**
     * Vide la ligne entrée en paramètre
     * @param lig la ligne à vider
     */
    public void VideLigne(int lig){
        for(int i = 0; i < taille; i++) 
            setEtatCase(lig, i, false);
    }
    
    /**
     * Vide la colonne entrée en paramètre
     * @param col la colonne à vider
     */
    public void VideColonne(int col){
        for(int j = 0; j < taille; j++) 
            setEtatCase(j, col, false);
    }
    
    /**
     * Vide l'ensemble de 3*3 où se trouve lig, col
     * On prendra la case en haut à gauche pour commencer à vider
     * @param lig la ligne où commence le carré
     * @param col la colonne où commence le carré
     */
    public void VideCarre(int lig, int col){
        for(int i= lig; i < lig+getTaille()/3; i++)
            for (int j = col; j < col+getTaille()/3; j++)
                setEtatCase(i, j, false);
    }
    
    /**
     * Vérifie s'il est possible ou non de placer la Forme en x, y
     * @param f la forme a placer
     * @param x la ligne où on souhaite commencer à placer la Forme
     * @param y la colonne où on souhaite commencer à placer la Forme
     * @return true si f peut être placée, false sinon
     */
    public boolean VerifplaceForme(Forme f, int x, int y){
        for (int i = 0; i < f.getNb_ligne(); i++)
            for (int j = 0;j < f.getNb_colonne(); j++){
                // Si la valeur de la Forme est True et la valeur de la case aussi
                // il est impossible de poser la Forme
                if (j+x >= getTaille() || y+i >= getTaille() || j+x < 0 || y+i <0) 
                    return false;
                if (f.getValeur(i, j) && getEtatCase(x + j, y + i)) 
                    return false;
            }
        return true;
    }
    
    /**
     * Ajout la Forme f à la grille en position x, y
     * @param f la Forme à ajouter
     * @param x la ligne où on commence à placer la Forme
     * @param y la colonne où on commence à placer la Forme
     */
    public void ajoutGrille(Forme f, int x, int y){
        for (int i = 0; i < f.getNb_ligne(); i++)
            for (int j = 0;j < f.getNb_colonne(); j++)
                if (f.getValeur(i, j))
                    setEtatCase(x+ j, y+ i, true);
    }
    
    /**
     * Verifie qu'il est toujours possible de jouer
     * @return true si la partie est terminée, false sinon
     */
    public boolean finPartie(){
        for (int i = 0; i < 3; i++){
            if (etat3formes[i]){
                Forme f = liste3formes.get(i);
                for (int j = 0; j < getTaille(); j++)
                    for (int k = 0; k < getTaille(); k++)
                        if (VerifplaceForme(liste3formes.get(i), k, j)) return false;
            }
        }
        return true;
    }
    
    /**
     * Affiche la liste contenant toutes les formes
     */
    public void afficheListe(){
        for (int i = 0; i < liste_toutes_formes.size(); i++)
            liste_toutes_formes.get(i).affiche();
    }

    /**
     * Affiche la grille, si la case est remplie, affiche un X,
     * sinon affiche un O
     */
    public void afficheGrille(){
        String str;
        for (int i = 0; i < taille; i++){
            str= " ";
            for (int j = 0;j < taille; j++)
                if (getEtatCase(i, j) == true) str+= "X ";
                else str+= "O ";
            System.out.println(str);
        }
    }
}