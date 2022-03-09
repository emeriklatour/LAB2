package framework.elements;

import lombok.ToString;

/******************************************************
 							De
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
@ToString

/**
 * Cette classe represente les Des qui seront rouler au courant du jeu.
 *
 * L'application peut etendre cette classe pour rajouter des fonctionalites
 * aux des.
 */
public class De implements Comparable<De> {
	private int nbFaces;
	private int currentFace;

	/**
	 * Constructeur par parametre de la classe De.
	 *
	 * @param nbFaces le nombres de faces du De
	 */
	public De(int nbFaces) {
		this.nbFaces = nbFaces;
		this.currentFace = 0;
	}

	/**
	 * Retourne la face sur le lequel le De est atterit.
	 *
	 * @return la face du De
	 */
	public int getCurrentFace() {
		return currentFace;
	}

	/**
	 * Roule le De ce qui met a jour sa face. La face du De peut aller de 1 a
	 * nbFaces.
	 */
	public void roulerDe() {
		this.currentFace = (((int) (Math.random() * 1000)) % nbFaces) + 1;
	}

	@Override
	public int compareTo(De o) {
		return Integer.compare(this.currentFace, o.currentFace);
	}
}
