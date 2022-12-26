/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Partie.Jeu;
import Scores.ScoreCSV;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Cette classe permet de créer la Popup de fin de partie
 * @author Mattéo Miguelez
 */
public class PopupFin extends JFrame implements ActionListener{
    public JLabel score, pseudo; // "[score]points" et "Enregistrez votre score"
    public JTextField name; // pseudo à rentrer
    public JButton enregistrer; // Bouton pour enregistrer le score
    public JLabel best_score; // Label "Meilleur score"
    public JLabel pseudo1, pseudo2, pseudo3, score1, score2, score3;
    // Labels des pseudos et scores des 3 premiers
    public JButton restart, quitter, score_par_pseudo;
    // boutons quitter, relancer et ouvrir la fenêtre de scores par pseudo
    public Jeu jeu; // Le jeu en cours
    public VueJeu vuejeu; // La première fenêtre
    public ScoreCSV score_csv; // La gestion du fichier de scores
    
    
    /**
     * Constructeur de la classe PopupFin à partir de la classe VueJeu
     * @param vuejeu une fenêtre principale de la classe VueJeu
     */
    public PopupFin(VueJeu vuejeu){
        this.setTitle("Jeu Terminé");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Initialisation des variables */
        this.vuejeu = vuejeu;
        jeu = vuejeu.game;
        score_csv = new ScoreCSV();
        score_csv.getScore("autre/MALHEUR_SI_TU_OUVRES/scores.csv");
        
        score = new JLabel(jeu.score + " points"); 
        pseudo = new JLabel("Enregistrer votre score: ");
        name = new JTextField("");
        enregistrer = new JButton("Enregistrer");
        best_score = new JLabel("Meilleurs scores");
        restart = new JButton("Nouvelle Partie");
        quitter = new JButton("Quitter");
        score_par_pseudo = new JButton("Scores");
        
        /* Action quand la touche Entrée est appuyée */
        name.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ActionFin");
        name.getActionMap().put("ActionFin", new ActionFin());       
        
        /* Mise en place des composants sur la JFrame */
        initfin(); 
        
        
        /* Ecouteurs sur les boutons */
        restart.addActionListener(this);
        quitter.addActionListener(this);
        enregistrer.addActionListener(this);
        score_par_pseudo.addActionListener(this);
    }
    
    /**
     * Fonction d'initialisation de la classe PopupFin, rappelé à chaque mise
     * à jour de la page PopupFin
     */
    public void initfin(){
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());
        
        GridBagConstraints cont = new GridBagConstraints();        
        
        // Couleur de fond de la fenêtre
        panneau.setBackground(new Color(220, 220, 220));
        
        // Police de caractères par défaut
        Font font = new Font ("Serif", Font.BOLD, 20);
        
        /* Initialisation des scores et pseudos */
        pseudo1 = new JLabel(score_csv.getPseudoPremier()); 
        score1 = new JLabel(score_csv.getScorePremier());
        pseudo2 = new JLabel(score_csv.getPseudoDeuxieme());
        score2 = new JLabel(score_csv.getScoreDeuxieme());
        pseudo3 = new JLabel(score_csv.getPseudoTroisieme());
        score3 = new JLabel(score_csv.getScoreTroisieme());
        
        
        /* Mise en place des composants */
        
        // Affichage score
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 0;
        cont.insets = new Insets(20,0,0,0);
        score.setFont(new Font("Serif", Font.BOLD, 30));
        panneau.add(score, cont);  

        // Affichage "Enregistrer votre score :"
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 1;
        cont.insets = new Insets(30,0,0,0);
        cont.anchor = GridBagConstraints.CENTER;
        pseudo.setFont(new Font("Serif", Font.BOLD, 21));
        panneau.add(pseudo, cont);
        
        // TextField name
        cont.gridwidth = 1;
        cont.gridx = 0; cont.gridy = 2;
        cont.anchor = GridBagConstraints.CENTER;
        cont.insets = new Insets(10,60,20,0);
        name.setPreferredSize(new Dimension(160,40));
        name.setFont(font);
        panneau.add(name, cont);
        
        // Bouton Enregistrer score
        cont.gridwidth = 1;
        cont.gridx = 1; cont.gridy = 2;
        cont.insets = new Insets(10,0,20,0);
        cont.anchor = GridBagConstraints.WEST;
        enregistrer.setPreferredSize(new Dimension(150,40));
        enregistrer.setFont(font);
        panneau.add(enregistrer, cont);
        
        // Affichage "Meilleurs scores :"
        cont.gridwidth = 2; 
        cont.gridx = 0; cont.gridy = 3; 
        cont.anchor = GridBagConstraints.CENTER;
        cont.insets = new Insets(0,60,0,60);
        best_score.setFont(new Font("Serif", Font.BOLD, 25));
        panneau.add(best_score, cont);

        // Affichage Pseudo premier
        cont.gridwidth = 1;
        cont.gridx = 0;cont.gridy = 4;
        cont.anchor = GridBagConstraints.WEST;
        cont.insets = new Insets(10,50,0,0);
        pseudo1.setFont(font);
        panneau.add(pseudo1, cont);
        
