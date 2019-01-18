package _puzzle;

import java.util.Set;

public interface Puzzle<P, M> {
	
	P initionPosition();
	
	boolean isGoal(P position);
	
	Set<M> legalMoves(P position);
	
	P move(P position, M move);
	

}


