package searchEngine.Astar;

public class EpuzzleSearch extends Search {
	
	private final int[][] target = {{1,2,3}, 
									{4,5,6}, 
									{7,8,0}};
	
	public int[][] getTarget() {
		return target;
	}
}
