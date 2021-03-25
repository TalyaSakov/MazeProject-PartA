package algorithms.mazeGenerators;

public class Position {
    int row;
    int column;

    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return column;
    }

    @Override
    public String toString() {
        return "{"+row+","+column+"}";
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    Position(int row , int column){
        this.row = row;
        this.column = column;
    }
}


