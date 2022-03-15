package framework.game;

/******************************************************
 						IStrategie
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * IStrategie doit etre implementer par une classe de l'application pour gerer
 * la logique du jeu.
 */
public interface IStrategie {
	/**
	 * Calcule le gagnant du jeu et met a jour l'index de ce dernier sur
	 * l'instance du jeu.
	 *
	 * @param jeu l'instance du jeu sur lequel nous voulons calculer le gagnant
	 */
	void calculerGagnant(Jeu jeu);

	/**
	 * Calcule le lancer d'un joueur du jeu. Cela vient mettre a jour le score
	 * du joueur et l'index du joueur courant sur l'instance du jeu.
	 *
	 * @param jeu l'instance du jeu sur lequel nous voulons calculer un lancer
	 */
	void calculerScoreTour(Jeu jeu);
}
