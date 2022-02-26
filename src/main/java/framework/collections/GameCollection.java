package framework.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameCollection<Item> implements IGameCollection<Item> {
	private final List<Item> list;

	public GameCollection() {
		this.list = new ArrayList<>();
	}

	public GameCollection(List<Item> list) {
		this.list = list;
	}

	public void add(Item item) {
		this.list.add(item);
	}

	public void remove(Item item) {
		this.list.remove(item);
	}

	public int size() {
		return this.list.size();
	}

	@Override
	public Iterator<Item> getIterator() {
		return list.iterator();
	}
}
