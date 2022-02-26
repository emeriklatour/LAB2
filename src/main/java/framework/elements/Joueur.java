package framework.elements;

import lombok.ToString;

@ToString
public class Joueur implements Comparable<Joueur> {
	private String name;
	private int score;

	public Joueur(String name) {
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Joueur o) {
		return Integer.compare(this.score, o.score);
	}
}
