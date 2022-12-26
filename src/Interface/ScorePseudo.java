/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Scores.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Fenêtre permettant de donner les meilleurs scores 
 * avec le pseudo du joueur souhaité
 * @author Mattéo Miguelez
 */
public class ScorePseudo extends JFrame implements ActionListener{
    public JLabel consigne; // "Recherche par pseudonyme"
    public JTextField pseudo; // pseudo à remplir
    public JButton valider; // bouton pour valider le pseudo
    public JLabel premier, deuxieme, troisieme, quatrieme, cinquieme;
    // 5 premiers scores du joueur à afficher
    public JLabel scores_txt, introuvable;
    // Textes "Scores :" et "pseudo inconnu" 
    public ScoreCSV score; // Load du fichier CSV contenant les scores
    public JButton quitter; // bouton pour couper la fenêtre
    
    public ScorePseudo(){
        this.setTitle("Scores");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
        /* Initialisation des variables */
        score = new ScoreCSV();
        
        consigne = new JLabel("Recherche par pseudonyme");
        premier = new JLabel("1/");
        deuxieme = new JLabel("2/");
        troisieme = new JLabel("3/");
        quatrieme = new JLabel("4/");
        cinquieme = new JLabel("5/");
        pseudo = new JTextField();
        valider = new JButton("Valider");
        scores_txt = new JLabel("Scores :");
        introuvable = new JLabel();
        quitter = new JButton("Quitter");
        
        /* Action quand la touche Entrée est appuyée */
        pseudo.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ActionScore");
        pseudo.getActionMap().put("ActionScore", new ActionScore());
        
        /* Mise en place des composants sur la JFrame */
        init();
        
        /* Ecouteurs sur les boutons */
        valider.addActionListener(this);
        quitter.addActionListener(this);
    }
    
    public void init(){
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());
        
        GridBagConstraints cont = new GridBagConstraints();   
        
        /* Font de base */
        Font font1 = new Font("Serif", Font.ROMAN_BASELINE, 22);
        Font font2 = new Font("Serif", Font.ROMAN_BASELINE, 24);
        
        
        /* Mise en place des composants */
                
        // Affichage du texte "Recherche par pseudonyme"
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 0;
        cont.insets = new Insets(25,0,10,0);
        consigne.setFont(font1);
        panneau.add(consigne, cont);
        
        // Affichage du TextField de nom
        cont.gridwidth = 1;
        cont.gridx = 0; cont.gridy = 2;
        cont.insets = new Insets(0,40,15,0);
        cont.anchor = GridBagConstraints.EAST;
        pseudo.setPreferredSize(new Dimension(175,35));
        pseudo.setFont(font2);
        panneau.add(pseudo, cont);
        
        // Affichage du bouton valider
        cont.gridwidth = 1;
        cont.gridx = 1; cont.gridy = 2;
        cont.insets = new Insets(0,0,15,40);
        cont.anchor = GridBagConstraints.WEST;
        valider.setPreferredSize(new Dimension(110,34));
        valider.setFont(font2);
        panneau.add(valider, cont);
        
        // Affichage de "Scores"
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 3;
        cont.insets = new Insets(0,0,5,0);
        cont.anchor = GridBagConstraints.CENTER;
        scores_txt.setFont(new Font("Serif", Font.BOLD, 22));
        panneau.add(scores_txt, cont);
        
        // Affichage de "pseudo introuvable" si la recherche de pseudo n'aboutit pas
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 4;
        cont.insets = new Insets(0,0,0,0);
        introuvable.setForeground(Color.red);
        introuvable.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        panneau.add(introuvable, cont);
        
        // Paramètres pour les 5 scores
        cont.insets = new Insets(0,60,0,0);
        cont.anchor = GridBagConstraints.WEST;
        cont.gridwidth = 1;
        
        // Affichage premier score
        cont.gridx = 0; cont.gridy = 5;
        premier.setFont(font2);
        panneau.add(premier, cont);
        
        // Affichage deuxième score
        cont.gridx = 0; cont.gridy = 6;
        deuxieme.setFont(font2);
        panneau.add(deuxieme, cont);
        
        // Affichage troisième score
        cont.gridx = 0; cont.gridy = 7;
        troisieme.setFont(font2);
        panneau.add(troisieme, cont);
        
        // Affichage quatrième score
        cont.gridx = 0; cont.gridy = 8;
        quatrieme.setFont(font2);
        panneau.add(quatrieme, cont);
        
        // Affichage cinquième score
        cont.gridx = 0; cont.gridy = 9;
        cont.insets = new Insets(5,60,25,0);
        cinquieme.setFont(font2);
        panneau.add(cinquieme, cont);
        
        // Affichage du bouton quitter
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 10;
        cont.insets = new Insets(0,0,20,0);
        cont.anchor = GridBagConstraints.CENTER;
        quitter.setFont(font2);
        panneau.add(quitter, cont);

        this.setContentPane(panneau);
        this.pack();
    }

    /**
     * Action à faire lorsque le joueur valide le pseudo avec la touche entrée
     * ou le bouton Valider
     */
    public void validerPseudo(){
        // Liste avec les pseudos du joueur dont le pseudo a été renseigné
        ArrayList<String> st = new ArrayList<>();
        st = score.scoresParPseudo(pseudo.getText());

        // Si la liste est vide, on réinitialise tout 
        if (st.isEmpty()){
            introuvable = new JLabel("Pseudo introuvable");
            premier = new JLabel("1/"); deuxieme = new JLabel("2/");
            troisieme = new JLabel("3/"); quatrieme = new JLabel("4/");
            cinquieme = new JLabel("5/");
        }else{
            if (st.size() >= 1){
                premier = new JLabel("1/ " + st.get(0));
                introuvable = new JLabel();
            }
            if (st.size() >= 2){
                deuxieme = new JLabel("2/ " + st.get(1));
            }
            if (st.size() >= 3){
                troisieme = new JLabel("3/ " + st.get(2));
            }
            if (st.size() >= 4){
                quatrieme = new JLabel("4/ " + st.get(3));
            }
            if (st.size() >= 5){
                cinquieme = new JLabel("5/ " + st.get(4));
            }
        }
        init();
        st.clear();
    }
    
    /**
    * Implémente les actions lorsqu'un bouton est utilisé
    * @param e la source de l'action
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valider  && !pseudo.getText().equals("")){
            validerPseudo();
        }
        if (e.getSource() == quitter){
            this.dispose();
        }
    }
    
    /**
     * Classe permetant d'implémenter une action lorsque le joueur appuit sur la 
     * touche entrée pour valider le pseudonyme dans le TextField prévu à cet
     * effet sur la Fenêtre PopupFin
     */
    private class ActionScore extends AbstractAction { 

        public ActionScore() {}
        
        /**
        * Implémente les actions lorsque le joueur appuie sur la touche entrée
        * @param e la source de l'action
        */
        @Override
        public void actionPerformed(ActionEvent e) { 
            if (!pseudo.getText().equals("")) validerPseudo();
        } 
    }
}
