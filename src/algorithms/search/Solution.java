package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    ArrayList<AState> path;

    public ArrayList<AState> getPath() {
        return path;
    }

    public Solution() {
        this.path = new ArrayList<AState>();
    }
    public boolean contains(AState temp){
        return path.contains(temp);
    }

    public void add(AState tmp) {
        path.add(tmp);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "path=" + path +
                '}';
    }
}