        // Affichage score premier
        cont.gridwidth = 1;
        cont.gridx = 1; cont.gridy = 4;
        cont.insets = new Insets(10,0,0,50);
        cont.anchor = GridBagConstraints.EAST;
        score1.setFont(font);
        panneau.add(score1, cont);
        
        // Affichage pseudo deuxieme
        cont.gridwidth = 1;
        cont.gridx = 0;cont.gridy = 5;
        cont.insets = new Insets(10,50,0,0);
        cont.anchor = GridBagConstraints.WEST;
        pseudo2.setFont(font);
        panneau.add(pseudo2, cont);
        
        // Affichage score deuxieme
        cont.gridwidth = 1;
        cont.gridx = 1; cont.gridy = 5;
        cont.insets = new Insets(10,0,0,50);
        cont.anchor = GridBagConstraints.EAST;
        score2.setFont(font);
        panneau.add(score2, cont);
        
        // Affichage pseudo 3eme
        cont.gridwidth = 1;
        cont.gridx = 0;cont.gridy = 6;
        cont.insets = new Insets(10,50,10,0);
        cont.anchor = GridBagConstraints.WEST;
        pseudo3.setFont(font);
        panneau.add(pseudo3, cont);
        
        // Affichage score 3eme
        cont.gridx = 1; cont.gridy = 6;
        cont.insets = new Insets(10,0,10,50);
        cont.anchor = GridBagConstraints.EAST;
        score3.setFont(font);
        panneau.add(score3, cont);
                
        // Bouton Nouvelle Partie
        cont.gridwidth = 1;
        cont.gridx = 0; cont.gridy = 7;
        cont.anchor = GridBagConstraints.WEST;
        cont.insets = new Insets(15,30,15,0);
        restart.setFont(font);
        restart.setPreferredSize(new Dimension(175,40));
        panneau.add(restart, cont);
        
        // Bouton Quitter
        cont.gridwidth = 1;
        cont.gridx = 1; cont.gridy = 7;
        cont.anchor = GridBagConstraints.EAST;
        cont.insets = new Insets(15,0,15,30);
        quitter.setFont(font);
        quitter.setPreferredSize(new Dimension(175,40));
        panneau.add(quitter, cont);
        
        // Bouton Scores
        cont.gridwidth = 2;
        cont.gridx = 0; cont.gridy = 8;
        cont.insets = new Insets(0,0,20,0);
        cont.anchor = GridBagConstraints.CENTER;
        score_par_pseudo.setFont(font);
        score_par_pseudo.setPreferredSize(new Dimension(175,40));
        panneau.add(score_par_pseudo, cont);
        
        this.setContentPane(panneau);
        this.pack();
    }
    
    /**
     * Permet de fermer toutes les fenêtres du jeu
     */
    public void quitter(){
        this.dispose();
        vuejeu.dispose();
    }
    
    /**
     * Création d'une nouvelle partie
     */
    public void newGame(){
        this.dispose();
        vuejeu.game = new Jeu();
        vuejeu.init();
        vuejeu.game.initGrille();
        score_csv.setEnregistrer(false);
    }

    /**
     * Implémente les actions lorsque le joueur appuie sur un des boutons
     * @param e la source de l'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitter){
            if (jeu.score >= 150 && !score_csv.isEnregistrer() && jeu.score > Integer.parseInt(score_csv.getScorePremier())){
                ValiderFin val = new ValiderFin(this, false);
                val.setVisible(true);
                val.setLocationRelativeTo(null);
            }else{
                quitter();
            }
        }
        if (e.getSource() == restart){
            if (jeu.score >= 150 && !score_csv.isEnregistrer() && jeu.score > Integer.parseInt(score_csv.getScorePremier())){
                ValiderFin val = new ValiderFin(this, true);
                val.setVisible(true);
                val.setLocationRelativeTo(null);
            }else{
                newGame();
            }
        }
        if (e.getSource() == enregistrer){
            if (jeu.score >= 150 && !name.getText().equals("") && !score_csv.isEnregistrer()){
                score_csv.setEnregistrer(true);

                String tmp = jeu.score + "";
                score_csv.addListes(name.getText(), tmp);
                score_csv.majFichier();
                score_csv.setScoresPseudos();
                initfin();
            }
        }
        if (e.getSource() == score_par_pseudo){
            ScorePseudo sp = new ScorePseudo();
            sp.setVisible(true);
            sp.setLocationRelativeTo(null);
        }
    }
    
    /**
     * Classe permetant d'implémenter une action lorsque le joueur appuit sur la 
     * touche entrée pour valider le pseudonyme dans le TextField prévu à cet
     * effet sur la Fenêtre PopupFin
     */
    private class ActionFin extends AbstractAction { 

        public ActionFin() {}
        
        /**
        * Implémente les actions lorsque le joueur appuie sur la touche entrée
        * @param e la source de l'action
        */
        @Override
        public void actionPerformed(ActionEvent e) { 
            if (jeu.score >= 150 && !name.getText().equals("") && !score_csv.isEnregistrer()){
                score_csv.setEnregistrer(true);

                String tmp = jeu.score + "";
                score_csv.addListes(name.getText(), tmp);
                score_csv.majFichier();
                score_csv.setScoresPseudos();
                initfin();
            }
        } 
    }

}
