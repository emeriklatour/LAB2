package framework.game;

import framework.collections.IGameCollection;
import framework.elements.De;
import framework.elements.Joueur;

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
