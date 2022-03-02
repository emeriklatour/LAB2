package framework.collections;

import java.util.Iterator;

/******************************************************
 					IGameCollection
 * Cours:  LOG121
 * Projet: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
public interface IGameCollection<Item> {
	Iterator<Item> getIterator();

	int size();
}
