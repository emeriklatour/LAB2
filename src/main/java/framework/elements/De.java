package framework.elements;

import lombok.Getter;

@Getter
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
