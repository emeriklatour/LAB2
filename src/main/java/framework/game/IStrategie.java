package framework.game;

/******************************************************
 						IStrategie
 * Cours:  LOG121
 * Projet: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
public interface IStrategie {
	void calculerGagnant(Jeu jeu);

	void calculerScoreTour(Jeu jeu);
}
