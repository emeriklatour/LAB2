package framework.bunco;

import framework.collections.GameCollection;
import framework.collections.IGameCollection;
import framework.elements.De;
import framework.elements.Joueur;
import framework.game.IStrategie;
import framework.game.JeuTemplate;

/******************************************************
                        JeuBunco
 * Cours:  LOG121
 * Projet: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
public class JeuBunco extends JeuTemplate {

    @Override
    public IGameCollection<Joueur> getJoueurs() {
        GameCollection<Joueur> joueurs = new GameCollection<>();
        joueurs.add(new Joueur("Joueur 1"));
        joueurs.add(new Joueur("Joueur 2"));
        joueurs.add(new Joueur("Joueur 3"));
        return joueurs;
    }

    @Override
    public IGameCollection<De> getDes() {
        GameCollection<De> des = new GameCollection<>();
        for (int i = 0; i < 3; i++){
            des.add(new De(6));
        }
        return des;
    }

    @Override
    public IStrategie getStrategie() {
        return new StrategieBunco();
    }

    @Override
    public int getNbTours() {
        return 6;
    }
}
