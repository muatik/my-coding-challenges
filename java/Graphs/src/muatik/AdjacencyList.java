package muatik;

import java.util.Iterator;

public class AdjacencyList implements Iterable {
	protected int edges[];
	
	public AdjacencyList(int maxAdjacency) {
		edges = new int[maxAdjacency];
	}
	
	public void add(int w) {
		edges[w] = 1;
	}
	
	public void remove(int w) {
		edges[w] = 0;
	}
	
	public int[] get() {
		return edges;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i: edges)
			sb.append(i + ",");
		return sb.toString();
	}
	

	@Override
	public Iterator iterator() {
		return new AdjacencyIterator();
	}
	
	private class AdjacencyIterator implements Iterator<Integer>{
		
		private int cursor;
		
		@Override
		public boolean hasNext() {
			for (int i = cursor; i < edges.length; i++) {
				if (edges[i] == 1) {
					cursor = i;
					return true;
				}
			}
			return false;
		}

		@Override
		public Integer next() {
			return cursor++;
		}

		
	}

}
