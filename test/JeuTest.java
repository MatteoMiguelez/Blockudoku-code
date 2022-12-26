/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Formes.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import Partie.*;

/**
 * Cette classe permet de tester la classe Jeu
 * @author Mattéo Miguelez
 */
public class JeuTest {
    Jeu j; // un jeu
    
    /**
     * Création d'un Jeu avant chaque Test
     */
    @Before
    public void setUp() {
        j = new Jeu();
    }
    
    /**
     * Test de la méthode getNom avec la 1ère et la 9ème valeur de la liste_toutes_formes
     */
    @Test
    public void getNomTest(){
        j.initListe_toutes_formes();
        assertTrue(j.liste_toutes_formes.get(0).getNom().compareTo("Colonne2") == 0 );
        assertTrue(j.liste_toutes_formes.get(9).getNom().compareTo("Case") == 0 );
    }
    
    /**
     * Test la méthode getTaille, qui renvera toujours 9
     */
    @Test
    public void getTailleTest(){
        assertTrue(j.getTaille() == 9);
    }
    
    /**
     * Test de la méthode setEtatCase
     */
    @Test
    public void setEtatCaseTest(){
        j.setEtatCase(0, 0, true);
        assertTrue(j.grille[0][0]);
        j.setEtatCase(0, 0, false);
        assertFalse(j.grille[0][0]);
    }
    
    /**
     * Test de la méthode getEtatCase
     */
    @Test
    public void getEtatCaseTest(){
        j.setEtatCase(8, 4, true);
        assertTrue(j.getEtatCase(8, 4));
        assertFalse(j.getEtatCase(0, 0));
    }
    
    /**
     * Test de la méthode randomForme
     */
    @Test
    public void randomFormeTest(){
        j.initListe_toutes_formes();
        try{
            Forme a = j.randomForme();
        } catch (Exception e){
            fail();
        }
    }
    
    /**
     * Test de la méthode ajoutForme, on test seulement la longueur car
     * la méthode fonctionne aléatoirement
     */
    @Test
    public void ajoutFormeTest(){
        j.initListe_toutes_formes();
        j.ajoutFormes();
        assertTrue(j.liste3formes.size() == 3);
    }
 
    /**
     * Test de la méthode supprimerForme (avec la taille de la liste)
     */
    @Test
    public void supprimerFormeTest(){
        j.initListe_toutes_formes();
        j.ajoutFormes();
        j.supprimerFormes();
        assertTrue(j.liste3formes.isEmpty());
    }
    
    /**
     * Test de la méthode VerifLigne
     */
    @Test
    public void VerifLigneTest(){
        for (int i = 0; i < j.getTaille(); i++) j.setEtatCase(2, i, true);
        assertTrue(j.VerifLigne(2));
        assertFalse(j.VerifLigne(0));
        
        j.setEtatCase(2, 5, false);
        assertFalse(j.VerifLigne(2));
    }
    
    /**
     * Test de la méthode VerifColonne
     */
    @Test
    public void VerifColonneTest(){
        // On rempli la colonne 5 pour le test
        for (int i = 0; i < j.getTaille(); i++) j.setEtatCase(i, 5, true);
        
        assertTrue(j.VerifColonne(5)); 
        assertFalse(j.VerifColonne(2));
        
        // On vide une des cases de la colonne pour le test
        j.setEtatCase(8, 5, false);
        assertFalse(j.VerifColonne(5));
    }
    
    /**
     * Test de la méthode VerifCarre
     */
    @Test
    public void VerifCarreTest(){
        // On rempli l'ensemble de Case qui commence en 3, 6 pour le test
        for (int i = 3; i < 3+ j.getTaille()/3; i++){
            for (int k = 6; k < 6 + j.getTaille()/3; k++)
                j.setEtatCase(i, k, true);
        }
        assertTrue(j.VerifCarre(3, 6));
        // On vide une des cases de l'ensemble pour le test
        j.setEtatCase(4, 8, false);
        assertFalse(j.VerifCarre(3, 6));
    }
    
    /**
     * Test de la méthode VideLigne
     */
    @Test
    public void VideLigneTest(){
        // On rempli la ligne 6 pour le test
        for (int i = 0; i < j.getTaille(); i++) j.setEtatCase(6, i, true);
        
        j.VideLigne(6);
        assertFalse(j.VerifLigne(6));
        // On vérifie que chaque case de la ligne est bien vidée
        for (int i = 0; i < j.getTaille(); i++) assertFalse(j.getEtatCase(6, i));
    }
    
    /**
     * Test de la méthode VideColonne
     */
    @Test
    public void VideColonneTest(){
        // On rempli la colonne 6 pour le test
        for (int i = 0; i < j.getTaille(); i++) j.setEtatCase(i, 3, true);
        
        j.VideColonne(3);
        assertFalse(j.VerifColonne(3));
        // On vérifie que CHAQUE valeur de la colonne vaut false
        for(int i = 0; i < j.getTaille(); i++) assertFalse(j.getEtatCase(i, 3));
    }
    
    /**
     * Test de la méthode VideCarre
     */
    @Test
    public void VideCarreTest(){
        // On rempli l'ensemble de Cases en 6,3 pour le test
        for (int i = 6; i < 6+ j.getTaille()/3; i++)
            for (int k = 3; k < 3+ j.getTaille()/3; k++)
                j.setEtatCase(i, k, true);
        
        j.VideCarre(6, 3);
        assertFalse(j.VerifCarre(6, 3));
        //On vérifie que CHAQUE valeur de l'ensemble 3*3 vaut false
        for (int i = 6; i < 6+ j.getTaille()/3; i++)
            for (int k = 3; k < 3+ j.getTaille()/3; k++)
                assertFalse(j.getEtatCase(i, k));
    }
    
    /**
     * Test de la méthode placeForme
     */
    @Test
    public void placeFormeTest(){        
        assertTrue(j.VerifplaceForme(new Rectangle(3,1), 1, 1));
        assertTrue(j.VerifplaceForme(new Triangle(1), 2, 1));
        assertTrue(j.VerifplaceForme(new Crochet(2), 0, 3));
        j.setEtatCase(7, 7, true);
        
        assertFalse(j.VerifplaceForme(new Pyramide(1), 6, 7));
        assertTrue(j.VerifplaceForme(new Triangle(3), 6, 6));
    }
    
    /**
     * Test de la méthode finPartie
     */
    @Test
    public void finPartieTest(){
        j.initListe_toutes_formes();
        j.ajoutFormes();
        assertFalse(j.finPartie());
        for(int i = 0; i < j.getTaille(); i++)
            for (int k = 0; k < j.getTaille(); k++)
                j.setEtatCase(i, k, true);
        assertTrue(j.finPartie());
        j.setEtatCase(5, 6, false);
        j.liste3formes.set(0, new Rectangle(1,1));
        assertFalse(j.finPartie());
    }
   
}
