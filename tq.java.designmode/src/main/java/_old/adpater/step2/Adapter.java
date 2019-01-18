package _old.adpater.step2;


public class Adapter<E> implements Iterator<E>{

	private Enumeration<E> enumeration;
	
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}
	

	@Override
	public E next() {
		return enumeration.nextElemnet();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
