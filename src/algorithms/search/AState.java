package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public abstract class AState {
    algorithms.mazeGenerators.Position position;
    AState parent;
    int cost;

    public int getCost() {
        return cost;
    }

    public AState(int row, int column) {
        this.position = new Position(row,column);
        this.cost = 0;
    }
//    Position position;


    @Override
    public String toString() {
        return "AState{" +
                "row=" + position.getRowIndex() +
                ", column=" + position.getColumnIndex() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return position.getRowIndex() == aState.position.getRowIndex() &&
                position.getColumnIndex() == aState.position.getColumnIndex();
    }

    public boolean equals(int row, int column) {
        return this.position.getRowIndex() == row && this.position.getColumnIndex() == column;
    }




    @Override
    public int hashCode() {
        return Objects.hash(position.getRowIndex(), position.getColumnIndex());
    }

    public int getRow() {
        return position.getRowIndex();
    }

    public int getColumn() {
        return position.getColumnIndex();
    }

    public abstract void setParent(AState parent);
    public abstract AState getParent();
    public abstract void setParentNull();

//    public Position getPosition() {
//        return position;
//    }
}
