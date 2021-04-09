package algorithms.maze3D;

import java.util.Objects;

/**
 * Position3D class contains 3 fields - row, column, depth.
 */
public class Position3D {
    int row;
    int column;
    int depth;

    @Override
    public String toString() {
        return "{" +
                + depth +
                ","+ row +
                ","+ column +
                '}';
    }

    public Position3D(int depth_maze3D , int row_maze3D, int column_maze3D){
        this.depth=depth_maze3D;
        this.row=row_maze3D;
        this.column=column_maze3D;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position3D that = (Position3D) o;
        return row == that.row &&
                column == that.column &&
                depth == that.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, depth);
    }

    public int getRowIndex() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumnIndex() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDepthIndex() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }




}
