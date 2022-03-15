package bunco;

import framework.elements.De;
import framework.elements.Joueur;
import framework.game.IStrategie;
import framework.game.Jeu;

import java.util.*;

/******************************************************
                    StrategieBunco
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Se charge du calcul du gagnant et du calcul du score d'un tour pour chaque Joueur.
 */
public class StrategieBunco implements IStrategie {
    int _nbLancerCourant = 0;
    int _score = 0; //Score total du tour courant pour un joueur.
    int _scoreLancer = 0;

    /**
     * Calcul, trie et affiche le gagnant suivi des autres joueurs en ordre decroissant.
     * @param jeu l'instance du jeu sur lequel nous voulons calculer le gagnant
     */
    @Override
    public void calculerGagnant(Jeu jeu) {
        Iterator<Joueur> joueurs = jeu.getAllJoueurs();
        Joueur[] joueurArray = new Joueur[0];

        int counter = 0;
        while(joueurs.hasNext()){
            joueurArray = Arrays.copyOf(joueurArray, joueurArray.length+1);
            Joueur next = joueurs.next();
            joueurArray[counter] = next;
            counter++;
        }

        Arrays.sort(joueurArray, Collections.reverseOrder());
        counter = 0;
        joueurs = jeu.getAllJoueurs();
        while (joueurs.hasNext()){
            Joueur j = joueurs.next();
            if(j == joueurArray[0]){
                jeu.setIndexGagnant(counter);
                break;
            }
            counter++;
        }

        System.out.println("---------------------------------------");
        System.out.println("GAGNANT : " + joueurArray[0].getName() + " avec un total de " + joueurArray[0].getScore() + " points.");
        for (int i = 1; i < joueurArray.length; i++){
            System.out.println(i+1 + "e Place : " + joueurArray[i].getName() + " avec un total de " + joueurArray[i].getScore() + " points.");
        }
    }

    /**
     * Calcul le score d'un lance et determine si le joueur relance ou s'il passe la main au prochain joueur.
     * Les resultats sont enonces a la console.
     * @param jeu l'instance du jeu sur lequel nous voulons calculer un lancer
     */
    @Override
    public void calculerScoreTour(Jeu jeu) {
        int dePoints = 0; //Pour savoir le nombre de points a ajouter au score a chaque lance.
        int miniBunco = 0; //Pour savoir s'il y a un mini bunco.
        int currentJoueur = jeu.getCurrentJoueur();

        System.out.print("Joueur " + (currentJoueur+1) + " lance " + (_nbLancerCourant+=1) + " fois. (");
        roulerLesDes(jeu.getAllDes());

        Iterator<De> des = jeu.getAllDes();
        De first = jeu.getAllDes().next(); //Pour comparer les des et savoir s'il y a un mini Bunco.
        De currentDe;
        while(des.hasNext()){
            currentDe = des.next();
            if(currentDe.getCurrentFace() == jeu.getCurrentTurnNb())
                dePoints++;
            if(currentDe.compareTo(first) == 0)
                miniBunco++;
        }

        //Compte des points obtenus pour le lance.
        if(dePoints == 3) {
            //Si dePoints = 3, les 3 des sont pareils au nombre du tour courant. score = 21 et on passe au prochain joueur.
            _score = 21;
            _scoreLancer=21;
            System.out.println("bunco! 21 points.)");
            setScore(jeu, currentJoueur);
            reset(jeu, currentJoueur);
        } else if (miniBunco == 3){
            //Si miniBunco = 3, les 3 des sont pareils. score + 5 et on lance une autre fois.
            _score += 5;
            _scoreLancer = 5;
            setScore(jeu, currentJoueur);
            System.out.println("mini bunco! +5 points.)");
        } else if (dePoints == 1){
            /*
            Si dePoints = 1, une face d'un des des lances est egale au nombre du tour courant. On ajoute 1 au score courant et on lance
            une autre fois.
             */
            _score += 1;
            _scoreLancer = 1;
            setScore(jeu, currentJoueur);
            System.out.println(1 + " points.)");
        } else if (dePoints == 2){
            /*
            Si dePoints = 2, 2 face des des lances sont egales au nombre du tour courant. On ajoute 2 au
            score et on lance une autre fois.
             */
            _score += 2;
            _scoreLancer = 2;
            setScore(jeu, currentJoueur);
            System.out.println((2 + " points.)"));
        } else {
            // Aucun point n'a ete gagne et on passe au prochain joueur.
            System.out.println("0 points.)");
            setScore(jeu, currentJoueur);
            reset(jeu, currentJoueur);
        }

    }

    /**
     * Roule chacun des des dans la collection.
     * @param des Un iterateur de type "De"
     */
    public void roulerLesDes(Iterator<De> des){
        while (des.hasNext()){
            De de = des.next();
            de.roulerDe();
        }
    }

    /**
     * Reinitialise les variables necessaires au calcul du score d'un lancer pour un joueur
     * et change de joueur. Cette methode est appelee si le joueur obtient 0 points ou un BUNCO.
     * @param jeu l'instance du jeu sur lequel nous voulons calculer un lancer.
     * @param currentJoueur le joueur courant sur lequel on calcule un lancer.
     */
    private void reset(Jeu jeu, int currentJoueur){
        System.out.println("Joueur " + (currentJoueur+1) + " a obtenu " + _score + " points pour le tour "
                + jeu.getCurrentTurnNb() + ".");
        jeu.setCurrentJoueur(currentJoueur+1);
        _nbLancerCourant = 0;
        _score = 0;
    }

    /**
     * Ajoute le score du lancer courant au joueur courant et reinitialise la variable du score courant
     * pour le prochain lance. Cette methode est appelee peu importe le score obtenu.
     * @param jeu l'instance du jeu sur lequel nous voulons calculer un lancer.
     * @param currentJoueur le joueur courant sur lequel un calcule on lancer.
     */
    private void setScore(Jeu jeu, int currentJoueur){
        //Ajout du score obtenu dans le tour au score du joueur courant.
        Joueur joueur = getCurrentJoueur(currentJoueur, jeu.getAllJoueurs());
        joueur.setScore((joueur.getScore()+ _scoreLancer));
        _scoreLancer = 0;
    }

    /**
     * Retrouve le bon joueur selon l'index donne. Methode separee afin d'alleger calculerScoreTour().
     * @param joueurIndex L'index du jour recherche.
     * @param joueurs L'iterateur de type "Joueur" dans lequel on recherche le joueur.
     * @return Le joueur trouve, ou null s'il n'a pas ete trouve.
     */
    private Joueur getCurrentJoueur(int joueurIndex, Iterator<Joueur> joueurs){
        Joueur joueur = null;
        for (int i = 0; i <= joueurIndex; i++) {
            joueur = joueurs.next();
        }
         return joueur;
    }
}
