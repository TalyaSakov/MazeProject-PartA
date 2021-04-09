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


    /**
     * @return the maze's map field.
     */
    public int[][][] getMaze3DMap(){return map;}

    /**
     * @return the maze's start Position (Position3D class).
     */
    public Position3D getStartPosition(){return startPosition;}

    /**
     * @return the maze's end Position (Position3D class).
     */
    public Position3D getGoalPosition(){return goalPosition;}

    /**
     * @return the maze's row amount.
     */
    public int getRow_maze3D() {
        return row_maze3D;
    }

    /**
     * @return the maze's column amount.
     */
    public int getColumn_maze3D() {
        return column_maze3D;
    }

    /**
     * @return the maze's depth.
     */
    public int getDepth_maze3D() {
        return depth_maze3D;
    }

    /**
     * Make a new Position3D instance and make it as the startPosition field.
     * @param depth_maze3D - Start position depth.
     * @param row_maze3D - Start position row.
     * @param column_maze3D - Start position column.
     */
    public void setStartPosition(int depth_maze3D, int row_maze3D, int column_maze3D) {
        startPosition = new Position3D(depth_maze3D,row_maze3D, column_maze3D);
    }

    /**
     * Make a new Position3D instance and make it as the goalPosition field.
     * @param depth_maze3D - Goal position depth.
     * @param row_maze3D - Goal position row.
     * @param column_maze3D - Goal position column.
     */
    public void setGoalPositionPosition(int depth_maze3D, int row_maze3D, int column_maze3D) {
        goalPosition = new Position3D(depth_maze3D,row_maze3D, column_maze3D);
    }


    /**
     * Maze3D class default constactur.
     * initializing fields and make the maze full of 1's.
     * @param depth_maze3D
     * @param row_maze3D
     * @param column_maze3D
     */
    public Maze3D(int depth_maze3D,int row_maze3D, int column_maze3D) {
    //constructor -build the maze with walls only, start and goal positions
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

    /**
     * Given by the course practice.
     */
    public void print() {
            System.out.println("{");
            for(int depth = 0; depth < map.length; depth++){
                for(int row = 0; row < map[0].length; row++) {
                    System.out.print("{ ");
                    for (int col = 0; col < map[0][0].length; col++) {
                        if (depth == startPosition.getDepthIndex() && row == startPosition.getRowIndex() && col == startPosition.getColumnIndex()) // if the position is the start - mark with S
                            System.out.print("S ");
                        else {
                            if (depth == goalPosition.getDepthIndex() && row == goalPosition.getRowIndex() && col == goalPosition.getColumnIndex()) // if the position is the goal - mark with E
                                System.out.print("E ");
                            else
                                System.out.print(map[depth][row][col] + " ");
                        }
                    }
                    System.out.println("}");
                }
                if(depth < map.length - 1) {
                    System.out.print("---");
                    for (int i = 0; i < map[0][0].length; i++)
                        System.out.print("--");
                    System.out.println();
                }
            }
            System.out.println("}");
        }
    }


