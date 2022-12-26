/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Partie.*;
import Scores.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * Cette classe permet de créer un affichage du Jeu (page principale)
 * @author Mattéo Miguelez
 */
public class VueJeu extends JFrame implements ActionListener, KeyListener, MouseListener{
    public JMenuBar menubar; // La bar de menu
    public JMenu regles, scores; // Les menus pour afficher les règles et les scores 
    public JLabel score; // L'affichage du score
    public JButton vuegrille[][]; // La grille de boutons
    public JLabel meilleur_score_txt, meilleur_score; // textes de records
    public JButton formes[]; // L'affichage des 3 formes
    public JLabel credits; // Credits du jeu
    public Jeu game; // Le jeu en cours 
    private int formeactuelle; // L'indice de la formeactuelle
    
        
    /**
     * Constructeur de la classe VueJeu à partir d'un Jeu
     * @param jeu le jeu
     */
    public VueJeu(Jeu jeu){     
        this.setTitle("Blockudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        /* Initialisation des variables */
        game = jeu;  
        
        menubar = new JMenuBar();
        regles = new JMenu("                                        Règles                                      ");
        credits = new JLabel("© Mattéo Miguelez");
        this.setJMenuBar(menubar);
        menubar.add(regles);
        regles.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        
        /* Mise en place des composants sur la JFrame */
        init();
        
        /* Ecouteurs sur les boutons */
        regles.addMouseListener(this);
    }
    
    /**
     * Initialisation de l'affichage de la fenêtre principale VueJeu
     */
    public void init(){
        this.setEnabled(true);
        
        /* Initialisation des variables */
        formeactuelle = 0;
        score = new JLabel("0");
        meilleur_score_txt = new JLabel("Record");
        ScoreCSV sc = new ScoreCSV();
        meilleur_score = new JLabel(sc.getScorePremier());
        
        // Initialisation des boutons
        vuegrille = new JButton[game.getTaille()][game.getTaille()];
        for(int i = 0; i < game.getTaille(); i++){
            for (int j = 0; j < game.getTaille(); j++) {
                if ((i > 2 && i < 6 && (j < 3 || j >5)) || ((i < 3 || i > 5) && j > 2 && j < 6))
                    vuegrille[i][j] = new JButton(new ImageIcon("images_fond/case_grise.png"));
                else
                    vuegrille[i][j] = new JButton(new ImageIcon("images_fond/case_vide.png"));
                vuegrille[i][j].setPreferredSize(new Dimension(47,47));
                vuegrille[i][j].addActionListener(this);
                vuegrille[i][j].addKeyListener(this);
            }
        }
        
        // Initialisation des formes
        formes = new JButton[3];
        for (int i = 0; i < 3; i++) {
            formes[i] = new JButton(new PickImage(game.liste3formes.get(i)).getimg());
            formes[i].setPreferredSize(new Dimension(144,144));
            formes[i].addActionListener(this);
            formes[i].addKeyListener(this);
        }
        
        // Création du panneau
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints(); 
        
        /* Mise en place des composants */
        
        // Placement du score
        cont.gridwidth = 11;
        cont.gridx = 0; cont.gridy = 0;
        cont.insets = new Insets(10,0,10,0);
        score.setFont(new Font("Serif", Font.BOLD, 25));
        panneau.add(score,cont);
        
        // Placement du texte de meilleur score
        cont.gridwidth = 3;
        cont.gridx = 8; cont.gridy = 1;
        cont.insets = new Insets(0,0,0,10);
        meilleur_score_txt.setFont(new Font("Serif", Font.BOLD, 18));
        panneau.add(meilleur_score_txt, cont);
        
        // Placement du meilleur score
        cont.gridwidth = 3;
        cont.gridx = 8; cont.gridy = 2;
        cont.insets = new Insets(0,0,10,10);
        meilleur_score.setFont(new Font("Serif", Font.BOLD, 20));
        panneau.add(meilleur_score, cont);
        
        // Affichage de la grille de boutons
        cont.gridwidth = 1;
        for(int i = 0; i < game.getTaille(); i++){
            for (int j = 0; j < game.getTaille(); j++){
                cont.gridx = 1 + i; cont.gridy = 3+ j;
                if (i == 0 && (j%3 == 2)) cont.insets = new Insets(0,32,0,1);
                else if (i == 0) cont.insets = new Insets(0,32,0,0);
                else if (i == game.getTaille() - 1 && (j%3 == 2)) cont.insets = new Insets(0,0,0,32);
                else if (i == game.getTaille() - 1) cont.insets = new Insets(0,0,0,32);
                else if (j%3 == 2) cont.insets = new Insets(0,0,0,1);
                else cont.insets = new Insets(0,0,0,0);
                panneau.add(vuegrille[i][j], cont);
            }
        }
        
        // Affichage des 3 formes
        cont.gridwidth = 3;
        cont.gridy = 12;
        for (int i = 0; i <3; i++){
            cont.gridx = 1 + (i*3);
            switch (i) {
                case 0:
                    cont.insets = new Insets(32,32,10,0);
                    break;
                case 2:
                    cont.insets = new Insets(32,0,10,32);
                    break;
                default:
                    cont.insets = new Insets(32,0,10,0);
                    break;
            }
            panneau.add(formes[i], cont);
        }
        
        // Credits 
        cont.gridwidth = 3;
        cont.gridy = 13; cont.gridx = 7;
        cont.insets = new Insets(0,0,10,10);
        credits.setFont(new Font("Serif", Font.ROMAN_BASELINE, 16));
        panneau.add(credits, cont);
        
        this.setContentPane(panneau);
        this.pack();
    }

    /**
     * Met à jour la grille d'images pour l'affichage
     */
    public void maj_grille(){
        for (int i = 0; i < game.getTaille(); i++) {
            for(int j = 0; j < game.getTaille(); j++){
                if (game.getEtatCase(i, j)){
                    vuegrille[j][i].setIcon(new ImageIcon("images_fond/case_remplie.png"));
                }else{ 
                   if ((i > 2 && i < 6 && (j < 3 || j >5)) || ((i < 3 || i > 5)  && j > 2 && j < 6)){
                       vuegrille[j][i].setIcon(new ImageIcon("images_fond/case_grise.png"));
                   }else{
                        vuegrille[j][i].setIcon(new ImageIcon("images_fond/case_vide.png"));
                   }
                }
            }
        }
    }
    
    /**
     * Supprime les anciennes formes du jeu et en ajoute de nouvelles
     */
    public void restartFigures(){
        game.ajoutFormes();
        formeactuelle = 0;
        for (int i = 0; i < 3; i++){
            formes[i].setIcon(new PickImage(game.liste3formes.get(i)).getimg());
            game.etat3formes[i] = true;
        }
    }
    
    /**
     * Implémente les actions lorsque le joueur appuie sur un des boutons
     * @param e la source de l'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Forme f;
        
        // Si un bouton de forme est activé et que la forme n'est pas déjà utilisée, cette forme est sélectionnée
        for(int i = 0; i < 3; i++){
            if (source == formes[i] && game.etat3formes[i]){
                    formeactuelle = i;
            }
        }
            
        // Si un bouton de la grille est activé, on test s'il est possible de placer cette forme à l'endroit désiré
        // Si c'est possible, on la place et on met à jour la grille et la forme
        for (int i = 0; i < game.getTaille(); i++){
            for (int j =0; j < game.getTaille(); j++){
                // Test s'il est possible de placer la forme à cet emplacement
                f = game.liste3formes.get(formeactuelle);
                if (source == vuegrille[i][j] && game.VerifplaceForme(f, j - f.getCo_x(), i -f.getCo_y())){    
                    game.ajoutGrille(f, j - f.getCo_x(), i-f.getCo_y());
                    game.score += f.getNb_cases_remplies(); 
                    game.etat3formes[formeactuelle] = false;
                    formes[formeactuelle].setIcon(new ImageIcon("images_fond/forme_vide.png"));
                    
                    // Choisi automatiquement la forme actuelle utilisée (ordre croissant)
                    if (!game.etat3formes[0]){
                        if (game.etat3formes[1]) {
                            formeactuelle = 1;
                        } else {
                            formeactuelle = 2;
                        }
                    } else {
                        formeactuelle = 0;
                    }
                    
                    // Clear la grille et ajoute les points
                    game.Verif_clear_all();
                    
                    maj_grille();
                }
            }
        }
        score.setText("" + game.score);
        
        // Si les 3 formes ont été placées, on appelle la méthode restartFigures
        if (!game.etat3formes[0] && !game.etat3formes[1] && !game.etat3formes[2]){
            restartFigures();
        }
        
        if (game.finPartie()) {
            PopupFin p = new PopupFin(this);
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            this.setEnabled(false);
        }
    }

    /**
     * Implémente les actions quand le joueur utilise certaines touches du clavier
     * @param e la source de l'action
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '&':
                if (game.etat3formes[0] == true) formeactuelle = 0;
                break;
            case '1':
                if (game.etat3formes[0] == true) formeactuelle = 0;
                break;
            case 'é':
                if (game.etat3formes[1] == true) formeactuelle = 1;
                break;
            case '2':
                if (game.etat3formes[1] == true) formeactuelle = 1;
                break;
            case '"':
                if (game.etat3formes[2] == true) formeactuelle = 2;
                break;
            case '3':
                if (game.etat3formes[2] == true) formeactuelle = 2;
                break;
            case 'm':
                ScorePseudo sp = new ScorePseudo();
                sp.setVisible(true);
                sp.setLocationRelativeTo(null);
                break;
            default:
                break;
        }
    }
    
    /**
     * Implémente les actions quand la souris est utilisée
     * @param e la source de l'action
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == regles){
            this.setEnabled(false);
            VueRegles regle = new VueRegles(this);
            regle.setVisible(true);
            regle.setLocationRelativeTo(null);
        }
    }
    
    /**
     * Méthode non utilisée
     * @param e /
     */
    @Override
    public void keyTyped(KeyEvent e) {}
    
    /**
     * Méthode non utilisée
     * @param e /
     */
    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Méthode non utilisée
     * @param e /
     */
    @Override
    public void mouseClicked(MouseEvent e) {}

    /**
     * Méthode non utilisée
     * @param e /
     */
    @Override
    public void mouseReleased(MouseEvent e) {}

    /**
     * Méthode non utilisée
     * @param e /
     */
    @Override
    public void mouseEntered(MouseEvent e) {}

    /**
     * Méthode non utilisée
     * @param e /
     */
    @Override
    public void mouseExited(MouseEvent e) {}
}
