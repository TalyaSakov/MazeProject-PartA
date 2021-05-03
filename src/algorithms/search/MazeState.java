package algorithms.search;
import java.io.Serializable;
import java.util.Comparator;
import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState implements Serializable {
    private final Position current_position;

    /**
     * @return current row index.
     */
    public int getRow() {
        return current_position.getRowIndex();
    }

    /**
     * @return current column index.
     */
    public int getColumn() {
        return current_position.getColumnIndex();
    }

    /**
     * constructor- initialized mazeState fields.
     * @param row - current roe index
     * @param column- current column index
     * @param cost - cost of the step to the current position
     */
    public MazeState(int row, int column, int cost){
        super();
        this.current_position = new Position(row,column);
        this.cost = cost;
    }

    /**
     * constructor- initialized mazeState fields.
     * @param row - current roe index
     * @param column- current column index
     * */
    public MazeState(int row, int column){
        super();
        this.current_position = new Position(row,column);
    }

    @Override
    /**
     * compering between 2 mazeStates.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeState mazeState = (MazeState) o;
        return Objects.equals(current_position, mazeState.current_position);
    }
    @Override
    public String toString() {
        return current_position.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(current_position);
    }
    @Override
    /**
     * initialized parent field.
     */
    public void setParent(AState father) {
        this.parent = father;}

    @Override
    /**
     * return parent.
     */
    public AState getParent() {
        return parent;
    }

    @Override
    /**
     * initialized parent field as null.
     */
    public void setParentNull() {
        this.parent = null;
    }


}
