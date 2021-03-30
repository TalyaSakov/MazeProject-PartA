package algorithms.search;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstSearch extends BreadthFirstSearch {
    @Override
    public int getNumberOfNodesEvaluated() {
        return super.getNumberOfNodesEvaluated();
    }

    @Override
    public String getName() {
        return "Best First Search";
    }

    @Override
    public Solution solve(ISearchable specificPuzzle) {
        class AStateComparerator implements Comparator<AState> {
            @Override
            public int compare(AState s1, AState s2) {
                return Integer.compare(s1.getCost(), s2.getCost());
            }
        }
        PriorityQueue<AState> PQ = new PriorityQueue<AState>(new AStateComparerator());
        return super.solve(specificPuzzle,PQ,"BestFS");
    }
}
