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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Fenêtre expliquant les règles du jeu
 * @author Mattéo Miguelez
 */
public class VueRegles extends JFrame implements ActionListener{
    public JLabel regles, numero; // "Règles :" et "[page]/2"
    // TEXTES expliquant les règles
    public JLabel text1_ligne1, text1_ligne2;
    public JLabel text2_ligne1, text2_ligne2;
    public JLabel image;
    public JLabel text3_ligne1, text3_ligne2;
    public JLabel text4_ligne1, text4_ligne2, text4_ligne3;
    public JLabel text5_ligne1;
    public JLabel text6_ligne1, text6_ligne2, text6_ligne3;
    public JLabel text7_ligne1, text7_ligne2;
    public JLabel text8_ligne1, text8_ligne2, text8_ligne3, text8_ligne4, text8_ligne5;
    public JLabel text9_ligne1, text9_ligne2;
    public JLabel text10_ligne1, text10_ligne2, text10_ligne3;
    public JLabel text11_ligne1, text11_ligne2;
    public JButton quitter, fleche; // Bouton pour quitter et aller à la page suivante
    public boolean premiere_page; // true si c'est la première page, false sinon
    public VueJeu vuejeu; 
    // La fenêtre à l'origine de la création de la fenêtre de règles
    
    /**
     * Constructeur de la classe VueRègles
     * @param vue la fenêtre appelant l'ouverture de la fenêtre de règles
     */
    public VueRegles(VueJeu vue){
        this.setTitle("Règles du Jeu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 800));
        
        /* Initialisation des variables */
        
        premiere_page = true; // C'est la première page qui est ouverte en premier
        vuejeu = vue;
                
        regles = new JLabel("Règles :");
        quitter = new JButton("Quitter");
        
        /* Mise en place des composants sur la JFrame */
        init(); 
        
        /* Ecouteurs sur les boutons */
        fleche.addActionListener(this);
        quitter.addActionListener(this);
    }
    
    /**
     * Initialisation des variables pour la page 1
     */
    public void page1(){
        numero = new JLabel("1/2");
        fleche = new JButton(new ImageIcon("autre/arrow.png"));
        
        text1_ligne1 = new JLabel("Le jeu est composé d’une grille de boutons de 9 par 9 et de trois formes  ");
        text1_ligne2 = new JLabel("sélectionnables. Le joueur doit placer les formes sur la grille.");
        
        text2_ligne1 = new JLabel("Pour sélectionner une forme, il suffit de cliquer dessus. Il est aussi possible");
        text2_ligne2 = new JLabel(" d’utiliser certaines touches du clavier comme indiquer sur l’image ci-dessous.");
        
        image = new JLabel(new ImageIcon("autre/azerty.png"));
        
        text3_ligne1 = new JLabel("Si le joueur n’a pas sélectionné de forme, ce sera la forme qui se trouve le ");
        text3_ligne2 = new JLabel("plus à gauche qui sera utilisée par défaut.");
        
        text4_ligne1 = new JLabel("Quand le joueur essaye de poser une forme sur la grille, le jeu vérifie que la ");
        text4_ligne2 = new JLabel("forme peut bien être placée à cet endroit et si c’est le cas, les cases sont");
        text4_ligne3 = new JLabel("alors remplies et elles deviennent bleues.");
        
        text5_ligne1 = new JLabel(); text6_ligne1 = new JLabel(); text6_ligne2 = new JLabel();
        text6_ligne3 = new JLabel(); text7_ligne1 = new JLabel(); text7_ligne2 = new JLabel(); 
        text8_ligne1 = new JLabel(); text8_ligne2 = new JLabel(); text8_ligne3 = new JLabel(); 
        text8_ligne4 = new JLabel(); text8_ligne5 = new JLabel(); text9_ligne1 = new JLabel(); 
        text9_ligne2 = new JLabel(); text10_ligne1 = new JLabel(); text10_ligne2 = new JLabel(); 
        text10_ligne3 = new JLabel(); text11_ligne1 = new JLabel(); text11_ligne2 = new JLabel();
    }
    
    /**
     * Initialisation des variables pour la page 2
     */
    public void page2(){
        numero = new JLabel("2/2");
        fleche = new JButton(new ImageIcon("autre/arrow2.png"));
        
        text1_ligne1 = new JLabel(); text1_ligne2 = new JLabel(); text2_ligne1 = new JLabel();
        text2_ligne2 = new JLabel(); image = new JLabel(); text3_ligne1 = new JLabel();
        text3_ligne2 = new JLabel(); text4_ligne1 = new JLabel(); text4_ligne2 = new JLabel(); 
        text4_ligne3 = new JLabel(); 
        
        text5_ligne1 = new JLabel("Attention : La forme est placée à partir de sa case la plus en haut à gauche.");
        
        text6_ligne1 = new JLabel("Lorsqu’une ligne, une colonne ou un carré de 3 par 3 (en blanc ou en gris) ");
        text6_ligne2 = new JLabel("est rempli, la partie de la grille concernée redevient disponible et");
        text6_ligne3 = new JLabel("reprend donc sa couleur d’origine.");
        
        text7_ligne1 = new JLabel("Le but est d’obtenir le meilleur score possible. A chaque figure posée et à");
        text7_ligne2 = new JLabel("chaque ligne, colonne, ou carré de 3 par 3 remplis, le joueur recevra des points.");
        
        text8_ligne1 = new JLabel("Lorsque le joueur ne peut plus placer les formes restantes, le jeu se termine ");
        text8_ligne2 = new JLabel("et une nouvelle fenêtre permettant au joueur d’enregistrer son score apparaît.");
        text8_ligne3 = new JLabel("Le score doit être d’au moins 150 pour qu’il puisse être enregistré. Le joueur");
        text8_ligne4 = new JLabel("doit simplement entrer son pseudonyme dans l’encart prévu à cet effet et");
        text8_ligne5 = new JLabel("appuyer sur le bouton « Enregistrer » ou sur la touche Entrée.");
        
        text9_ligne1 = new JLabel("La fenêtre de fin affiche les 3 meilleurs scores et pseudonymes des joueurs");
        text9_ligne2 = new JLabel("possédant ces scores.");
        
        text10_ligne1 = new JLabel("Après avoir enregistré ou non son score, le joueur a deux possibilités :  ");
        text10_ligne2 = new JLabel("relancer une partie avec le bouton « Nouvelle Partie » ou quitter le jeu");
        text10_ligne3 = new JLabel("avec le bouton « Quitter ».");
        
        text11_ligne1 = new JLabel("Le joueur peut aussi accéder à une fenêtre en appuyant sur le bouton « Scores ».");
        text11_ligne2 = new JLabel("Cette fenêtre lui permettra de chercher les 5 meilleurs scores d'un joueur.");
    }
    
    /**
     * Initialisation de la fenêtre des règles
     */
    public void init(){
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());
        
        GridBagConstraints cont = new GridBagConstraints();
        
        if (premiere_page) page1(); 
        else page2();
        
        /* Ecouteurs sur la fleche qui se met à jour (changement de place) */
        fleche.addActionListener(this);
        
        /* Font de base */
        Font font = new Font ("Serif", Font.BOLD, 21);
        
        
        /* Mise en place des composants */
        
        // Taille de base
        cont.gridwidth = 1;
        
        // Texte "Règles :"
        cont.insets = new Insets(10,20,0,0);
        cont.gridx = 0; cont.gridy = 0;
        regles.setFont(font);
        panneau.add(regles, cont);
        
        //Texte "Numéro/2" 
        cont.gridx = 1; cont.gridy = 0;
        cont.anchor = GridBagConstraints.EAST;
        numero.setFont(font);
        panneau.add(numero,cont);
        
        // taille pour la suite
        cont.gridwidth = 2;
        cont.anchor = GridBagConstraints.CENTER;
        
        // Texte 1
        if (premiere_page) cont.insets = new Insets(20,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 1;
        text1_ligne1.setFont(font);
        panneau.add(text1_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 2;
        text1_ligne2.setFont(font);
        panneau.add(text1_ligne2, cont);
        
        // Texte 2
        if (premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0;cont.gridy = 3; 
        text2_ligne1.setFont(font);
        panneau.add(text2_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0;cont.gridy = 4;
        text2_ligne2.setFont(font);
        panneau.add(text2_ligne2, cont);
        
        // Image du clavier
        if (premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 5;
        panneau.add(image, cont);
        
        // Texte 3 
        if (premiere_page) cont.insets = new Insets(25,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 6;
        text3_ligne1.setFont(font);
        panneau.add(text3_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 7;
        text3_ligne2.setFont(font);
        panneau.add(text3_ligne2, cont);
        
        // Texte 4
        if (premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 8;
        text4_ligne1.setFont(font);
        panneau.add(text4_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 9;
        text4_ligne2.setFont(font);
        panneau.add(text4_ligne2, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 10;
        text4_ligne3.setFont(font);
        panneau.add(text4_ligne3, cont);
        
        // Texte 5
        if (!premiere_page) cont.insets = new Insets(20,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 11;
        text5_ligne1.setFont(font);
        panneau.add(text5_ligne1, cont);
        
        // Texte 6
        if (!premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 12;
        text6_ligne1.setFont(font);
        panneau.add(text6_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 13;
        text6_ligne2.setFont(font);
        panneau.add(text6_ligne2, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 14;
        text6_ligne3.setFont(font);
        panneau.add(text6_ligne3, cont);
        
        // Texte 7
        if (!premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 15;
        text7_ligne1.setFont(font);
        panneau.add(text7_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 16;
        text7_ligne2.setFont(font);
        panneau.add(text7_ligne2, cont);
        
        // Texte 8
        if (!premiere_page) cont.insets = new Insets(30,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 17;
        text8_ligne1.setFont(font);
        panneau.add(text8_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 18;
        text8_ligne2.setFont(font);
        panneau.add(text8_ligne2, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 19;
        text8_ligne3.setFont(font);
        panneau.add(text8_ligne3, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 20;
        text8_ligne4.setFont(font);
        panneau.add(text8_ligne4, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 21;
        text8_ligne5.setFont(font);
        panneau.add(text8_ligne5, cont);
        
        // Texte 9 
        if (!premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 22;
        text8_ligne5.setFont(font);
        panneau.add(text8_ligne5, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 23;
        text8_ligne5.setFont(font);
        panneau.add(text8_ligne5, cont);
        
        // Texte 10
        if (!premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 24;
        text10_ligne1.setFont(font);
        panneau.add(text10_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 25;
        text10_ligne2.setFont(font);
        panneau.add(text10_ligne2, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 26;
        text10_ligne3.setFont(font);
        panneau.add(text10_ligne3, cont); 
        
        // Texte 11 
        if (!premiere_page) cont.insets = new Insets(15,0,0,0);
        else cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 27;
        text11_ligne1.setFont(font);
        panneau.add(text11_ligne1, cont);
        
        cont.insets = new Insets(0,0,0,0);
        cont.gridx = 0; cont.gridy = 28;
        text11_ligne2.setFont(font);
        panneau.add(text11_ligne2, cont);
        
        
        // Bouton Flèche 
        if (premiere_page) cont.insets = new Insets(20,0,0,0);
        else cont.insets = new Insets(20,0,0,0);
        cont.gridx = 0; cont.gridy = 29;
        if (premiere_page) cont.anchor = GridBagConstraints.EAST;
        else cont.anchor = GridBagConstraints.WEST;
        fleche.setPreferredSize(new Dimension(60,40));
        panneau.add(fleche, cont); 
        
        // Bouton Quitter
        cont.insets = new Insets(5,0,0,0);
        cont.gridx = 0; cont.gridy = 30;
        cont.anchor = GridBagConstraints.CENTER;
        quitter.setFont(font);
        panneau.add(quitter, cont); 
        
        this.setContentPane(panneau);
        this.pack();
    }
    
    /**
     * Implémente les actions lorsque le joueur appuie sur un des boutons
     * @param e la source de l'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fleche){
            premiere_page = !premiere_page;
            init();
        }
        if (e.getSource() == quitter){
            this.dispose();
            vuejeu.setEnabled(true);
        }
    }
    
}
