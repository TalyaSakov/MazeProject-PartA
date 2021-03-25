package algorithms.search;

import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    Stack<AState> DFS_stack;

    @Override
    public String getName() {
        return "Depth First Search";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

    @Override
    public Solution solve(ISearchable specificPuzzle) {
        AState startState = specificPuzzle.getStart();
        Stack<AState> stack = new Stack<>();
        Solution visited = new Solution();
        stack.push(startState);
        while(!stack.isEmpty()){
            AState tmp = stack.pop();
            if(!visited.contains(tmp)){
                visited.add(tmp);
                for(AState n : specificPuzzle.PossibleStates(tmp))
                    stack.push(n);
            }
        }
        return visited;
    }
}
