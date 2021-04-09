package algorithms.search;
import java.util.Comparator;
import java.util.Objects;

/**
 * Class referring to an abstract state.
 */
public abstract class AState {

    /**
     * Each an every state has 3 field, parent state,
     state cost and the amount of cost accumulated till the current state.
     */
    public AState parent;
    public int cost;
    public int accumulatedCost;

    /**
     * sets the accumulated cost till the current state.
     * @param accumulatedCost
     */
    public void setAccumulatedCost(int accumulatedCost ) {this.accumulatedCost = accumulatedCost ;}

    /**
     * gets the state's accumulated cost.
     * @return accumulatedCost field.
     */
    public int getAccumulatedCost() {
        return accumulatedCost;
    }

    /**
     * gets the state's cost.
     * @return cost field.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Default AState constructor - sets the state's cost as 0.
     */
    public AState() { this.cost = 0;}

    /**
     * sets the state's parent.
     */
    public abstract void setParent(AState parent);

    /**
     * gets the state's parent.
     * @return ASate parent.
     */
    public abstract AState getParent();

    /**
     * set the state's parent as null.
     */
    public abstract void setParentNull();

}
