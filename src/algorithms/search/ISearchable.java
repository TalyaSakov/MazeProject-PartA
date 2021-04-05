package algorithms.search;

import java.util.ArrayList;
import java.util.List;

public interface ISearchable {

    public List<AState> getAllSuccessors(AState curr_state);

    public AState getStart();

    public AState getEnd();

}
