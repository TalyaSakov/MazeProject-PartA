package algorithms.search;

    /**
     * An interface that defines functionality for solving search problems.
     */
public interface ISearchingAlgorithm {
        /**
         * @param iSearch- The structure on which you want to perform the search
         * @return the solution path
         */
    Solution solve(ISearchable iSearch);

        /**
         * @return name of the algorithm in which we are using in the search.
         */
    String getName();

        /**
         * @return number of nodes evaluated.
         */
    int getNumberOfNodesEvaluated();
}
