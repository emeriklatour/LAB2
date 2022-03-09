package framework.collections;

import java.util.Iterator;

/******************************************************
 					IGameCollection
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * IGameCollection est l'interface utilisee par la classe Jeu pour interagir
 * avec ses collections.
 *
 * @param <Item> le type d'objet que nous voulons recueillir dans la collection
 */
public interface IGameCollection<Item> {

	/**
	 * Retourne le taille de la collection.
	 *
	 * @return la taille de la collection
	 */
	int size();

	/**
	 * Retourne un iterateur de la collection.
	 *
	 * @return un iterateur de la collection
	 */
	Iterator<Item> getIterator();
}
