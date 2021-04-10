package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    private final ArrayList<AState> path;

    /**
     * initialized the path field
     */
    public Solution() {
        this.path = new ArrayList<AState>();
    }

    /**
     * @param temp- current AState
     * @return true or false depending on whether the list contains temp
     */
    public boolean contains(AState temp){
        return path.contains(temp);
    }

    /**
     * Adding an AState to the path list
     * @param tmp- current AState
     */
    public void add(AState tmp) {
        path.add(tmp);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "path=" + path +
                '}';
    }

    /**
     * @return a list of all the AState in the solution
     */
    public ArrayList<AState> getSolutionPath()
    {
        Collections.reverse(path);
        return path;
    }
}
