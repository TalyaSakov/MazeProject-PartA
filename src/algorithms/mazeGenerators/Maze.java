package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {
    int [][] maze;
    int rows;
    int column;

    public Maze(int column, int rows) {
        this.rows = rows;
        this.column = column;
        maze = new int[column][rows];
        int i,j;
        for  (i=0;i<this.column;i++){
            for (j=0;j<this.rows;j++){
                maze[i][j]=0;
            }
}
        System.out.println(Arrays.deepToString(maze));
    }}
