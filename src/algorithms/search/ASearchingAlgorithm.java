package algorithms.search;


public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    protected Solution sol;
    protected int numOfNodesEvaluated = 0;

    /**
     * constructor- Initialized the sol field.
     */
    public ASearchingAlgorithm(){sol = new Solution();}

    /**
     * @return name of the algorithm in which we are using in the search.
     */
    public abstract String getName();

    /**
     * @param isearch- The structure on which you want to perform the search
     * @return the solution path
     */
    public abstract Solution solve(ISearchable isearch);

    /**
     * @return number of nodes evaluated.
     */
    public int getNumOfNodesEvaluated(){return numOfNodesEvaluated;}

}
