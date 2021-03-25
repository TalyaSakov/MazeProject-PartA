package algorithms.search;

import algorithms.mazeGenerators.Position;

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
