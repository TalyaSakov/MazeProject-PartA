package algorithms.search;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch {
    @Override
    public int getNumberOfNodesEvaluated() {
        return super.getNumberOfNodesEvaluated();
    }

    @Override
    public String getName() {
        return "BestFirstSearch";
    }

    @Override
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
