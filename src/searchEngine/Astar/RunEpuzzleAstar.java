/**
 * Class containing main method to run the search
 * @author Ethan Watts
 */

public class RunEpuzzleAstar {
    
    public static void main(String[] args) {
        EpuzzleSearch search = new EpuzzleSearch();
        EpuzzGen gen = new EpuzzGen(100);

        int[][] p1Setup = {
        	{1,0,3},
        	{4,2,6},
        	{7,5,8}};
        
        int[][] p2Setup = {
        	{4,1,3},
        	{7,2,5},
        	{0,8,6}};
    
        int[][] p3Setup = {
        	{2,3,6},
        	{1,5,8},
        	{4,7,0}};
                
        int[][] random = gen.puzzGen(16);
        
        EpuzzleState p1 = new EpuzzleState(p1Setup,1);
        EpuzzleState p2 = new EpuzzleState(p2Setup,1);
        EpuzzleState p3 = new EpuzzleState(p3Setup,1);
        EpuzzleState genState = new EpuzzleState(random,1);
        
//        System.out.println(search.runSearch(p1, "AStar"));
//        System.out.println(search.runSearch(genState, "AStar"));
//        System.out.println(search.runSearch(p2, "AStar"));
        System.out.println(search.runSearch(p3, "AStar"));

    }
}