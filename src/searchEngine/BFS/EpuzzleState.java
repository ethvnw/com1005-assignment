package searchEngine.BFS;

import java.util.*;

/**
 * Extension of the SearchState class to account for the changes
 * needed for 8-puzzle
 * @author Ethan Watts
 */

public class EpuzzleState extends SearchState {
	
	private int[][] state;
	
	public EpuzzleState(int[][] state) {
		this.state = state;
	}
	
    /**
     * Checks if current state is equal to goal
     * @param searcher The search engine object running the search
     * @return true if state is equal to goal
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
    
    // Manual 2D array copying
    private int[][] copyState(int[][] toCopy) {
    	int[][] copiedA = new int[3][3];
    	for (int row=0; row<3; row++) {
    		for (int col=0; col<3; col++)
    			copiedA[row][col] = toCopy[row][col];
    	}
    	return copiedA;
    }
    
    /**
     * Creates list of possible new states that can be reached from current
     * @param searcher The search engine object running the search
     * @return <code>ArrayList</code> of <code>SearchState</code>
     */
    ArrayList<SearchState> getSuccessors(Search searcher) {
        ArrayList<EpuzzleState> successors = new ArrayList<EpuzzleState>();
        int[][] compare;
        
        // Finds the coordinate on the grid with the empty space,
        // Adds all possible moves from this position to the ArrayList
        
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
        
        // Converts states to SearchState for search engine to use
        ArrayList<SearchState> castList = new ArrayList<SearchState>();
        for (EpuzzleState ep : successors)
        	castList.add((SearchState) ep);
        
        return castList;
        
    }

    /**
     * Checks if provided state is equal to current
     * @param n2 the state to be compared to
     * @return true if the states are the same
     */
    boolean sameState(SearchState n2) {
    	EpuzzleState comState = (EpuzzleState) n2;
    	// Get the array containing the grid from n2
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
    	String output = "";
    	for (int row=0; row<3; row++) {
    		for (int col=0; col<3; col++) {
    			output += this.state[row][col] + " ";
    		}
			output += "\n";
    	}
    	return output;
    }
}