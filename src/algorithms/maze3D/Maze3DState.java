package algorithms.maze3D;
import algorithms.search.AState;
import java.util.Objects;

/**
 * Class of a state within the 3D maze.
 */
public class Maze3DState extends AState {


    private final Position3D current_position; //Current position field.

    /**
     * Getters for the 3D position fields.
     */
    public int getRow() { return current_position.getRowIndex();}
    public int getColumn() { return current_position.getColumnIndex(); }
    public int getDepth() { return current_position.getDepthIndex();}

    public Maze3DState(int depth,int row, int column){
            super();
            this.current_position = new Position3D(depth,row,column);
        }

    /**
     * Equals function between two maze3DSates.
     */
    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            algorithms.maze3D.Maze3DState maze3DState = (algorithms.maze3D.Maze3DState) o;
            return Objects.equals(current_position, maze3DState.current_position);
        }

    /**
     * toString function - using the 3DPosition's toString.
     * @return
     */
    @Override
        public String toString() {
            return current_position.toString();
        }

    /**
     *
      * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(current_position);
    }
    @Override
    public void setParent(AState father) {
        this.parent = father;}
    @Override
    public AState getParent() {
        return parent;
    }
    @Override
    public void setParentNull() {
        this.parent = null;
    }

    }

