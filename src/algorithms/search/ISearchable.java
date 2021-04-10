package algorithms.search;

import java.util.ArrayList;
import java.util.List;

/**
 * An interface that defines for a problem what functionality it needs to provide
 * in order it could get a solution .
 */
public interface ISearchable {
    /**
     * @param curr_state
     * @returna list of all optional successors of a current state.
     */
    public List<AState> getAllSuccessors(AState curr_state);

    /**
     * @return the start state.
     */
    public AState getStart();

    /**
     * @return the end state.
     */
    public AState getEnd();

}
