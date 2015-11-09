package Challenges;

import java.util.Iterator;

/**
 * @author muatik
 * yes, too long class name but the purpose here is to experiment
 * @param <Item>
 */
public class IterableGenericFixedArrayStack<Item> 
	extends GenericFixedArrayStack<Item>
	implements Iterable<Item>{

	public IterableGenericFixedArrayStack(int size) {
		super(size);
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	class StackIterator implements Iterator<Item> {
		int position = last;
		
		@Override
		public boolean hasNext() {
			return position > -1;
		}

		@Override
		public Item next() {
			return stack[position--];
		}
		
	}
}
