/**
 * Extension of Search class to account for 8-puzzle needs
 * @author Ethan Watts
 */

public class EpuzzleSearch extends Search {
	
	// Target is same for all 8-puzzles, never changes
	private final int[][] target = {{1,2,3}, 
									{4,5,6}, 
									{7,8,0}};
	
	public int[][] getTarget() {
		return target;
	}
}
