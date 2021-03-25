package algorithms.search;

public interface ISearchingAlgorithm {
    Solution solve(ISearchable iSearch);
    String getName();
    int getNumberOfNodesEvaluated();
}
