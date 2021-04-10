package algorithms.mazeGenerators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
    /**
     * Generate a new maze.
     * set the start and goal position as the corners of the maze
     * @param rows - Maze's row
     * @param column - Maze's column
     * @return - a new maze .
     */
     public Maze generate(int column, int rows) {
        if (rows < 2 || column < 2){throw new RuntimeException("Maze must be greater then 2X2");}
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
        maze.setEndPosition(rows - 1, column -1);
        maze.setStartPosition(0, 0);

        return maze;
    }
}
