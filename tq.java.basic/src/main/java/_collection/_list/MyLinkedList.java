package _collection._list;

public class MyLinkedList<E> {
	
	private int size;
	
	private Node<E> first;
	
	private Node<E> last;
	
	
	public void add(E e){
		addFirst(e);
	}
	
	
	public void addFirst(E e){
		linkFirst(e);
	}
	
	private void linkFirst(E e) {
		Node<E> f = first;
		Node<E> newNode = new Node<E>(null, e, f);
		first = newNode;
		if(f == null)
			last = newNode;
		else
			f.prev = newNode;
		size++;
	}
	
	public void addLast(E e){
		Node<E> l = last;
		Node<E> newNode = new Node<E>(l, e, null);
		last = newNode;
		if(l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
	}
	
	public void add(int index, E e){
		if(index < 0 || index >size)
			throw new IndexOutOfBoundsException(index+"");
		if(index == 0)
			addFirst(e);
		else if(index == size)
			addLast(e);
		else{
			Node<E> x = first ;
			for (int i = 1; i <= index; i++) {
				x = first.next;
			}
			Node<E> tempNext = x.next;
			x.next = new Node<E>(x, e, tempNext);
			size++;
		}
	}






	private static class Node<E>{
		private E e;
		
		private Node<E> prev;
		
		private Node<E> next;
		
		public Node(Node<E> prev, E element, Node<E> next) {
			this.e = element;
			this.prev = prev;
			this.next = next;
		}
		@Override
		public String toString() {
			return e.toString();
		}
		
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> temp = first;
		while(temp != null){
			sb.append(temp).append(",");
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
		
	}






	public int getSize() {
		return size;
	}

	public Node<E> getFirst() {
		return first;
	}

	public Node<E> getLast() {
		return last;
	}

}
