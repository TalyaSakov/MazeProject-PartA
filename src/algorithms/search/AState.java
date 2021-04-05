package algorithms.search;
import java.util.Comparator;
import java.util.Objects;

public abstract class AState {
    public AState parent;
    public int cost;
    public int sumCost;

    public void setSumCost(int sumCost) {
        this.sumCost = sumCost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getSumCost() {
        return sumCost;
    }
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
