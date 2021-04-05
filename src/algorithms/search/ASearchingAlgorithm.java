package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    protected Solution sol;
    protected int numOfNodesEvaluated = 0;

    public ASearchingAlgorithm(){sol = new Solution();}

    public abstract String getName();
    public abstract Solution solve(ISearchable isearch);

    public int getNumOfNodesEvaluated(){return numOfNodesEvaluated;}

   public Solution getSolution(AState tmp) {
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
