package algorithms.search;
import java.util.Comparator;
import java.util.Objects;

public abstract class AState {
    AState parent;
    int cost;

    public int getCost() {
        return cost;
    }

    public AState() {
//        this.row = row;
//        this.column = column;
        this.cost = 0;
    }
//    Position position;

//
//    @Override
//    public String toString() {
//        return "AState{" +
//                "row=" + row+
//                ", column=" + column +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AState aState = (AState) o;
//        return row == aState.getRow() &&
//                column == aState.getColumn();
//    }
//
//    public boolean equals(int row, int column) {
//        return this.row == row && this.column == column;
//    }
//
//
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(row, column);
//    }
//
//    public int getRow() {
//        return row;
//    }
//
//    public int getColumn() {
//        return column;
//    }

    public abstract void setParent(AState parent);
    public abstract AState getParent();
    public abstract void setParentNull();

//    public Position getPosition() {
//        return position;
//    }
}
