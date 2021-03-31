package algorithms.maze3D;

public class Position3D {
    int row;
    int column;
    int depth;

    public Position3D(int depth_maze3D, int row_maze3D, int column_maze3D){
        this.row=row_maze3D;
        this.column=column_maze3D;
        this.depth=depth_maze3D;
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
