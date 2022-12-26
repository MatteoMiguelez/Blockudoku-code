/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Fenêtre qui s'ouvre lorsque le score du joueur est plus élevé que le meilleur 
 * score enregistré et que le joueur n'a pas enregistré son nouveau meilleur score
 * @author Mattéo Miguelez
 */
public class ValiderFin extends JFrame implements ActionListener{
    public JLabel text, text2; // Textes de la fenêtre
    public JButton oui, non; // Boutons de validation
    public PopupFin popupfin; // La fenêtre de popupFin qui a entrainé l'ouverture de la fenêtre validerFin 
    public boolean restart; // true si "nouvelle partie", false si "quitter"
    
    /**
     * Constructeur de la classe ValiderFin à partir de la classe PopupFin
     * @param pop la fenêtre PopupFin qui à entrainer l'ouverture de la fenêtre validerFin
     * @param re un booléen qui vaut true si c'est le bouton "nouvelle partie" qui a été
     * activé, false si c'est le bouton "quitter"
     */
    public ValiderFin(PopupFin pop, boolean re){
        this.setTitle("Quitter ?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Initialisation des variables */
        popupfin = pop; restart = re;
  
        text = new JLabel("Vous avez battu le record !");
        text2 = new JLabel("Quitter sans enregistrer ?");
        oui = new JButton("Oui"); non = new JButton("Non");
        
        /* Mise en place des composants sur la JFrame */
        init();
        
        /* Ecouteurs sur les boutons */
        oui.addActionListener(this);
        non.addActionListener(this);
    }
    
    /**
     * Fonction d'initialisation de la classe ValiderFin
     */
    public void init(){
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());
        
        GridBagConstraints cont = new GridBagConstraints();   
        
        
        /* Mise en place des composants */
        
        // Affichage de la première phrase
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 0;
        cont.insets = new Insets(20,30,0,30);
        text.setFont(new Font("Serif", Font.ROMAN_BASELINE, 23));
        panneau.add(text, cont);
        
        // Affichage de la seconde phrase
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 1;
        cont.insets = new Insets(5,20,0,20);
        text2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 23));
        panneau.add(text2, cont);
        
        // Affichage du bouton "Oui"
        cont.gridwidth = 1;
        cont.gridx = 0; cont.gridy = 2;
        cont.insets = new Insets(20,55,20,0);
        oui.setPreferredSize(new Dimension(80,40));
        oui.setFont(new Font("Serif", Font.BOLD, 22));
        panneau.add(oui, cont);
        
        // Affichage du bouton "Non"
        cont.gridwidth = 1;
        cont.gridx = 1; cont.gridy = 2;
        cont.insets = new Insets(20,0,20,55);
        cont.anchor = GridBagConstraints.EAST;
        non.setPreferredSize(new Dimension(80,40));
        non.setFont(new Font("Serif", Font.BOLD, 22));
        panneau.add(non, cont);
        
        this.setContentPane(panneau);
        this.pack();
    }

    /**
     * Implémente les actions lorsque le joueur appuie sur un des boutons
     * @param e la source de l'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == oui){
            if (restart){
                popupfin.newGame();
            }else{
                popupfin.quitter();
            }
            this.dispose();
        }
        if (e.getSource() == non){
            this.dispose();
        }
    }
    
}
