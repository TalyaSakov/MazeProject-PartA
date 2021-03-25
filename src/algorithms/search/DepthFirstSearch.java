package algorithms.search;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

//    Stack<AState> DFS_stack;

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
        HashSet<AState> visited = new HashSet<>();
        stack.push(startState);
        while(!stack.isEmpty()){
            if ((stack.peek().equals(specificPuzzle.getEnd().getRow(),specificPuzzle.getEnd().getColumn()))){break;}
            AState tmp = stack.pop();
            if(!visited.contains(tmp)){
                visited.add(tmp);
                List<AState> possibleStates = specificPuzzle.PossibleStates(tmp);
                if (possibleStates.size() == 0){
                    tmp.setParentNull();
                    continue;}
                for(AState n : possibleStates){
                    n.setParent(tmp);
                    stack.push(n);}
            }
        }
        if (stack.peek().equals(specificPuzzle.getEnd().getRow(),specificPuzzle.getEnd().getColumn())){
            return getSolution(stack.pop());
        }
        return null;
    }

    private Solution getSolution(AState tmp) {
        Solution solution = new Solution();
        while (tmp.getParent() != null){
            solution.add(tmp.getParent());
            tmp = tmp.getParent();
        }
        System.out.println(solution.getPath().size());
        return solution;
    }
}
