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
public class StrategieBunco implements IStrategie {
    int _nbLancerCourant = 0;
    int _score = 0; //Score total du tour courant pour un joueur.

    @Override
    public void calculerGagnant(Jeu jeu) {
        Joueur gagnant = jeu.getAllJoueurs().next();
        Joueur next;
        Iterator<Joueur> joueurs = jeu.getAllJoueurs();;

        while(joueurs.hasNext()){
            next = joueurs.next();
            if(next.compareTo(gagnant)>0)
                gagnant = next;
        }

        System.out.println("---------------------------------------");
        System.err.println("GAGNANT : " + gagnant.getName() + " avec un total de " + gagnant.getScore() + " points.");
    }

    @Override
    public void calculerScoreTour(Jeu jeu) {
        int dePoints = 0; //Pour savoir le nombre de points à ajouter au score à chaque lancé.
        int miniBunco = 0; //Pour savoir s'il y a un mini bunco.
        int currentJoueur = jeu.getCurrentJoueur();

        System.out.print("Joueur " + (currentJoueur+1) + " lance " + (_nbLancerCourant+=1) + " fois. (");
        roulerLesDes(jeu.getAllDes());
        /*
        J'initialise un Iterator<De> à chaque à chaque lancé
        parce que sinon l'index reste à la fin de l'itérateur et le code va passer par-dessus
        parce que hasNext() retourne false. J'ai mis longtemps à trouver l'erreur.
         */
        Iterator<De> des = jeu.getAllDes();
        De first = jeu.getAllDes().next(); //Pour comparer les dés et savoir s'il y a un mini Bunco. P.S. Toujours égal à 1
        De currentDe;
        while(des.hasNext()){
            currentDe = des.next();
            if(currentDe.getCurrentFace() == jeu.getCurrentTurnNb())
                dePoints++;
            if(currentDe.compareTo(first) == 0)
                miniBunco++;
        }

        //Compte des points obtenus pour le lancé.
        if(dePoints == 3) {
            /*
            Si dePoints = 3, les 3 dés sont pareils au nombre du tour courant. score = 21 et on passe au prochain joueur.
             */
            _score = 21;
            System.out.println("bunco! 21 points.)");
            setScoreAndReset(jeu, currentJoueur);
        } else if (miniBunco == 3){
            /*
            Si miniBunco = 3, les 3 dés sont pareils. score + 5 et on lance une autre fois.
             */
            _score += 5;
            System.out.println("mini bunco! +5 points.)");
        } else if (dePoints == 1){
            /*
            Si dePoints = 1, une face d'un des dés lancés est égale au nombre du tour courant. On ajoute 1 au score courant et on lance
            une autre fois.
             */
            _score += 1;
            System.out.println(1 + " points.)");
        } else if (dePoints == 2){
            /*
            Si dePoints = 2, 2 face des dés lancés sont égales au nombre du tour courant. On ajoute 2 au
            score et on lance une autre fois.
             */
            _score += 2;
            System.out.println((2 + " points.)"));
        } else {
            /*
            Aucun point n'a été gagné et on passe au prochain joueur.
             */
            System.out.println("0 points.)");
            setScoreAndReset(jeu, currentJoueur);
        }

    }

    /**
     * Roule chacun des dés dans la collection.
     * @param des Un itérateur de type "De"
     */
    private void roulerLesDes(Iterator<De> des){
        while (des.hasNext()){
            De de = des.next();
            de.roulerDe();
        }
    }

    /**
     * Ajoute le score au joueur courant et réinitialise les variables de la classe pour l'affichage du prochain joueur.
     * @param jeu le jeu Bunco
     * @param currentJoueur l'index du joueur courrant.
     */
    private void setScoreAndReset(Jeu jeu, int currentJoueur){
        _nbLancerCourant = 0;
        System.out.println("Joueur " + (currentJoueur+1) + " a obtenu " + _score + " points pour le tour "
                + jeu.getCurrentTurnNb() + ".");
        jeu.setCurrentJoueur(currentJoueur+1);
        //Ajout du score obtenu dans le tour au score du joueur courant.
        Joueur joueur = getCurrentJoueur(currentJoueur, jeu.getAllJoueurs());
        joueur.setScore((joueur.getScore()+ _score));
        _score = 0;
    }

    /**
     * Retrouve le bon joueur selon l'index donné. Méthode séparée afin d'alléger calculerScoreTour().
     * @param joueurIndex L'index du jour recherché.
     * @param joueurs L'itérateur de type "Joueur" dans lequel on recherche le joueur.
     * @return Le joueur trouvé, ou null s'il n'a pas été trouvé.
     */
    private Joueur getCurrentJoueur(int joueurIndex, Iterator<Joueur> joueurs){
        Joueur joueur = null;
        for (int i = 0; i <= joueurIndex; i++) {
            joueur = joueurs.next();
        }
         return joueur;
    }
}
