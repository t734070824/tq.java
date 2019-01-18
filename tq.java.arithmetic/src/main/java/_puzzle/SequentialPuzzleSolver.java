package _puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SequentialPuzzleSolver<P, M> {

	
	private final Puzzle<P, M> puzzle;
	
	private final Set<P> seen = new HashSet<>();
	
	public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
		this.puzzle = puzzle;
	}
	
	public List<M> solve(){
		P pos = puzzle.initionPosition();
		return search(new Node<>(pos, null, null));
	}





	private List<M> search(Node<P, M> node) {
		if(!seen.contains(node.pos)){
			seen.add(node.pos);
			if(puzzle.isGoal(node.pos)){
				return node.asMoveList();
			}
			for(M move : puzzle.legalMoves(node.pos)){
				P pos = puzzle.move(node.pos, move);
				Node<P, M> child = new Node<P, M>(pos, move, node);
				List<M> search = search(child);
				if(search != null){
					return search;
				}
			}
		}
		return null;
	}





	static class Node<P, M>{
		final P pos;
		
		final M move;
		
		final Node<P, M> prev;

		public Node(P pos, M move, Node<P, M> prev) {
			this.pos = pos;
			this.move = move;
			this.prev = prev;
		}
		
		List<M> asMoveList(){
			List<M> solution = new LinkedList<>();
			for(Node<P, M> n = this; n.move != null; n = n.prev){
				solution.add(0, n.move);
			}
			return solution;
		}
		
	}
}
