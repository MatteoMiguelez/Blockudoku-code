/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Partie.*;
import javax.swing.ImageIcon;

/**
 * Permet d'afficher les images correspondant à chaque forme
 * @author Mattéo Miguelez
 */
public class PickImage{
    public ImageIcon img; // l'image

    /**
     * Constructeur de la classe PickImage à partir d'une forme
     * @param f la forme choisie
     */
    public PickImage(Forme f){
        img = new ImageIcon("images/" + f.getNom()+".png");
    }
    
    /**
     * Renvoie l'image créée par la classe PickImage
     * @return l'ImageIcon img
     */
    public ImageIcon getimg(){
        return img;
    }   
}
