package algorithms.mazeGenerators;

import java.util.Objects;
/**
 * Position class contains 2 fields - row, column.
 */
public class Position {
    int row;
    int column;

    /**
     * @return the position row index.
     */
    public int getRowIndex() {
        return row;
    }

    /**
     * @return the position column index.
     */
    public int getColumnIndex() {
        return column;
    }

    @Override
    /**
     * prints the position row and column index.
     */
    public String toString() {
        return "{"+row+","+column+"}";
    }

    /**
     * sets the row position field.
     * @param row - Start position row index.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * sets the column position field.
     * @param column - Start position column index.
     */
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    /**
     * compering between 2 positions
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row &&
                column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    /**
     * constructor - build new position from a given indexes.
     * @param row
     * @param column
     */
    public Position(int row , int column){
        this.row = row;
        this.column = column;
    }
}


