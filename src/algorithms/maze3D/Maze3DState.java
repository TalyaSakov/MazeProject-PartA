package algorithms.maze3D;
import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.MazeState;

import java.util.Objects;

public class Maze3DState extends AState {


    private final Position3D current_position;

    public int getRow() { return current_position.getRowIndex();}
    public int getColumn() { return current_position.getColumnIndex(); }
    public int getDepth() { return current_position.getDepthIndex();}


    public Maze3DState(int depth,int row, int column){
            super();
            this.current_position = new Position3D(depth,row,column);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            algorithms.maze3D.Maze3DState maze3DState = (algorithms.maze3D.Maze3DState) o;
            return Objects.equals(current_position, maze3DState.current_position);
        }

        @Override
        public String toString() {
            return "Maze3DState{" +
                    current_position +
                    '}';
        }
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

