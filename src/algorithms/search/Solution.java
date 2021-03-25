package algorithms.search;

import java.util.HashSet;

public class Solution {
    HashSet<AState> path;


    public Solution() {
        this.path = new HashSet<AState>();
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
