package algorithms.search;

import java.util.ArrayList;
import java.util.List;

public interface ISearchable {

    public List<AState> getAllPossibleStates(AState curr_state);

    public List<AState> getAllPossibleStates(AState curr_state, String searchingAlgorithm);

    public AState getStart();

    public AState getEnd();

}
