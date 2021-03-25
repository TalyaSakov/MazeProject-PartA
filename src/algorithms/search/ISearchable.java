package algorithms.search;

import java.util.List;

public interface ISearchable {

    public List<AState> getAllPossibleStates(AState curr_state);
    public AState getStart();
    public AState getEnd();



}
