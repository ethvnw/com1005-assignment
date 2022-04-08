package searchEngine.BFS;

public class RunEpuzzleBFS {
    
    public static void main(String[] args) {
        EpuzzleSearch search = new EpuzzleSearch();
        int[][] p1Setup = {
        	{1,0,3},
        	{4,2,6},
        	{7,5,8}};
        
        EpuzzleState p1 = new EpuzzleState(p1Setup);

        System.out.println(p1.getSuccessors(search));
        
        search.runSearch(p1, "breadthFirst");

    }
}