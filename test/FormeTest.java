/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Partie.Forme;
import Formes.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Cette classe permet de tester la classe Forme
 * @author Mattéo Miguelez
 */
public class FormeTest {
    Forme f; // une forme
    Forme f2; // une autre forme
    
    /**
     * Création de deux Formes avant chaque Test
     * f sera une forme et f2 un carré de 2*2
     */
    @Before
    public void setUp() {
        f = new Forme();
        f2 = new Rectangle(2, 2);
    }
    
    /**
     * Test la méthode get_Cases_Remplis 
     */
    @Test
    public void get_Cases_RemplisTest(){
        assertTrue(f.getNb_cases_remplies() == 1);
        assertTrue(f2.getNb_cases_remplies() == 4);
    }
    
    /**
     * Test la méthode getNb_ligne
     */
    @Test
    public void getNb_ligneTest(){
        assertTrue(f.getNb_ligne() == 1);
        assertTrue(f2.getNb_ligne() == 2);
    }
    
    /**
     * Test la méthode getNb_colonne
     */
    @Test
    public void getNb_colonneTest(){
        assertTrue(f.getNb_colonne() == 1);
        assertTrue(f2.getNb_colonne() == 2);
    }
    
    /**
     * Test la méthode getNom
     */
    @Test
    public void getNomTest(){
        assertTrue(f.getNom().compareTo("Case") == 0);
        assertTrue(f2.getNom().compareTo("Carre") == 0);
    }
    
    /**
     * Test la méthode setNom
     */
    @Test
    public void setNomTest(){
        f.setNom("Test"); f2.setNom("Test2");
        assertTrue(f.getNom().compareTo("Test") == 0);
        assertTrue(f2.getNom().compareTo("Test2") == 0);
    }
    
    /**
     * Test les méthodes setNb_cases_remplis
     */
    @Test
    public void setNb_cases_remplisTest(){
        f.setNb_cases_remplis();
        assertTrue(f.getNb_cases_remplies() == 1);
        f2.setNb_cases_remplis();
        assertTrue(f2.getNb_cases_remplies() == 4);
        
        f.setNb_cases_remplies(3);
        assertTrue(f.getNb_cases_remplies() == 3);
        f2.setNb_cases_remplies(8);
        assertTrue(f2.getNb_cases_remplies() == 8);
    }
    
    /**
     * Test la méthode setNb_ligne
     */
    @Test
    public void setNb_ligneTest(){
        f.setNb_ligne(2);
        assertTrue(f.getNb_ligne() == 2);
    }
    
    /**
     * Test la méthode setNb_colonne
     */
    @Test
    public void setNb_colonneTest(){
        f.setNb_colonne(8);
        assertTrue(f.getNb_colonne() == 8);
    }
    
    /**
     * Test la méthode getValeur
     */
    @Test
    public void getValeurTest(){
        assertTrue(f2.getValeur(0, 0));
    }
    
    /**
     * Test la méthode setCase
     */
    @Test
    public void setCaseTest(){
        f2.setCase(1, 1, false);
        assertFalse(f2.getValeur(1, 1));
    }

    /**
     * Test la méthode getCo_x
     */
    @Test
    public void getCo_xTest(){
        assertTrue(f.getCo_x() == 0);
        assertTrue(f2.getCo_x() == 0);
    }
    
    /**
     * Test de la méthode getCo_y
     */
    @Test
    public void getCo_yTest(){
        assertTrue(f.getCo_y() == 0);
        assertTrue(f.getCo_y() == 0);
    }
    
    /**
     * Test de la méthode setCo_x
     */
    @Test
    public void setCo_xTest(){
        f.setCo_x(5);
        assertTrue(f.getCo_x() == 5);
    }
    
    /**
     * Test de la méthode setCo_y
     */
    @Test
    public void setCo_yTest(){
        f2.setCo_y(5);
        assertTrue(f2.getCo_y() == 5);
    }
}