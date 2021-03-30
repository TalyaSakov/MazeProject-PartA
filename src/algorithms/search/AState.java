package algorithms.search;
import java.util.Comparator;
import java.util.Objects;

public abstract class AState {
    AState parent;
    int cost;

    public int getCost() {
        return cost;
    }
    public AState() {
        this.cost = 0;
    }
    public abstract void setParent(AState parent);
    public abstract AState getParent();
    public abstract void setParentNull();

}
