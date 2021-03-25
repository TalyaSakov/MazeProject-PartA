package algorithms.mazeGenerators;

import java.util.Arrays;

public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
     public Maze generate(int column, int rows) {
        Maze maze =  new Maze(column,rows);
        for (int i = 1; i < rows ; i++) {
            maze.maze[column -1][i] = 0;
        }
        for (int i = 0; i < column; i++) {
            maze.maze[i][0] = 0;
        }
        for (int i = 0; i < maze.column -1 ; i++) {
            for (int j = 1 ; j < maze.rows ; j++) {
                maze.maze[i][j] = (int) Math.round(Math.random());
            }
        }
        return maze;
    }
}
