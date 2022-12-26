/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Partie;

/**
 * Cette classe crée une Forme implémentée avec les sous-classes
 * @author Mattéo Miguelez
 */
public class Forme {
    protected String nom; // nom de la forme
    protected int nb_ligne; // nb de lignes de la forme
    protected int nb_colonne; // nb de colonnes de la forme
    protected int nb_cases_remplies; // nb de cases remplies de la forme
    protected boolean[][] cases; // la forme en tableau de booléens
    protected int co_x, co_y; // les coordonnées du "début" de la forme
    
    /**
     * Constructeur par défaut de la classe Forme
     */
    public Forme(){
        nom = "Case";
        nb_ligne = 1; nb_colonne = 1; nb_cases_remplies = 1;
        co_x = 0; co_y = 0;
        cases = new boolean[nb_ligne][nb_colonne];
        cases[0][0] = true;
    }
    
    /**
     * Accesseur au nombre de cases remplie(s) de la Forme
     * @return le nombre de cases remplie(s) de la Forme
     */
    public int getNb_cases_remplies(){
        return this.nb_cases_remplies;
    }
    
    /**
     * Accesseur au nombre de ligne(s) de la Forme
     * @return le nombre de ligne(s) de la Forme 
     */
    public int getNb_ligne(){
        return nb_ligne;
    }
    
    /**
     * Accesseur au nombre de colonne(s) de la Forme
     * @return le nombre de colonne(s) de la Forme
     */
    public int getNb_colonne(){
        return nb_colonne;
    }
    
    /**
     * Accesseur à l'attribut nom
     * @return l'attribut nom
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * Accesseur à la valeur co_x qui représente le x du point central de la Forme
     * @return la valeur de co_x de la Forme
     */
    public int getCo_x(){
        return co_x;
    }
    
    /**
     * Accesseur à la valeur co_y qui représente le y du point central de la Forme
     * @return la valeur de co_x de la Forme
     */
    public int getCo_y(){
        return co_y;
    }
    
    /**
     * Fixe la valeur de co_x (qui représente le x du point central de la Forme)
     * @param co_x la valeur a donner
     */
    public void setCo_x(int co_x){
        this.co_x = co_x;
    }
    
    /**
     * Fixe la valeur de co_x (qui représente le x du point central de la Forme)
     * @param co_y la valeur a donner
     */
    public void setCo_y(int co_y){
        this.co_y = co_y;
    }
    
    /**
     * Fixe le nombre de colonnes de la Forme
     * @param nb_colonne le nombre de colonnes de la Forme
     */
    public void setNb_colonne(int nb_colonne){
        this.nb_colonne = nb_colonne;
    }
    
    /**
     * Fixe le nom de la Forme
     * @param nom le nom de la Forme
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    
    /**
     * Fixe le nombre de lignes de la Forme
     * @param nb_ligne le nombre de lignes de la Forme
     */
    public void setNb_ligne(int nb_ligne){
        this.nb_ligne = nb_ligne;
    }
    
    /**
     * Set l'attribut nb_cases_remplies à partir du paramètre
     * @param nb_cases le nombre de cases remplies
     */
    public void setNb_cases_remplies(int nb_cases){
        nb_cases_remplies =nb_cases;
    }
    
    /**
     * Fixe et calcul le nombre de cases remplies de la Forme 
     */
    public void setNb_cases_remplis(){
        int somme = 0;
        for (int i = 0; i < nb_ligne; i++){
            for (int j = 0; j < nb_colonne; j++){
                if (getValeur(i, j) == true) somme++;
            }
        }
        this.nb_cases_remplies = somme;
    }
    
    /**
     * Fixe la case à l'état etat
     * @param ligne la ligne où se trouve la case
     * @param colonne la colonne où se trouve la case
     * @param etat l'état de la case
     */
    public void setCase(int ligne, int colonne, boolean etat){
        cases[ligne][colonne] = etat;
    }
    
    /**
     * Renvoie la valeur booléenne de la Case[l][c] 
     * @param l la ligne
     * @param c la colonne
     * @return true si la Case[l][c] est remplie, false sinon
     */
    public boolean getValeur(int l, int c){
        return cases[l][c];
    }
    
    /**
     * Affiche la Forme, une case rempli est représentée par un X,
     * une case vide est réprésentée par un espace vide
     */
    public void affiche(){
        String str;
        System.out.println(getNom()); // Affiche le nom de la Forme
        for (int i = 0; i < nb_colonne; i++){
            str = " ";
            for (int j = 0; j < nb_ligne; j++){
                if(getValeur(j, i) && i== co_x && j == co_y) str+= "C ";
                else if (getValeur(j, i) == true) 
                    str+= "X ";
                else str+= "  ";
            }
            System.out.println(str);
        }
        System.out.println("");
    }
}
