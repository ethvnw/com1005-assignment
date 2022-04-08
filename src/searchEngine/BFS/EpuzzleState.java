package searchEngine.BFS;

import java.util.*;

public class EpuzzleState extends SearchState {
	
	private int[][] state;
	
	public EpuzzleState(int[][] state) {
		this.state = state;
	}
	
    /**
    * goalPredicate takes a SearchNode & returns a boolean if it's a goal
    */
    boolean goalPredicate(Search searcher) {
    	EpuzzleSearch epSearch = (EpuzzleSearch) searcher;
        int[][] target = epSearch.getTarget();
        
        for (int row=0; row<3; row++) {
        	for (int col=0; col<3; col++) {
        		if (state[row][col] != target[row][col])
        			return false;
        	}
        }
        return true;
    }

    /** getSuccessors returns an ArrayList of states which are successors to the
    * current state in a given search
    */
    
    private int[][] copyState(int[][] toCopy) {
    	int[][] copiedA = new int[3][3];
    	for (int row=0; row<3; row++) {
    		for (int col=0; col<3; col++)
    			copiedA[row][col] = toCopy[row][col];
    	}
    	return copiedA;
    }
    
    ArrayList<SearchState> getSuccessors(Search searcher) {
        ArrayList<EpuzzleState> successors = new ArrayList<EpuzzleState>();
        int[][] compare;
        
        if (state[0][0] == 0) {
        	compare = copyState(state);
        	compare[0][0] = compare[1][0];
        	compare[1][0] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[0][0] = compare[0][1];
        	compare[0][1] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[0][1]== 0) {
        	compare = copyState(state);
        	compare[0][1] = compare[0][0];
        	compare[0][0] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[0][1] = compare[1][1];
        	compare[1][1] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[0][1] = compare[0][2];
        	compare[0][2] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[0][2] == 0) {
        	compare = copyState(state);
        	compare[0][2] = compare[0][1];
        	compare[0][1] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[0][2] = compare[1][2];
        	compare[1][2] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[1][0] == 0) {
        	compare = copyState(state);
        	compare[1][0] = compare[0][0];
        	compare[0][0] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[1][0] = compare[1][1];
        	compare[1][1] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[1][0] = compare[2][0];
        	compare[2][0] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[1][1] == 0) {
        	compare = copyState(state);
        	compare[1][1] = compare[0][1];
        	compare[0][1] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[1][1] = compare[1][2];
        	compare[1][2] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[1][1] = compare[2][1];
        	compare[2][1] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[1][1] = compare[1][0];
        	compare[1][0] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[1][2] == 0) {
        	compare = copyState(state);
        	compare[1][2] = compare[0][2];
        	compare[0][2] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[1][2] = compare[1][1];
        	compare[1][1] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[1][2] = compare[2][2];
        	compare[2][2] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[2][0] == 0) {
        	compare = copyState(state);
        	compare[2][0] = compare[1][0];
        	compare[1][0] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[2][0] = compare[2][1];
        	compare[2][1] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[2][1] == 0) {
        	compare = copyState(state);
        	compare[2][1] = compare[2][0];
        	compare[2][0] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[2][1] = compare[1][1];
        	compare[1][1] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[2][1] = compare[2][2];
        	compare[2][2] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        if (state[2][2] == 0) {
        	compare = copyState(state);
        	compare[2][2] = compare[1][2];
        	compare[1][2] = 0;
        	successors.add(new EpuzzleState(compare));
        	
        	compare = copyState(state);
        	compare[2][2] = compare[2][1];
        	compare[2][1] = 0;
        	successors.add(new EpuzzleState(compare));
        }
        
        ArrayList<SearchState> castList = new ArrayList<SearchState>();
        for (EpuzzleState ep : successors)
        	castList.add((SearchState) ep);
        
        return castList;
        
    }

    /**
    * sameState: is this state identical to a given one?
    */
    boolean sameState(SearchState n2) {
    	EpuzzleState comState = (EpuzzleState) n2;
    	int[][] comPuzz = comState.state;
    	
    	for (int row=0; row<3; row++) {
    		for (int col=0; col<3; col++) {
    			if (state[row][col] != comPuzz[row][col])
    				return false;
	      	}
		}
    	return true;
	}
    
    public String toString() {
    	String output = "\n";
    	for (int row=0; row<3; row++) {
    		for (int col=0; col<3; col++) {
    			output += this.state[row][col] + " ";
    		}
//    		if (row != 2)
    			output += "\n";
    	}
    	return output;
    }
}