package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return 0;
    }

    @Override
    public Solution solve(ISearchable specificPuzzle) {
            AState startState = specificPuzzle.getStart();
            Queue<AState> stack = new LinkedList<>();
            HashSet<AState> visited = new HashSet<>();
            stack.push(startState);
            while(!stack.isEmpty() || (!(stack.peek().equals(specificPuzzle.getEnd().getRow(),specificPuzzle.getEnd().getColumn())))){
                AState tmp = stack.pop();
                if(!visited.contains(tmp)){
                    visited.add(tmp);
                    List<AState> possibleStates = specificPuzzle.getAllPossibleStates(tmp);
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
    }
    private Solution getSolution(AState tmp) {
        Solution solution = new Solution();
        solution.add(tmp);
        this.numOfNodesEvaluated++;
        while (tmp.getParent() != null){
            solution.add(tmp.getParent());
            this.numOfNodesEvaluated++;
            tmp = tmp.getParent();
        }
        return solution;
    }
}
