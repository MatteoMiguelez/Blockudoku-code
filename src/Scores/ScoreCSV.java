/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cette classe permet de gérer les scores à partir d'un fichier csv
 * @author Mattéo Miguelez
 */
public class ScoreCSV {
    public ArrayList<String> names; // Les noms des joueurs
    public ArrayList<String> scores; // Les scores des joueurs
    public String pseudoPremier, pseudoDeuxieme, pseudoTroisieme;
    public String scorePremier, scoreDeuxieme, scoreTroisieme;
    public boolean enregistrer; // Score déjà enregistré
        
    /**
     * Constructeur par défaut de la classe ScoreCSV
     */
    public ScoreCSV(){
        names = new ArrayList<>();
        scores = new ArrayList<>();
        enregistrer = false;
        pseudoPremier = "Premier";
        pseudoDeuxieme = "Deuxième";
        pseudoTroisieme = "Troisième";
        scorePremier = "0";
        scoreDeuxieme = "0";
        scoreTroisieme = "0";
        getScore("autre/MALHEUR_SI_TU_OUVRES/scores.csv");
        setScoresPseudos();
    }

    /**
     * Initialisation des scores et pseudos des joueurs
     */
    public void setScoresPseudos(){
        if (names.size() >= 1){
            pseudoPremier = getNames().get(0);
            scorePremier = getScores().get(0); 
        }
        if (names.size() >= 2){
            pseudoDeuxieme = getNames().get(1);
            scoreDeuxieme = getScores().get(1);              
        }
        if (names.size() >= 3){
            pseudoTroisieme = getNames().get(2);
            scoreTroisieme = getScores().get(2);
        }     
    }
    
    /**
     * Accesseur du pseudo du premier joueur
     * @return le pseudo du premier joueur
     */
    public String getPseudoPremier() {
        return pseudoPremier;
    }

    /**
     * Accesseur du pseudo du deuxième joueur
     * @return le pseudo du deuxième joueur
     */
    public String getPseudoDeuxieme() {
        return pseudoDeuxieme;
    }

    /**
     * Accesseur du pseudo du troisième joueur
     * @return le pseudo du troisième joueur
     */
    public String getPseudoTroisieme() {
        return pseudoTroisieme;
    }

    /**
     * Accesseur du score du premier joueur
     * @return le score du premier joueur
     */
    public String getScorePremier() {
        return scorePremier;
    }

    /**
     * Accesseur du score du deuxième joueur
     * @return le score du deuxième joueur
     */
    public String getScoreDeuxieme() {
        return scoreDeuxieme;
    }

    /**
     * Accesseur du score du troisième joueur
     * @return le score du troisième joueur
     */
    public String getScoreTroisieme() {
        return scoreTroisieme;
    }
    
    /**
     * Accesseur de la liste des noms de joueurs
     * @return la liste des noms de joueurs
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * Accesseur de la liste des scores de joueurs
     * @return la liste des scores de joueurs
     */
    public ArrayList<String> getScores() {
        return scores;
    }
    
    /**
     * Accesseur de l'attribut enregistrer 
     * @return l'attribut enregistrer
     */
    public boolean isEnregistrer() {
        return enregistrer;
    }

    /**
     * Setteur de l'attribut enregistrer 
     * @param enregistrer l'état du booléen 
     */
    public void setEnregistrer(boolean enregistrer) {
        this.enregistrer = enregistrer;
    }
    
    /**
     * Remplissage des deux listes de scores et noms
     * @param nomfichier le nom du fichier
     */
    public void getScore(String nomfichier){
        names.clear();
        scores.clear();
        
        try (Scanner scanner = new Scanner(new File(nomfichier))) {
            while (scanner.hasNextLine()) {
                try (Scanner rowScanner = new Scanner(scanner.nextLine())) {
                    rowScanner.useDelimiter(";");
                    names.add(rowScanner.next());
                    scores.add(rowScanner.next());
                }catch (Exception e){
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Mise à jour du fichier à partir des listes de la classe 
     */
    public void majFichier(){
        try (PrintWriter writer = new PrintWriter(new File("autre/MALHEUR_SI_TU_OUVRES/scores.csv"))) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < names.size(); i++){
                sb.append(names.get(i)); sb.append(';');
                sb.append(scores.get(i)); sb.append('\n');
            }

            writer.write(sb.toString());
            writer.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Ajoute le joueur et son score aux deux listes des noms et scores
     * @param nom le nom du joueur à ajouter
     * @param score le score du joueur à ajouter
     */
    public void addListes(String nom, String score){
        ArrayList<String> no = new ArrayList<>();
        ArrayList<String> sc = new ArrayList<>();
        int i = 0;
        while (i < names.size() && Integer.parseInt(scores.get(i)) > Integer.parseInt(score)){
            no.add(names.get(i));
            sc.add(scores.get(i));
            i++;
        }
        no.add(nom); sc.add(score);
        for (int j = i ; j < names.size(); j++){
            no.add(names.get(j));
            sc.add(scores.get(j));
        }
        names.clear(); scores.clear();
        for (int j = 0; j < no.size(); j++){
            names.add(no.get(j));
            scores.add(sc.get(j));
        }
    }
    
    /**
     * Donne les scores du joueur entré en paramètres
     * @param pseudo le pseudo du joueurs
     * @return une liste de scores du joueur entré en paramètres
     */
    public ArrayList<String> scoresParPseudo(String pseudo){
        ArrayList<String> scores_joueur = new ArrayList<>();
        int taille = getNames().size();
        for (int i = 0; i < taille; i++){
            if (getNames().get(i).equals(pseudo)){
                scores_joueur.add(getScores().get(i));
            }
        }
        return scores_joueur;
    } 
}
