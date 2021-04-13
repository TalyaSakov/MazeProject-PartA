package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    int numOfNodesEvaluated;

    @Override
    /**
     * @return name of the algorithm - "DepthFirstSearch".
     */
    public String getName() {
        return "DepthFirstSearch";
    }

    @Override
    /**
     * @return number of nodes evaluated.
     */
    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

    @Override
    /**
     * Search algorithm, with each step advanced in depth in order to find a way to the solution.
     * Returns an optional path to the solution
     */
    public Solution solve(ISearchable specificPuzzle) {
        if (specificPuzzle==null) throw new RuntimeException("The specific puzzle recited is null");
        AState startState = specificPuzzle.getStart();
        Stack<AState> stack = new Stack<>();
        HashSet<AState> visited = new HashSet<>();
        stack.push(startState);
        while(!stack.isEmpty()){ //While the stack isn't empty
            if ((stack.peek().equals(specificPuzzle.getEnd()))){break;}
            AState tmp = stack.pop();
            if(!visited.contains(tmp)){
                visited.add(tmp); //add the current state to visited.
                List<AState> possibleStates = specificPuzzle.getAllSuccessors(tmp); //Get all possible moves from the current state.
                if (possibleStates.size() == 0){ // To avoid turning back
                    tmp.setParentNull();
                    continue;}
                for(AState n : possibleStates){
                    n.setParent(tmp);
                    stack.push(n);}
            }
        }
        if (stack.peek().equals(specificPuzzle.getEnd())){
            return getSolutionDFS(stack.pop());
        }
        return null;
    }

    private Solution getSolutionDFS(AState tmp) {
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