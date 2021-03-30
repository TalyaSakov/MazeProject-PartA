package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    int numOfNodesEvaluated;
    int sum;
    int sumCost;

    @Override
    public String getName() {
        return "Breadth First Search";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return this.numOfNodesEvaluated;
    }

    @Override
    public Solution solve(ISearchable specificPuzzle) { //Wrapper function
            Queue<AState> queue = new LinkedList<>();
            return solve(specificPuzzle, queue);}

    public Solution solve(ISearchable specificPuzzle,Queue<AState> queue) {
            sumCost = 0;
            AState startState = specificPuzzle.getStart();
            HashSet<AState> visited = new HashSet<>();
            queue.add(startState);
            while(!queue.isEmpty()){
                if ((queue.peek().equals(specificPuzzle.getEnd()))){break;}
                AState tmp = queue.poll();
                if(!visited.contains(tmp)){
                    visited.add(tmp);
                    sumCost += tmp.getCost();
//                    System.out.println(tmp);
                    List<AState> possibleStates = specificPuzzle.getAllPossibleStates(tmp);
                    if (possibleStates.size() == 0){
                        sumCost -= tmp.getSumCost();
                        tmp.setParentNull();
                        continue;}
                    for(AState adjacent: possibleStates){
                        adjacent.setParent(tmp);
                        adjacent.setSumCost(sumCost + adjacent.getCost());
                        queue.add(adjacent);}
                }
            }
        if (queue.peek() != null && queue.peek().equals(specificPuzzle.getEnd())){
                return getSolution(queue.poll());
            }
        System.out.println("ERROR!!!");
        return null;
        }

    private Solution getSolution(AState tmp) {
        int sum = 0;
        Solution solution = new Solution();
        solution.add(tmp);
        this.numOfNodesEvaluated++;
        sum += tmp.getCost();
        while (tmp.getParent() != null){
            solution.add(tmp.getParent());
            sum += tmp.getParent().getCost();
            this.numOfNodesEvaluated++;
            tmp = tmp.getParent();
        }
        System.out.println(sum);
        return solution;
    }
}
