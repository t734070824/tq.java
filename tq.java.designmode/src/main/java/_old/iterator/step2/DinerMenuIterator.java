package _old.iterator.step2;

public class DinerMenuIterator implements Iterator<MenuItem>{
	
	private int position;
	private MenuItem[] itmes;
	
	
	
	public DinerMenuIterator(MenuItem[] itmes) {
		this.itmes = itmes;
		position = 0;
	}

	@Override
	public boolean hasNext() {
		return position < itmes.length;
	}

	@Override
	public MenuItem next() {
		if(hasNext())
			return itmes[position++];
		return null;
	}

}
