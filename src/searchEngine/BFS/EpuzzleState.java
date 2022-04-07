package searchEngine.BFS;

import java.util.*;

public class EpuzzleState extends SearchState {
    /**
    * goalPredicate takes a SearchNode & returns a boolean if it's a goal
    */
    boolean goalPredicate(Search searcher) {
        return true;
    }

    /** getSuccessors returns an ArrayList of states which are successors to the
    * current state in a given search
    */
    ArrayList<SearchState> getSuccessors(Search searcher) {
        return null;
    }

    /**
    * sameState: is this state identical to a given one?
    */
    boolean sameState(SearchState n2) {
        return true;
    }
}
