package _old.composite.step2;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponet>{
	
	Stack<Iterator<MenuComponet>> stack = new Stack<>();
	
	public CompositeIterator(Iterator<MenuComponet> iterator) {
		stack.push(iterator);
	}

	@Override
	public boolean hasNext() {
		if(stack.isEmpty()){
			return false;
		} else {
			Iterator<MenuComponet> iterator = stack.peek();
			if(iterator.hasNext()){
				return true;
			} else {
				stack.pop();
				return hasNext();
			}
		}
	}

	@Override
	public MenuComponet next() {
		if(hasNext()){
			Iterator<MenuComponet> iterator = stack.peek();
			MenuComponet next = iterator.next();
			if(next instanceof Menu){
				stack.push(next.createInterator());
			}
			return next;
		}else {
			return null;
		}
	}

}
