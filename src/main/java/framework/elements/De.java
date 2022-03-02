package framework.elements;

/******************************************************
 							De
 * Cours:  LOG121
 * Projet: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
public class De implements Comparable<De> {
	private int nbFaces;
	private int currentFace;

	public De(int nbFaces) {
		this.nbFaces = nbFaces;
		this.currentFace = 0;
	}

	public int getCurrentFace() {
		return currentFace;
	}

	public void roulerDe() {
		this.currentFace = (((int) (Math.random() * 1000)) % nbFaces) + 1;
	}

	@Override
	public int compareTo(De o) {
		return Integer.compare(this.currentFace, o.currentFace);
	}
}
