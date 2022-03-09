package framework.game;

import framework.collections.IGameCollection;
import framework.elements.De;
import framework.elements.Joueur;

import java.util.Iterator;

/******************************************************
 						Jeu
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Cette classe contient l'etat du jeu et s'occupe du deroulement d'une partie.
 */
public class Jeu implements IJeu {
	private IGameCollection<Joueur> joueurs;
	private IGameCollection<De> des;
	private IStrategie strategie;
	private int indexGagnant;
	private int nbTour;
	private int currentTurnNb;
	private int currentJoueur;

	/**
	 * Constructeur par parametre de la classe Jeu.
	 *
	 * @param joueurs la collection initiale des joueurs de la partie
	 * @param des la collection initiale des Des de la partie
	 * @param strategie la strategie a utiliser au courant de la partie
	 * @param nbTour le nombre de tour que durera la partie
	 */
	public Jeu(IGameCollection<Joueur> joueurs,
			   IGameCollection<De> des,
			   IStrategie strategie,
			   int nbTour) {
		this.joueurs = joueurs;
		this.des = des;
		this.strategie = strategie;
		this.nbTour = nbTour;
		this.currentTurnNb = 1;
	}

	/**
	 * Retourne un iterateur des joueurs de la partie.
	 *
	 * @return un iterateur des joueurs de la partie
	 */
	public Iterator<Joueur> getAllJoueurs() {
		return this.joueurs.getIterator();
	}

	/**
	 * Retourne un iterateur des Des de la partie.
	 *
	 * @return un iterateur des Des de la partie
	 */
	public Iterator<De> getAllDes() {
		return this.des.getIterator();
	}

	/**
	 * Retourne l'index du tour present.
	 *
	 * @return l'index du tour present
	 */
	public int getCurrentTurnNb() {
		return this.currentTurnNb;
	}

	/**
	 * Retourne l'index du gagnant dans la collection de joueurs de la partie.
	 *
	 * @return l'index du gagnant dans la collection de joueurs de la partie
	 */
	public int getIndexGagnant() {
		return indexGagnant;
	}

	/**
	 * Met a jour l'index du gagnant de la partie.
	 *
	 * @param indexGagnant le nouvel index du gagnant de la partie
	 */
	public void setIndexGagnant(int indexGagnant) {
		this.indexGagnant = indexGagnant;
	}

	/**
	 * Retourne l'index du joueur qui doit jouer sont tour.
	 *
	 * @return l'index du joueur qui doit jouer sont tour
	 */
	public int getCurrentJoueur() {
		return this.currentJoueur;
	}

	/**
	 * Met a jour l'index du joueur qui doit jouer sont tour.
	 *
	 * @param currentJoueur le nouvel index du joueur qui doit jouer sont tour
	 */
	public void setCurrentJoueur(int currentJoueur) {
		this.currentJoueur = currentJoueur;
	}

	/**
	 * Utilise la strategie de cette instance du jeu pour calculer le gagnant
	 * de la partie.
	 */
	public void calculerGagnant() {
		this.strategie.calculerGagnant(this);
	}

	/**
	 * Utilise la strategie de cette instance du jeu pour effectuer le lancer
	 * du joueur qui doit jouer sont tour.
	 */
	public void calculerScoreTour() {
		this.strategie.calculerScoreTour(this);
	}

	/**
	 * Effectue une partie du jeu et enonce les tours a la console.
	 */
	@Override
	public void lancerJeu() {
		while (this.currentTurnNb <= this.nbTour) {
			System.out.println("---------------------------------------");
			System.out.println("Tour " + currentTurnNb);
			System.out.println("---------------------------------------");
			effectuerTour();
		}
		calculerGagnant();
	}

	/**
	 * Effectue un tour du jeu et enonce les resultat a la console.
	 */
	private void effectuerTour() {
		this.currentJoueur = 0;
		System.out.println("***************************************");
		while (this.currentJoueur < this.joueurs.size()) {
			calculerScoreTour();
		}
		System.out.println("***************************************");
		this.currentTurnNb++;
	}
}
