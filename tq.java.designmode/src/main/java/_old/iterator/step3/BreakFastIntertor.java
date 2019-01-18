package _old.iterator.step3;

import java.util.ArrayList;

public class BreakFastIntertor implements Iterator<MenuItem>{
	
	private int index;
	
	private ArrayList<MenuItem> arrayList;
	
	public BreakFastIntertor(ArrayList<MenuItem> arrayList) {
		index = 0;
		this.arrayList = arrayList;
	}

	@Override
	public boolean hasNext() {
		return arrayList.size() > index;
	}

	@Override
	public MenuItem next() {
		if(hasNext())
			return arrayList.get(index++);
		return null;
	}

}
