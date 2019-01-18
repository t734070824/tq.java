package _old.adpater.step3;

import java.util.Enumeration;
import java.util.Iterator;

public class ArrayListAdapter<E> implements Enumeration<E>{
	
	private Iterator<E> iterator;
	
	public ArrayListAdapter(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public E nextElement() {
		return iterator.next();
	}


}
