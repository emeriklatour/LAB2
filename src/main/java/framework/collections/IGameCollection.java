package framework.collections;

import java.util.Iterator;

public interface IGameCollection<Item> {
	Iterator<Item> getIterator();

	int size();
}
