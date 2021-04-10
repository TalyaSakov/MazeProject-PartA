package algorithms.search;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BestFirstSearch search algorithm.
 * Extends BreadthFirstSearch, defines another measure for comparing steps. Based on cost
 */
public class BestFirstSearch extends BreadthFirstSearch {
    @Override
    /**
     * @return number of nodes evaluated.
     */
    public int getNumberOfNodesEvaluated() {
        return super.getNumberOfNodesEvaluated();
    }

    @Override
    /**
     * @return name of the algorithm - "BestFirstSearch".
     */
    public String getName() {
        return "BestFirstSearch";
    }

    @Override
    /**
     *Use the BFS solve function but sends the value of the current algorithm name
     * and comparator for comparison based on cost.
     */
    public Solution solve(ISearchable specificPuzzle) {
        class AStateComparerator implements Comparator<AState> {
            @Override
            public int compare(AState s1, AState s2) {
                return Integer.compare(s1.getAccumulatedCost(), s2.getAccumulatedCost());
            }
        }
        if(specificPuzzle==null)return null;
        PriorityQueue<AState> PQ = new PriorityQueue<AState>(new AStateComparerator());
        return super.solve(specificPuzzle,PQ);
    }
}
