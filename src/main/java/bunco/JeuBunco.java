package bunco;

import framework.collections.GameCollection;
import framework.collections.IGameCollection;
import framework.elements.De;
import framework.elements.Joueur;
import framework.game.IStrategie;
import framework.game.JeuTemplate;

/******************************************************
                        JeuBunco
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Represente le jeu de des Bunco+
 */
public class JeuBunco extends JeuTemplate {

    /**
     * Recueille les joueurs.
     * @return un objet GameCollection de type Joueur.
     */
    @Override
    public IGameCollection<Joueur> getJoueurs() {
        GameCollection<Joueur> joueurs = new GameCollection<>();
        joueurs.add(new Joueur("Joueur 1"));
        joueurs.add(new Joueur("Joueur 2"));
        joueurs.add(new Joueur("Joueur 3"));
        return joueurs;
    }

    /**
     * Recueille les des.
     * @return un objet GameCollection de type De.
     */
    @Override
    public IGameCollection<De> getDes() {
        GameCollection<De> des = new GameCollection<>();
        for (int i = 0; i < 3; i++){
            des.add(new De(6));
        }
        return des;
    }

    /**
     * Initialise et retourne la strategie a utiliser pour le jeu.
     * @return un objet qui implemente l'interface IStrategie, StrategieBunco.
     */
    @Override
    public IStrategie getStrategie() {
        return new StrategieBunco();
    }

    /**
     * Recueille le nombre de tours pour le jeu.
     * @return le nombre de tours.
     */
    @Override
    public int getNbTours() {
        return 6;
    }
}
