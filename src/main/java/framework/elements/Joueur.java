package framework.elements;

/******************************************************
 						Joueur
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Cette classe represente les joueurs qui participeront au jeu.
 *
 * L'application peut etendre cette classe pour rajouter des fonctionalites
 * aux joueurs.
 */
public class Joueur implements Comparable<Joueur> {
	private String name;
	private int score;

	/**
	 * Constructeur par parametre de la classe Joueur.
	 *
	 * @param name le nom du joueur
	 */
	public Joueur(String name) {
		this.name = name;
		this.score = 0;
	}

	/**
	 * Retourne le nom du joueur.
	 *
	 * @return le nom du joueur
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Retourne le score du joueur.
	 *
	 * @return le score du joueur
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Met a jour le score du joueur.
	 *
	 * @param score le nouveau score du joueur
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Joueur o) {
		return Integer.compare(this.score, o.score);
	}


}
