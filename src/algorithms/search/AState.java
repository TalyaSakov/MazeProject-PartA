package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public abstract class AState {
    int row;
    int column;
//    Position position;


    @Override
    public String toString() {
        return "AState{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return row == aState.row &&
                column == aState.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

//    public Position getPosition() {
//        return position;
//    }
}
