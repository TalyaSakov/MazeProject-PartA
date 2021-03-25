package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    protected Solution sol;
    protected int numOfNodesEvaluated = 0;

    public ASearchingAlgorithm(){sol = new Solution();}

    public abstract String getName();
    public abstract Solution solve(ISearchable isearch);

    public int getNumOfNodesEvaluated(){return numOfNodesEvaluated;}


}
