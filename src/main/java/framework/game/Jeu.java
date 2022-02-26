package framework.game;

import framework.collections.IGameCollection;
import framework.elements.De;
import framework.elements.Joueur;

import java.util.Iterator;

public class Jeu implements IJeu {
	private IGameCollection<Joueur> joueurs;
	private IGameCollection<De> des;
	private IStrategie strategie;
	private int indexGagnant;
	private int nbTour;
	private int currentTurnNb;
	private int currentJoueur;

	public Jeu(IGameCollection<Joueur> joueurs, IGameCollection<De> des,
			   IStrategie strategie, int nbTour) {
		this.joueurs = joueurs;
		this.des = des;
		this.strategie = strategie;
		this.nbTour = nbTour;
		this.currentTurnNb = 1;
	}

	public Iterator<Joueur> getAllJoueurs() {
		return this.joueurs.getIterator();
	}

	public Iterator<De> getAllDes() {
		return this.des.getIterator();
	}

	public int getCurrentTurnNb() {
		return this.currentTurnNb;
	}

	public int getIndexGagnant() {
		return indexGagnant;
	}

	public void setIndexGagnant(int indexGagnant) {
		this.indexGagnant = indexGagnant;
	}

	public int getCurrentJoueur() {
		return this.currentJoueur;
	}

	public void setCurrentJoueur(int currentJoueur) {
		this.currentJoueur = currentJoueur;
	}

	public void calculerGagnant() {
		this.strategie.calculerGagnant(this);
	}

	public void calculerScoreTour() {
		this.strategie.calculerScoreTour(this);
	}

	@Override
	public void lancerJeu() {
		while (this.currentTurnNb <= this.nbTour) {
			effectuerTour();
		}
		calculerGagnant();
	}

	private void effectuerTour() {
		this.currentJoueur = 0;
		while (this.currentJoueur <= this.joueurs.size()) {
			calculerScoreTour();
		}
		this.currentTurnNb++;
	}
}
