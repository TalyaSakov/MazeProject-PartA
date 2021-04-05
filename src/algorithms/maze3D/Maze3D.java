package algorithms.maze3D;

import algorithms.mazeGenerators.Position;
import algorithms.search.MazeState;

import java.util.List;

public class Maze3D {

    int[][][] map;
    Position3D startPosition;
    Position3D goalPosition;
    int depth_maze3D;
    int row_maze3D;
    int column_maze3D;



    public int[][][] getMaze3D(){return map;}
    public Position3D getStartPosition(){return startPosition;}
    public Position3D getGoalPosition(){return goalPosition;}

    public int getRow_maze3D() {
        return row_maze3D;
    }

    public int getColumn_maze3D() {
        return column_maze3D;
    }

    public int getDepth_maze3D() {
        return depth_maze3D;
    }

    public void setStartPosition(int depth_maze3D, int row_maze3D, int column_maze3D) {
        startPosition = new Position3D(depth_maze3D,row_maze3D, column_maze3D);
    }
    public void setGoalPositionPosition(int depth_maze3D, int row_maze3D, int column_maze3D) {
        goalPosition = new Position3D(depth_maze3D,row_maze3D, column_maze3D);
    }


    public String toString() {
        final char PASSAGE_CHAR = '0';
        final char WALL_CHAR = '1';
        final char START_CHAR = 'S';
        final char END_CHAR = 'E';
        final StringBuffer b = new StringBuffer();
        b.append('{');
        b.append('\n');
        for (int depth = 0; depth < depth_maze3D ; depth++) {
            for (int x = 0; x < row_maze3D; x++) {
                b.append("{ ");
                for (int y = 0; y < column_maze3D; y++)
                    if (x == startPosition.row && y == startPosition.column && depth == startPosition.depth){
                        b.append(START_CHAR);
                        b.append(' ');}
                    else if (x == goalPosition.row && y == goalPosition.column && depth == goalPosition.depth){
                        b.append(END_CHAR);
                        b.append(' ');}
                    else{
                        b.append(map[depth][x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
                        b.append(' ');}
                b.append("}");
                b.append('\n');
            }
            if (depth < depth_maze3D - 1){
                for (int i = 0; i < (column_maze3D - 1) *2 +5 ; i++) {
                    b.append('-');

                }
                b.append('\n');
            }
        }
        b.append('}');
        return b.toString();
    }




    public Maze3D(int depth_maze3D,int row_maze3D, int column_maze3D) {

        this.row_maze3D = row_maze3D;
        this.column_maze3D = column_maze3D;
        this.depth_maze3D = depth_maze3D;
        this.startPosition = new Position3D(0, 0, 0);
        this.goalPosition = new Position3D(0, 0,0);

        map = new int[depth_maze3D][row_maze3D][column_maze3D];
        int i, j,z;
        for (i = 0; i < this.depth_maze3D; i++) {
            for (j = 0; j < this.row_maze3D ; j++) {
                for (z=0; z < this.column_maze3D;z++){
                    map[i][j][z] = 1;

                }
            }
        }
    }

    public void print() {
        System.out.println(this);
    }

}
