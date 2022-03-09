package framework.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/******************************************************
 					GameCollection
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Represente les collections qui seront utiliser par le jeu.
 *
 * @param <Item> le type d'objet que nous voulons recueillir dans la collection
 */
public class GameCollection<Item> implements IGameCollection<Item> {
	private final List<Item> list;

	/**
	 * Constructeur par defaut de la classe GameCollection.
	 */
	public GameCollection() {
		this.list = new ArrayList<>();
	}

	/**
	 * Ajoute un item a la collection.
	 *
	 * @param item l'item a ajouter a la collection
	 */
	public void add(Item item) {
		this.list.add(item);
	}

	/**
	 * Retire un item de la collection.
	 *
	 * @param item l'item a retirer de la collection
	 */
	public void remove(Item item) {
		this.list.remove(item);
	}

	/**
	 * Retourne le taille de la collection.
	 *
	 * @return la taille de la collection
	 */
	@Override
	public int size() {
		return this.list.size();
	}

	/**
	 * Retourne un iterateur de la collection.
	 *
	 * @return un iterateur de la collection
	 */
	@Override
	public Iterator<Item> getIterator() {
		return list.iterator();
	}
}
