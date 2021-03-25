package algorithms.search;

import java.util.List;

public interface ISearchable {

    public List<AState> PossibleStates(AState curr_state);
    public AState getStart();



}
