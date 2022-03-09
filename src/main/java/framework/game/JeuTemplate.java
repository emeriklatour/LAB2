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

/**
 * JeuTemplate est la classe creatrice de ce framework.
 *
 * L'application doit etendre cette classe pour gerer la creation de son jeu.
 */
public abstract class JeuTemplate {

	/**
	 * Creer le jeu.
	 *
	 * @return l'instance du jeu
	 */
	public IJeu initialiserJeu() {
		return new Jeu(
				getJoueurs(),
				getDes(),
				getStrategie(),
				getNbTours()
		);
	}

	/**
	 * Creer les joueurs qui participeront au jeu.
	 *
	 * @return les joueurs qui participeront au jeu
	 */
	public abstract IGameCollection<Joueur> getJoueurs();

	/**
	 * Creer les Des qui seront utilisee dans le jeu.
	 *
	 * @return les Des qui seront utilisee dans le jeu
	 */
	public abstract IGameCollection<De> getDes();

	/**
	 * Retourne la strategie de l'application qui serat utilisee dans le jeu.
	 *
	 * @return la strategie de l'application qui serat utilisee dans le jeu.
	 */
	public abstract IStrategie getStrategie();

	/**
	 * Retourne le nombre de tours dans une partie du jeu.
	 *
	 * @return le nombre de tours dans une partie du jeu.
	 */
	public abstract int getNbTours();
}
