package framework.game;

import framework.collections.IGameCollection;
import framework.elements.De;
import framework.elements.Joueur;

/******************************************************
					JeuTemplate
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
public abstract class JeuTemplate {
	public IJeu initialiserJeu() {
		return new Jeu(
				getJoueurs(),
				getDes(),
				getStrategie(),
				getNbTours()
		);
	}

	public abstract IGameCollection<Joueur> getJoueurs();

	public abstract IGameCollection<De> getDes();

	public abstract IStrategie getStrategie();

	public abstract int getNbTours();
}
