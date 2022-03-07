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
        int score = 0; //Score total du tour courant pour un joueur.
        int dePoints; //Pour savoir le nombre de points à ajouter au score à chaque lancé.
        int miniBunco; //Pour savoir s'il y a un mini bunco.

        System.out.println("***************************************");
        //For loop qui loop 3 fois par joueur, pour effectuer 3 lancés.
        for (int i = 0; i < 3 ; i++) {
            dePoints = 0;
            miniBunco = 0;
            System.out.print("Joueur " + (jeu.getCurrentJoueur()+1) + " lance " + (i + 1) + " fois. (");
            roulerLesDes(jeu.getAllDes());
            /*
            J'initialise un Iterator<De> à chaque fois qu'on loop (à chaque lancé)
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
                Si dePoints = 3, les 3 dés sont pareils au nombre du tour courant. score = 21 et on sort de la loop
                parce que le tour est fini.
                 */
                score = 21;
                System.out.println("bunco! 21 points.)");
                break;
            } else if (miniBunco == 3){
                /*
                Si miniBunco = 3, les 3 dés sont pareils. score + 5 et on lance une autre fois.
                 */
                score = score + 5;
                System.out.println("mini bunco! +5 points.)");
            } else if (dePoints == 1){
                /*
                Si dePoints = 1, une face d'un des dés lancés est égale au nombre du tour courant. On ajoute le nombre du
                tour courant au score et on lance une autre fois.
                 */
                score = score + jeu.getCurrentTurnNb();
                System.out.println(jeu.getCurrentTurnNb() + " points.)");
            } else if (dePoints == 2){
                /*
                Si dePoints = 2, 2 face des dés lancés sont égales au nombre du tour courant. On ajoute le nombre du
                tour courant x 2 au score et on lance une autre fois.
                 */
                score = score + (jeu.getCurrentTurnNb()*2);
                System.out.println((jeu.getCurrentTurnNb()*2) + " points.)");
            } else {
                System.out.println("0 points.)");
            }
        }

        System.out.println("Joueur " + (jeu.getCurrentJoueur()+1) + " a obtenu " + score + " points pour le tour "
                + jeu.getCurrentTurnNb() + ".");
        System.out.println("***************************************");
        System.out.println();
        //Ajout du score obtenu dans le tour au score du joueur courant.
        Joueur currentJoueur = getCurrentJoueur(jeu.getCurrentJoueur(), jeu.getAllJoueurs());
        currentJoueur.setScore((currentJoueur.getScore()+ score));
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
