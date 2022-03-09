package framework.game;

/******************************************************
 						IJeu
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * IJeu est l'interface utilisee par l'application pour interagir avec
 * l'instance de la classe Jeu.
 */
public interface IJeu {

	/**
	 * Effectue une partie du jeu et enonce les tours a la console.
	 */
	void lancerJeu();
}
