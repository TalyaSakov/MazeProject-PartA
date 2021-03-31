package algorithms.maze3D;

import algorithms.mazeGenerators.Position;
import algorithms.search.MazeState;

import java.util.List;

public class Maze3D {

    int[][][] map;
    Position3D startPosition;
    Position3D goalPosition;
    int row_maze3D;
    int column_maze3D;
    int depth_maze3D;


    public int[][][] getMap(){return map;}
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

    public void setStartPosition(int row_maze3D, int column_maze3D, int depth_maze3D) {
        startPosition = new Position3D(row_maze3D, column_maze3D,depth_maze3D);
    }
    public void setGoalPositionPosition(int row_maze3D, int column_maze3D, int depth_maze3D) {
        goalPosition = new Position3D(row_maze3D, column_maze3D,depth_maze3D);
    }




//    public String toString(List<MazeState> list) {
//        final char PASSAGE_CHAR = '*';
//        final char WALL_CHAR = 'X';
//        final char MARKED_CHAR = 'S';
//        boolean[][][] markedMaze;
//        markedMaze = new boolean[this.getRow_maze3D()][this.getColumn_maze3D()][this.getDepth_maze3D()];
//        for (int i = 0; i < list.size(); i++) {
//            int col = list.get(i).getColumn();
//            int row = list.get(i).getRow();
//
//            markedMaze[row][col] = true;
//        }
//        final StringBuffer b = new StringBuffer();
//
//        for (int x = 0; x < row_maze3D; x++) {
//            for (int y = 0; y < column_maze3D; y++)
//                for (int z=0; z<depth_maze3D; z++)
//                if (markedMaze[x][y][z] == true) {
//                    b.append(MARKED_CHAR);
//                } else {
//                    b.append(maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
//                }
//            b.append('\n');
//        }
//        b.append('\n');
//        return b.toString();
//    }
//
//    public String toString() {
//        final char PASSAGE_CHAR = '*';
//        final char WALL_CHAR = 'X';
//        final StringBuffer b = new StringBuffer();
//
//        for (int x = 0; x < rows; x++) {
//
//            for (int y = 0; y < column; y++)
//                b.append(maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
//
//            b.append('\n');
//        }
//
//        b.append('\n');
//        return b.toString();
//    }


    public Maze3D(int row_maze3D, int column_maze3D, int depth_maze3D) {
        this.row_maze3D = row_maze3D;
        this.column_maze3D = column_maze3D;
        this.depth_maze3D = depth_maze3D;
        this.startPosition = new Position3D(0, 0, 0);
        this.goalPosition = new Position3D(0, 0,0);
        map = new int[row_maze3D][column_maze3D][depth_maze3D];
        int i, j,z;
        for (i = 0; i < this.column_maze3D; i++) {
            for (j = 0; j < this.row_maze3D; j++) {
                for (z=0; z<this.depth_maze3D;z++){
                    map[j][i][z] = 1;
                }

            }
        }
    }

    public void print() {
        System.out.println(this);
    }

}
